package com.cssl.dao;

import com.weip.pojo.Goods;
import com.weip.pojo.ShopCar;
import com.weip.pojo.Order_detail;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:09
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsDao {

 public List<Goods> Finagoods(Map<String,Object> map);//手机页面显示

 public Goods goodsByID(int gid);//根据ID查询ID信息

  public  int ShopCarInsert(ShopCar ss);//新增数量和价钱

 public List<Map<String,Object>> shopcar();

 public ShopCar SelectCar(int gooid);//查询里面有没有过

 public int ShopCarupdate(ShopCar ss);//修改

 public int upOneStock(int gid);//加

 public int ShopCardelete(int gid);//删除订单



 public double ShopCarSum();

 public int ShopCarBiaoshiupdate(ShopCar ss);

 public ShopCar dingdanjiesuandage(ShopCar ss);

 public int dingdandelete(ShopCar ss);//结算成功删除订单

 public int orderdetailinsert(Order_detail od);//新增订单详情





}
