package com.cssl.service;

import com.weip.pojo.Goods;
import com.weip.pojo.ShopCar;
import com.weip.pojo.Order_detail;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:38
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsService {
 //查询全部
 public List<Goods> Finagoods(Map<String,Object> map);

 public Goods goodsByID(int gid);//根据ID查询ID信息

 public  int ShopCarInsert(ShopCar ss);//新增数量和价钱

 public List<Map<String,Object>> shopcar();//查询购物袋数据

 public ShopCar SelectCar(int gid);//查询里面有没有过

 public int ShopCarupdate(ShopCar ss);//如果商品存在加的数量和价钱

 public int upOneStock(int gooid);//加

 public int ShopCardelete(int gid);//删除订单

 public double ShopCarSum();//总价钱

 public int ShopCarBiaoshiupdate(ShopCar ss);//修改是否选中了

 public int orderdetailinsert(Order_detail od);//新增订单详情

 public ShopCar dingdanjiesuandage(ShopCar ss);

 public int dingdandelete(ShopCar ss);


 public List<Map<String,Object>> orderdetail(Map<String,Object> map);//订单管理

 public int Quxiao(String od_id);//取消订单

 public int QueRen(String od_id);//确认收货

 public int Gdelete(String od_id);//删除



}
