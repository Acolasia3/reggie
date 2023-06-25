package tao.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import tao.reggie.common.R;
import tao.reggie.dto.DishDto;
import tao.reggie.dto.SetmealDto;
import tao.reggie.entity.Category;
import tao.reggie.entity.Setmeal;
import tao.reggie.service.CategoryService;
import tao.reggie.service.SetmealDishService;
import tao.reggie.service.SetmealService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 彭桂涛
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private SetmealDishService setmealDishService;
    
    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        //分页构造器对象
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name != null,Setmeal::getName,name);
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        setmealService.page(pageInfo,queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map((item) -> {
            SetmealDto setmealDto = new SetmealDto();
            //对象拷贝
            BeanUtils.copyProperties(item,setmealDto);
            //分类id
            Long categoryId = item.getCategoryId();
            //根据分类id查询分类对象
            Category category = categoryService.getById(categoryId);
            if(category != null){
                //分类名称
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }
    
    @PostMapping
    @CacheEvict(value="setmealCache",allEntries = true)
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("套餐信息：{}",setmealDto);

        setmealService.saveWithDish(setmealDto);

        return R.success("新增套餐成功");
    }

    @DeleteMapping
    //删除所有套餐缓存数据
    @CacheEvict(value="setmealCache",allEntries = true)
    public R<String> delete(@RequestParam List<Long> ids){
        log.info("ids:{}",ids);
        setmealService.removeWithDish(ids);

        return R.success("套餐数据删除成功");
    }

    @PostMapping("/status/{status}")
    public R<String> updateStatusById(@PathVariable Integer status,@RequestParam List<Long> ids){
        for (int i = 0; i < ids.size(); i++) {
            Long id = ids.get(i);
            Setmeal setmeal = setmealService.getById(id);
            setmeal.setStatus(status);
            setmealService.updateById(setmeal);
        }
        return R.success("修改状态成功");
    }
    
    /**
     * 根据条件查询套餐数据(前台显示套餐信息)
     * @param setmeal
     * @return
     */
    //套餐展示数据缓存
    @Cacheable(value="setmealCache",key="#setmeal.categoryId +'_'+ #setmeal.status")
    @GetMapping("/list")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId() != null,Setmeal::getCategoryId,setmeal.getCategoryId());
        queryWrapper.eq(setmeal.getStatus() != null,Setmeal::getStatus,setmeal.getStatus());
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        List<Setmeal> list = setmealService.list(queryWrapper);

        return R.success(list);
    }

    @GetMapping("/{id}")
    public R<Setmeal> get(@PathVariable Long id) {
        SetmealDto setmealDto = setmealService.getByIdWithFlavor(id);

        return R.success(setmealDto);
    }
    
    @PutMapping
    public R<String> update(@RequestBody SetmealDto setmealDto){
        log.info(setmealDto.toString());
        setmealService.updateWithDish(setmealDto);
        return R.success("套餐修改成功");
        
    }
}
