package com.cssl.controller;

import com.cssl.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weip.pojo.Goods;
import com.weip.pojo.ShopCar;
import com.weip.pojo.Order_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.*;

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


 //手机页面
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
  List<Goods> list=goodsService.Finagoods(map);
  PageInfo<Goods> pageInfo=new PageInfo<>(list,3);//navigatePages显示几个数字
  mapa.put("list",pageInfo);
  //PageInfo<goods> pageInf=new PageInfo<>(list,3);
  return mapa;
 }

//购物车页面
@RequestMapping("/ShopCar")
@ResponseBody
public Map<String,Object> addShopCar(@RequestBody int gid){
 System.out.println("购物车来了嘛---------------------");
 System.out.println("--------------"+gid);
  Goods gg=goodsService.goodsByID(gid);//查询出来要添加购物车的ID
 ShopCar sc=new ShopCar();//购物车实体类对象

 System.out.println(gg);
 ShopCar SpC=goodsService.SelectCar(gg.getG_id());//根据商品ID查询出来购物车数据
 Map<String,Object> map=new HashMap<>();//返回数据的
System.out.println("购物车数据-------------"+SpC);
 if(SpC!=null){//如果查出来显示已经过该商品
     SpC.setNumber(SpC.getNumber()+1);
  System.out.println("价格--------------"+gg.getG_price()*gg.getG_discount());
     SpC.setXiaoJi(SpC.getNumber()*(gg.getG_price()*gg.getG_discount()));//商品数量*价格*//*
     int xg=goodsService.ShopCarupdate(SpC);//修改
  System.out.println("-------------"+xg);
  if(xg>0){
   map.put("list",goodsService.shopcar());//查询数据方法
  }
 }else{
  sc.setNumber(1);//数量
  sc.setXiaoJi(gg.getG_price()*gg.getG_discount());//第一次
  sc.setGooid(gg.getG_id());//对应的商品的ID如果存在说明买过了
  int aa=goodsService.ShopCarInsert(sc);
  if(aa>0){
   map.put("list",goodsService.shopcar());//查询数据方法
  }
 }
  return  map;
}

 /**
  * 加的方法
  * @param gid
  * @return
  */
 @RequestMapping("/jiajia")
 @ResponseBody
public Map<String,Object> upOneSockt(@RequestBody int gid){
  System.out.println("进来了---------------");
   Map<String,Object> map=new HashMap<>();
  Goods gg=goodsService.goodsByID(gid);//查询出来要添加购物车的ID
  ShopCar SpC=goodsService.SelectCar(gid);//根据商品ID查询出来购物车数据
  if(SpC!=null){
    SpC.setNumber(SpC.getNumber()+1);
    SpC.setXiaoJi(SpC.getXiaoJi()+(gg.getG_price()*gg.getG_discount()));
    int xx=goodsService.ShopCarupdate(SpC);
   System.out.println(xx);
    if(xx>0){
     map.put("list",goodsService.shopcar());
    }
  }
   return map;
}

//购物车数量减
@RequestMapping("/jianjian")
@ResponseBody
public Map<String,Object> lowerStock(@RequestBody int gid){
 System.out.println("进来了-----");
 Map<String,Object> map=new HashMap<>();
 Goods gg=goodsService.goodsByID(gid);
 ShopCar psc=goodsService.SelectCar(gid);
 if(psc!=null){
  psc.setNumber(psc.getNumber()-1);
  psc.setXiaoJi(psc.getXiaoJi()-(gg.getG_price()*gg.getG_discount()));
  if(psc.getNumber()<=0){
    psc.setNumber(1);
    psc.setXiaoJi(gg.getG_price()*gg.getG_discount());
 }
  int xx=goodsService.ShopCarupdate(psc);
  if(xx>0){
   map.put("list",goodsService.shopcar());
  }
 }
 return  map;
}

 /**
  * 删除的方法
  * @param gid
  * @return
  */
 @RequestMapping("/Sdelete")
@ResponseBody
public Map<String,Object> ShopCarDelete(@RequestBody int gid){
 System.out.println("删除购物车--------------"+gid);
 Map<String,Object> map=new HashMap<>();
 int dd=goodsService.ShopCardelete(gid);
 if(dd>0){
  map.put("list",goodsService.shopcar());
 }else{
  System.out.println("删除失败");
 }
 return map;
}

@RequestMapping("/sumz")
@ResponseBody
public double sumShopcar(){
  Double shuzi=goodsService.ShopCarSum();
  return shuzi;
}

@RequestMapping("/fuxuan")
@ResponseBody
public Map<String,Object>  checkedjian(@RequestBody int gid){
 System.out.println("aa"+gid);
 Map<String,Object> map=new HashMap<>();
  //Double shuzi=goodsService.ShopCarSum();
 ShopCar spc=goodsService.SelectCar(gid);
 //Double jian=shuzi-spc.getXiaoJi();
 spc.setXiaoJi(0);//
 spc.setBiaoshi(2);
 spc.setGooid(gid);
 int aa= goodsService.ShopCarBiaoshiupdate(spc);
if(aa>0){
 map.put("list",goodsService.shopcar());
}
  return map;
}

//点击checked恢复价钱
@RequestMapping("/jiajiajia")
@ResponseBody
public Map<String,Object> checkedjiajia(@RequestBody int gid){
  Map<String,Object> map=new HashMap<>();

  ShopCar spcz=goodsService.SelectCar(gid);
 Goods gg=goodsService.goodsByID(gid);
  spcz.setXiaoJi(spcz.getNumber()*(gg.getG_price()*gg.getG_discount()));
  spcz.setBiaoshi(1);
  spcz.setGooid(gid);
  int zb=goodsService.ShopCarBiaoshiupdate(spcz);
  if(zb>0){
 map.put("list",goodsService.shopcar());
  }
  return map;
}


//订单结算
@RequestMapping("/orderj")
@ResponseBody
public int Orderjiesuan(String[] cartCheckBox){
  System.out.println("进来了-----------");
 System.out.println("参数-------------"+cartCheckBox[0]);
 System.out.println("aaaaaaaaa"+cartCheckBox[1]);
 int ii=0;
 for (int i=0;i<cartCheckBox.length;i++){
  Order_detail od=new Order_detail();//订单详情表
  ShopCar ss=new ShopCar();//购物袋对象
  ss.setGooid(Integer.valueOf(cartCheckBox[i]));
  ShopCar sszhen=goodsService.dingdanjiesuandage(ss);//每循环一次查询一次对应的gooid
  System.out.println(sszhen);
  String uuid= UUID.randomUUID().toString().replace("-", "").toUpperCase();
  System.out.println("UUID:--------"+uuid);
  od.setOd_id(uuid);// 订单详情ID
  od.setOd_uid(1);//用户的ID
  od.setOd_uname("caozhiwei");//用户ID
  od.setOd_sid(1);//商品商家的ID
  od.setOd_gid(Integer.valueOf(cartCheckBox[i]));//商品的ID
  od.setOd_quantity(sszhen.getNumber());//买了几个
  od.setOd_summoney(sszhen.getXiaoJi());//每个商品的总价钱
  od.setOd_status(1);
  od.setOd_date(new Date());//当前时间
  int jie=goodsService.orderdetailinsert(od);//新增
  System.out.println("返回-------------"+jie);
  if(jie>0){
    goodsService.dingdandelete(ss);//删除
   ii=1;
  }
 }
  return ii;
}













}
