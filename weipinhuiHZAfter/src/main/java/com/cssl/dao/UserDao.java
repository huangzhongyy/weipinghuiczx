package com.cssl.dao;

import com.weip.pojo.users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:48
 * @Author: Mr.Deng
 * @Description:
 */
@Mapper//在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类
public interface UserDao {

 public int usersRegist(users users);//注册

}
