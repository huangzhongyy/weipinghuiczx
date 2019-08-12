package com.cssl.controller;

import com.cssl.service.usersServiceWeb;
import com.weip.pojo.users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/16 17:17
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class usersControllerWeb
{
   @Resource
   private usersServiceWeb serviceWeb;

   @RequestMapping(value = "/web/login")
   @ResponseBody
   public boolean Login(String username, String password, Integer isRemember)
   {
        System.out.println("Web.............");
        System.out.println(username+"    "+password+"     "+isRemember);

        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try
        {
           if(isRemember==1)
           {
             System.out.println("jinrememb");
             token.setRememberMe(true);
           }
            //登录
            subject.login(token);
            return true;
        }
        catch (UnknownAccountException e)
        {
            //用户不存在
            return false;
        }
        catch (IncorrectCredentialsException e)
        {
            //密码不正确
            return false;
        }
  }

  @RequestMapping("/finduser")
  public String find(String username, HttpSession session)
  {
     users user=serviceWeb.login(username);
     session.setAttribute("users",user);
     return "demo2";
  }

 //新增
 @RequestMapping("/web/add")
 @RequiresPermissions("add")
 public String add()
 {
  System.out.println("add..........");
  return "index";
 }

 //修改
 @RequestMapping("/web/update")
 @RequiresPermissions("update")
 public String update()
 {
  System.out.println("update..........");
  return "index";
 }

  //注销
  @RequestMapping("/web/logout")
  public String logout()
  {
     Subject subject = SecurityUtils.getSubject();
   System.out.println("注销啦啊");
     if(subject.isAuthenticated())
     {
         subject.logout();
     }
     return "login";
  }

 @ExceptionHandler(UnauthorizedException.class)
 public String handleShiroException(Exception ex) {
  return "login";
 }

 @RequestMapping(value = "/web/token")
 @ResponseBody
  public List<users> getToken()
  {
    System.out.println("Web.............");
    //String token=new Date(new Date().getTime()-24*60*60*1000).toString();
    List<users> ulist=serviceWeb.findAllusers();
    return ulist;
  }
}
