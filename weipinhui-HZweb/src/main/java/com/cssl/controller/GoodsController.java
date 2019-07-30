package com.cssl.controller;

import com.cssl.service.UsersServicez;

import com.weip.pojo.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 public String Finagoodsd(String g_name,String the_screen_size,String the_fuselage_memory, Model model, Map<String,Object> map, @RequestParam(name="pageNum",defaultValue = "1") String pageNum){
  System.out.println("进来了吗a---");
  //System.out.println("-----------------"+pageNum);
  System.out.println("----------------"+the_fuselage_memory);
  map.put("pageNum",pageNum);//分页
  map.put("the_fuselage_memory",the_fuselage_memory);//内存
  map.put("g_name",g_name);
  map.put("the_screen_size",the_screen_size);//屏幕尺寸
  //System.out.println("-----------"+goodsService.Finagoods(map).get("list"));
   model.addAttribute("pages",goodsService.Finagoods(map).get("list"));//传过来的全部数据
  return "shangping";
 }

}
