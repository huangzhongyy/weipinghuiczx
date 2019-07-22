package com.cssl.Service;

import com.weip.pojo.onetype;
import com.weip.pojo.twotype;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

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

 @RequestMapping("/after/test")
 public String test();
}
