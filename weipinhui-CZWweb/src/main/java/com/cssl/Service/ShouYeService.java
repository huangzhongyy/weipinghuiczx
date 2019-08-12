package com.cssl.Service;

import com.weip.pojo.Goods;
import com.weip.pojo.shanjia;
import com.weip.pojo.twotype;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 19:18
 * @Author: Mr.Deng
 * @Description:
 */
@FeignClient("MICROSERVICE-CZWAFTER")
public interface ShouYeService {

 @RequestMapping("/after/login")
 public shanjia afterLogin(shanjia sj);

 @RequestMapping("/aftershouye")
 public List<twotype> loadFenLei(Integer oneid);

 @RequestMapping("/after/order")
 public Map<String,Object> selectOrderByMap(Map<String,Object> map);

 @RequestMapping("/after/updatestatuss")
 public String updateStatue(@RequestParam("status")Integer status,@RequestParam("od_id") String od_id);

 // 商家对应的商品
 @RequestMapping("/after/goodsbysid")
 public Map<String,Object> selectGoodsBySid(@RequestParam("sid")int sid,@RequestParam("page")int page,@RequestParam("rows")int rows);

 //  商家增加一个商品
 @RequestMapping("/after/addgood")
 public String addgood(Goods good);
 // 删除一个商品
 @RequestMapping("/after/destroyRowgoood")
 public String destroyRow(@RequestParam("gid") int gid);

 @RequestMapping("/after/findGoodBygid")
 public Goods findGoodBygid(@RequestParam("gid") int gid);

 // 修改一个商品
 @RequestMapping("/after/updategood")
 public String updateGood(Goods good);

















 @RequestMapping("/after/test")
 public String test();
}
