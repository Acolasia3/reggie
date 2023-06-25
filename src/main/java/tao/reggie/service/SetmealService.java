package tao.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import tao.reggie.dto.DishDto;
import tao.reggie.dto.SetmealDto;
import tao.reggie.entity.Setmeal;

import java.util.List;

@Service
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

    //根据id查询套餐信息和对应的菜品信息
    public SetmealDto getByIdWithFlavor(Long id);

    //更新套餐信息，同时更新对应的菜品信息
    public void updateWithDish(SetmealDto setmealDto);
}
