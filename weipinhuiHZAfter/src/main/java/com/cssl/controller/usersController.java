package com.cssl.controller;

import com.cssl.service.usersService;
import com.alicom.dysms.api.*;
import com.weip.pojo.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
 int num;//短信验证码
 /**
  * 注册
  * @param user
  * @return
  */
 @RequestMapping("/regist")
 @ResponseBody
 public int Regist(@RequestBody users user){
  System.out.println("用户名控制器----"+user.getUsername());
  return usersservice.usersRegist(user);
 }

 /**
  * 短信
  * @param phone
  * @return
  * @throws Exception
  */
 @RequestMapping("/sms")
 @ResponseBody
 public int sms(@RequestBody String phone) throws Exception
 {
  System.out.println("手机号码-------------"+phone);
   num=(int)(1000+Math.random()*9999);//获取随机数
  String numString=String.valueOf(num);
  if(numString.length()>4){
   numString=numString.substring(0,4);
   num=Integer.parseInt(numString);
  }
  System.out.println("----------------"+num);
  System.out.println("第一次哦哦");
  SmsDemo.run(phone,num);
  return num;
 }

 /**
  * 验证
  * @param phone
  * @return
  */
 @RequestMapping("/pp")
 @ResponseBody
 public users YzPhone(@RequestBody String phone){

  return usersservice.SelectPhone(phone);
 }


}
