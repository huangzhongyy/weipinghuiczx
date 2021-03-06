package com.cssl.service.Impl;

import com.cssl.dao.usersDao;
import com.cssl.service.usersService;
import com.weip.pojo.users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/13 11:27
 * @Author: Mr.Deng
 * @Description:
 */
@Service
@Transactional
public class usersServiceImpl implements usersService
{
   @Resource
   private usersDao udao;

   @Override
   public users login(String name)
   {
      return udao.login(name);
   }

   @Override
   public List<users> findAllusers() {
      return udao.findAllusers();
   }
}
