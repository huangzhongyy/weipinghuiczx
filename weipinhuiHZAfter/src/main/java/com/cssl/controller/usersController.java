package com.cssl.controller;

import com.cssl.service.usersService;

import com.weip.pojo.goods;
import com.weip.pojo.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:53
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class usersController {

 @Autowired
 private usersService usersservice;

 /**
  * 注册
  * @param user
  * @return
  */
 @RequestMapping("/regist")
 public int Regist(users user){
  System.out.println("用户名----"+user.getUsername());
  return usersservice.usersRegist(user);
 }


}
