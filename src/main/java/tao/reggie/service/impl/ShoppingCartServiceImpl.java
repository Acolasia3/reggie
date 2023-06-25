package tao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tao.reggie.entity.ShoppingCart;
import tao.reggie.mapper.ShoppingCartMapper;
import tao.reggie.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
