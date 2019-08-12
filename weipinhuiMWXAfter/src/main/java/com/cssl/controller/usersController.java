package com.cssl.controller;

import com.cssl.service.usersService;
import com.weip.pojo.users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/13 11:29
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class usersController
{
    @Resource
    private usersService service;

    @RequestMapping("/after/login/{username}")
    @ResponseBody
    public users Login(@PathVariable("username") String username)
    {
       System.out.println("after.....");
       System.out.println("uname:"+username);
       users user=service.login(username);
       return user;
    }

   @RequestMapping("/after/token")
   @ResponseBody
   public List<users> findusers()
   {
     System.out.println("after.....");
     List<users> ulist=service.findAllusers();
     return ulist;
 }
}
