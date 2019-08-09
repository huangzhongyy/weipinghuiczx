package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;


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
public class Order_detail
{
   private String od_id;//订单详情ID
   private int od_uid;//用户ID
   private String od_uname;//用户名字
   private int od_sid;//商家ID
   private int od_gid;//订单对应的商品ID
   private int od_quantity;//买了几个商品
   private double od_summoney;//总价
   private int od_status;//订单状态
   private Date od_date;//订单日期
}
