package com.cssl.controller;

import com.cssl.service.usersServiceWeb;
import com.weip.pojo.users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class usersControllerWeb
{
   @Resource
   private usersServiceWeb serviceWeb;

   @RequestMapping(value = "/web/login")
   @ResponseBody
   public boolean Login(String username, String password, HttpSession session)
   {
        System.out.println("Web.............");
        System.out.println(username+"    "+password);
        users user = serviceWeb.login(username, password);
        //long current = System.currentTimeMillis();
        if (user == null)
        {
          return false;
        }
        else
        {
          session.setAttribute("user", user);
          return true;
        }
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
