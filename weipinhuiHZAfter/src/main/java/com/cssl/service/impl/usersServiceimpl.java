package com.cssl.service.impl;

import com.cssl.dao.UserDao;
import com.cssl.service.usersService;
import com.weip.pojo.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:51
 * @Author: Mr.Deng
 * @Description:
 */
@Service
public class usersServiceimpl implements usersService {

 @Autowired
 private UserDao udao;


 @Override
 public int usersRegist(users users) {
  return udao.usersRegist(users);
 }
}
