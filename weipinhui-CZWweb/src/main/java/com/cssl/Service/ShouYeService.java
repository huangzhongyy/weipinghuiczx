package com.cssl.Service;

import com.weip.pojo.onetype;
import com.weip.pojo.twotype;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
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

 @RequestMapping("/aftershouye")
 public List<twotype> loadFenLei(Integer oneid);

 @RequestMapping("/after/order")
 public Map<String,Object> selectOrderByMap(Map<String,Object> map);

 @RequestMapping("/after/updatestatuss")
 public String updateStatue(@RequestParam("status") Integer status,@RequestParam("od_id") String od_id);





















 @RequestMapping("/after/test")
 public String test();
}
