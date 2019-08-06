package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:36
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class goods
{
   private int g_id;//商品编码
   private String g_name;//商品名字
   private String g_description;//商品描述
   private double g_price;//商品价格
   private double g_discount;//商品折扣
   private int g_number;//商品库存
   private String g_image;//商品图片
   private int g_tid;//商品所属分类
   private int g_sid;//商品所属商家

   public goods(String gname,String gdesc,Double gprice,Double gdiscount,int gnumber,String image,int gtype,int sid){
        this.g_name = gname;
        this.g_description = gdesc;
        this.g_price = gprice;
        this.g_discount = gdiscount;
        this.g_number = gnumber;
        this.g_image = image;
        this.g_tid = gtype;
        this.g_sid = sid;
   }
}

