package com.cssl.service;

import com.weip.pojo.Order_detail;
import com.weip.pojo.users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:57
 * @Author: Mr.Deng
 * @Description:
 */
@FeignClient(value="WEIPINHUIHZAFTER")//通过微服务名访问
public interface UsersServicez {

 @RequestMapping("/upuser")
 public int Upuser(users user);

 //前端注册
 @RequestMapping("/regist")
 public int Regist(users user);

 @RequestMapping("/sms")
 public int sms(String phone);

 @RequestMapping("/pp")
 public users YzPhone(String phone);

 @RequestMapping("/shangpingFina")
 public Map<String,Object> Finagoods(Map<String,Object> map);

 @RequestMapping("/ShopCar")
 public Map<String,Object> addShopCar(int gid);

 @RequestMapping("/jiajia")
 public Map<String,Object> upOneSockt( int gid);

 @RequestMapping("/jianjian")
 public Map<String,Object> lowerStock( int gid);

@RequestMapping("/Sdelete")//删除
 public Map<String,Object> ShopCarDelete(int gid);

@RequestMapping("/sumz")
 public double sumShopcar();
@RequestMapping("/fuxuan")
 public Map<String,Object> checkedjian(int gid);

@RequestMapping("/jiajiajia")
 public Map<String,Object> checkedjiajia( int gid);


//订单结算
@RequestMapping("/orderj")
 public int Orderjiesuan(@RequestParam("cartCheckBox") String[] cartCheckBox);

//订单管理
@RequestMapping("/orderdedail")
 public Map<String,Object> dingDan(Map<String,Object> mapz);
//取消订单
 @RequestMapping("/Quxiao")
 public int Quxiao(String od_id);

 //确认订单
@RequestMapping("/Quren")
 public int Quren(String od_id);

//删除订单
 @RequestMapping("/Qdelete")
 public int Gdele(String od_id);


}
