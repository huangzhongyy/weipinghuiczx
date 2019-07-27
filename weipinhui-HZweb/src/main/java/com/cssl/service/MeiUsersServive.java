package com.cssl.service;

import com.weip.pojo.users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/23 16:48
 * @Author: Mr.Deng
 * @Description:
 */
@FeignClient("weipinhuiMWXAfter")//梅文轩的微服务名
public interface MeiUsersServive {
 @RequestMapping("/after/login/{username}/{password}")
 public users login(@PathVariable("username") String username, @PathVariable("password") String password);

 @RequestMapping("/after/token")
 public List<users> findAllusers();
}
