package com.cssl.dao;

import com.weip.pojo.users;
import org.apache.ibatis.annotations.Param;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/13 10:56
 * @Author: Mr.Deng
 * @Description:
 */
public interface usersDao
{
   //登录
   public users login(@Param("username") String name, @Param("password") String pwd);
}