package com.cssl.controller;

import com.cssl.service.usersService;
import com.weip.pojo.users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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

    @RequestMapping("/login")
    @ResponseBody
    public boolean Login(String username,String password)
    {
     System.out.println("jinlaile");
       users user=service.login(username,password);
       if(user!=null || !user.equals(""))
           return true;
       return false;
    }
}
