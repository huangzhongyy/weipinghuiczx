package com.cssl.controller;

import com.cssl.service.UsersServicez;
import com.cssl.shiro.MD5Pwd;
import com.weip.pojo.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 19:33
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class usersController {

 @Autowired
 private UsersServicez userszz;

 @RequestMapping(value = "/ZZregist")
 public String Registz(users user){
 //System.out.println("------------进来了前端的嘛-------------");

  user.setPassword(MD5Pwd.MD5Pwd(user.getUsername(),user.getPassword()));
 int num=userszz.Regist(user);
 System.out.println("-----------"+num);
 if(num>0){
  return "login";
 }
 return "regist";
}

@RequestMapping(value = "/ZZsms")
@ResponseBody
public int Qsms(String phone) {
 //System.out.println("手机啊啊啊啊啊啊啊啊啊啊啊啊"+phone);
 if(userszz.YzPhone(phone)==null){
  return userszz.sms(phone);
 }
  return 0;
}

 @RequestMapping(value = "/ZZsmswj")
 @ResponseBody
 public int wjmima(String phone) {
  //System.out.println("手机啊啊啊啊啊啊啊啊啊啊啊啊"+phone);
   return userszz.sms(phone);
 }


@RequestMapping("/Wjmm")
public String Upxg(users user){
 System.out.println("进来了-----");
 System.out.println(user.getPhone()+"----"+user.getPassword());
if(userszz.Upuser(user)>0){
  return "login";
}
return "regist";
}

@RequestMapping("/yzm")
@ResponseBody
public int yzmm(String username){
 int i=0;
 if(userszz.YzName(username)!=null){
 i=1;
 }else{
  i=0;
 }
 return i;
}


}
