package com.cssl.controller;

import com.cssl.service.GoodsService;
import com.weip.pojo.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:41
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class GoodsController {

 @Autowired
 private GoodsService goodsService;

 @RequestMapping("/shangpingFina")
 @ResponseBody
public List<goods> Finagoodsz(@RequestBody Map<String,Object> map){
  System.out.println("进来了-----------");
 return goodsService.Finagoods(map);
}


}
