package tao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tao.reggie.entity.DishFlavor;
import tao.reggie.mapper.DishFlavorMapper;
import tao.reggie.service.DishFlavorService;


@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
