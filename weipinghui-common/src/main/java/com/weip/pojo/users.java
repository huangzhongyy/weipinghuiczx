package com.weip.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/10 10:10
 * @Author: Mr.Deng
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class users implements Serializable
{
   private int uid;//用户ID
   private String username;//用户名字
   private String password;//用户密码
   private String email;//邮箱
   private String phone;//电话号码
   private String address;//收货地址
   private String utype;//用户类型
}
