package com.cssl.service;

import com.weip.pojo.users;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:43
 * @Author: Mr.Deng
 * @Description:
 */
public interface usersService {

 public int usersRegist(users users);

 public users SelectPhone(String phone);//查询手机号码
 public int updateusers(users user);//修改密码

 public users registYanzen(String  username);

}
