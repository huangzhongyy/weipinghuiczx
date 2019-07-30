package com.cssl.service;

import com.weip.pojo.goods;
import com.weip.pojo.users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:57
 * @Author: Mr.Deng
 * @Description:
 */
@FeignClient(value="WEIPINHUIHZAFTER")//通过微服务名访问
public interface UsersServicez {

 //前端注册
 @RequestMapping("/regist")
 public int Regist(users user);

 @RequestMapping("/sms")
 public int sms(String phone);

 @RequestMapping("/pp")
 public users YzPhone(String phone);

 @RequestMapping("/shangpingFina")
 public Map<String,Object> Finagoods(Map<String,Object> map);

}
