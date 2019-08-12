package com.cssl.service;

import com.weip.pojo.users;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/16 17:11
 * @Author: Mr.Deng
 * @Description:
 */
@FeignClient("weipinhuiMWXAfter")
public interface usersServiceWeb
{
   @RequestMapping("/after/login/{username}")
   public users login(@PathVariable("username") String username);

   @RequestMapping("/after/token")
   public List<users> findAllusers();
}
