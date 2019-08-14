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
 public int updateusers(users user) {
  return udao.updateusers(user);
 }



 @Override
 public users SelectPhone(String phone) {
  System.out.println("手机号码业务层-------");
  return udao.SelectPhone(phone);
 }

 @Override
 public int usersRegist(users users) {
  System.out.println("注册业务层----------");
  return udao.usersRegist(users);
 }

 @Override
 public users registYanzen(String username) {
  return udao.registYanzen(username);
 }

}
