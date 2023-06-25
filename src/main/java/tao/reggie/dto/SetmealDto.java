package tao.reggie.dto;

import lombok.Data;
import tao.reggie.entity.Setmeal;
import tao.reggie.entity.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
