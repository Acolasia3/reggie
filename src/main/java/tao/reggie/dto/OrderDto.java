package tao.reggie.dto;

import tao.reggie.entity.DishFlavor;
import tao.reggie.entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭桂涛
 * @version 1.0
 */
public class OrderDto {

    private List<OrderDetail> orderDetails = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
