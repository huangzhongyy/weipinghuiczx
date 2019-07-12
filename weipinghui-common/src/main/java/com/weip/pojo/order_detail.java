package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:44
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class order_detail
{
   private int od_id;//订单详情ID
   private String od_oid;//订单ID
   private int od_gid;//订单对应的商品ID
   private String od_image;//商品图片
   private int od_quantity;//买了几个商品
   private double od_summoney;//总价
}
