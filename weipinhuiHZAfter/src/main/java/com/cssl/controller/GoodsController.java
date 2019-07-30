package com.cssl.controller;

import com.cssl.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weip.pojo.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
public Map<String,Object> Finagoodsz(@RequestBody Map<String,Object> map){

  System.out.println("进来了-----------");
  //System.out.println("-----------"+map.get("pageNum"));//分页的值
  System.out.println("---------"+map.get("the_fuselage_memory"));
  int aa=Integer.valueOf(map.get("pageNum").toString());//map取出来是一个object类型
  Map<String,Object> mapa=new HashMap<>();
 //PageHelper.startPage(1,2);
  //Page<Object> starPage= PageHelper.startPage(1,2);
//goodsService.Finagoods(map);
  PageHelper.startPage(aa,4);//设置分页一页显示4个数据
 List<goods> list=goodsService.Finagoods(map);
  PageInfo<goods> pageInfo=new PageInfo<>(list,3);//navigatePages显示几个数字
  mapa.put("list",pageInfo);
  //PageInfo<goods> pageInf=new PageInfo<>(list,3);
  return mapa;
}


}
