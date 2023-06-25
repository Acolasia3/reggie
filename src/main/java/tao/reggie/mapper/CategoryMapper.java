package tao.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tao.reggie.entity.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
