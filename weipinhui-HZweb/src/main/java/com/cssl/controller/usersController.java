package com.cssl.controller;

import com.cssl.service.usersService;
import com.weip.pojo.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 19:33
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class usersController {

 @Autowired
 private usersService usersservice;

public String Regist(users users){
 System.out.println("------------进来了嘛-------------");
 if(this.usersservice.Regist(users)>0){
  return "login.html";
 }
 return "regist.html";
}

}
