package com.cssl.service;

import com.weip.pojo.users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/13 11:26
 * @Author: Mr.Deng
 * @Description:
 */
public interface usersService
{
   //登录,aa
   public users login(@Param("username") String name);

   //查询所有用户
   public List<users> findAllusers();
}
