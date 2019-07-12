package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/11 19:50
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class shanjia
{
   private int s_id;//商家ID
   private String s_pwd;//商家密码
   private String s_name;//商家名称
   private String s_sex;//商家性别
   private String s_address;//商家地址
   private String s_phone;//商家电话
}
