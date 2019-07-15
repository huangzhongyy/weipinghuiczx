package com.cssl.service;

import com.weip.pojo.users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:57
 * @Author: Mr.Deng
 * @Description:
 */
@FeignClient("weipinhuiHZAfter")//通过微服务名访问
public interface usersService {

 //前端注册
 @RequestMapping("/regist")
 public int Regist(users user);

}
