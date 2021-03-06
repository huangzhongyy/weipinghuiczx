package com.cssl.controller;

import com.cssl.service.UsersServicez;

import com.weip.pojo.Order_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
 public String Finagoodsd(String pricez1,String pricez2,String g_name,String the_screen_size,String the_fuselage_memory, Model model, Map<String,Object> map, @RequestParam(name="pageNum",defaultValue = "1") String pageNum){
  System.out.println("进来了吗a---");
  System.out.println("-----------------"+pricez1);
  System.out.println("----------------"+pricez2);
  map.put("pageNum",pageNum);//分页
  map.put("the_fuselage_memory",the_fuselage_memory);//内存
  map.put("g_name",g_name);
  map.put("the_screen_size",the_screen_size);//屏幕尺寸
  map.put("pricez1",pricez1);
  map.put("pricez2",pricez2);
   model.addAttribute("pages",goodsService.Finagoods(map).get("list"));//传过来的全部数据
  return "shangping";
 }

 @RequestMapping("finalldesc")
 public String Finagoodsdesc(String g_name,String the_screen_size,String the_fuselage_memory, Model model, Map<String,Object> map, @RequestParam(name="pageNum",defaultValue = "1") String pageNum){
  System.out.println("进来了吗a---");
  //System.out.println("-----------------"+pageNum);
  //System.out.println("----------------"+the_fuselage_memory);
  map.put("pageNum",pageNum);//分页
  map.put("the_fuselage_memory",the_fuselage_memory);//内存
  map.put("g_name",g_name);
  map.put("the_screen_size",the_screen_size);//屏幕尺寸
  model.addAttribute("pages",goodsService.Finagoodszdesc(map).get("list"));//传过来的全部数据
  return "shangping";
 }


 @RequestMapping("shopcar")
 public String Shopcarz(int gid,Model model){
  System.out.println("进来了嘛老哥--------");
  System.out.println("商品IDDDD"+gid);
  //System.out.println(goodsService.addShopCar(gid).get("list"));
  model.addAttribute("listmap",goodsService.addShopCar(gid).get("list"));
  return "gouwudai";
 }
@RequestMapping("/jiajia")
 public String Updatejiajia(int gid,Model model){
  System.out.println("-----------------------进来了"+gid);
  List<Map<String,Object>> map=(List<Map<String,Object>>)goodsService.upOneSockt(gid).get("list");
/* int aa=Integer.valueOf(map[1].get("pageNum").toString());
 System.out.println();*/
  model.addAttribute("listmap",map);
  return "gouwudai";
 }

@RequestMapping("/jianjian")
 public String updatejianjian(int gid, Model model){
 System.out.println("-----------------------进来了"+gid);
  System.out.println("进来了吗----------------");
  model.addAttribute("listmap",goodsService.lowerStock(gid).get("list"));
return "gouwudai";
 }

 //删除
@RequestMapping("/Sdelete")
 public String Shopcardelete(int gid,Model model){
  System.out.println("---------------"+gid);
  model.addAttribute("listmap",goodsService.ShopCarDelete(gid).get("list"));
  return "gouwudai";
 }

 @RequestMapping("/sumz")
 @ResponseBody
public double sum(){
  return goodsService.sumShopcar();
 }

 @RequestMapping("/fuxuan")
 public String checka(int gid,Model model){
  System.out.println("-----------"+gid);
  model.addAttribute("listmap",goodsService.checkedjian(gid).get("list"));
 return "gouwudai";
 }


 @RequestMapping("/jiajiajia")
 public String checkjia(int gid,Model model){
  System.out.println("------"+gid);

  model.addAttribute("listmap",goodsService.checkedjiajia(gid).get("list"));
  return "gouwudai";
 }


 @RequestMapping("/orderj")
 public String orderjiesuan(@RequestParam(value = "cartCheckBox",required = false) String[] cartCheckBox){
  System.out.println("---------------");
 /* System.out.println(cartCheckBox[0]);
  System.out.println(cartCheckBox[1]);*/
   if(goodsService.Orderjiesuan(cartCheckBox)>0){
    return "login";
  }
 return "regist";
 }

@RequestMapping("/orderxq")
 public String orderGuanli(Model model,Map<String,Object> mapz, String od_status){
 System.out.println("----"+od_status);
 mapz.put("od_status",od_status);//内存
 model.addAttribute("listor",goodsService.dingDan(mapz).get("listo"));
  return "dingdan";
 }

 //取消订单
@RequestMapping("/Quxiao")
 public String  Quxiao(Model model,String od_id){
  if(goodsService.Quxiao(od_id)>0){
  return "forward:/orderxq";
  }
   return "login";
 }


 //确认收货
@RequestMapping("/Quren")
 public String Quren(Model model,String od_id){

  if(goodsService.Quren(od_id)>0){
 return "forward:/orderxq";
  }
  return "login";
 }

@RequestMapping("/Qdelete")
public String Qdelez(Model model,String od_id){
 System.out.println("删除-----"+od_id);
 if(goodsService.Gdele(od_id)>0){
  return "forward:/orderxq";
 }
  return "login";
}




}
