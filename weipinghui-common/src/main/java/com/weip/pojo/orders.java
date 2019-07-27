package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:47
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class orders
{
   private String o_id;//订单编号
   private int o_uid;//用户编号外键
   private String o_uname;//用户的名字
   private Date o_date;//创建订单的时间
   private double o_sum;//订单金额
   //private int o_status;//订单状态，应该是在小定单里面，应为发货的商家不一样
}

