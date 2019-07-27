package com.cssl.controller;

import com.cssl.service.UsersServicez;
import com.weip.pojo.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:49
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class GoodsController {

 @Autowired
 private UsersServicez goodsService;

 @RequestMapping("finall")
 public String Finagoods(Model model, Map<String,Object> map){
  System.out.println("进来了吗---");
  List<goods> list=goodsService.Finagoods(map);
  for (goods dd :list){
   System.out.println("--------------------------------"+dd.getG_name());
  }
   model.addAttribute("list",list);
  return "shangping";
 }

}
