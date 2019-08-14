package com.cssl.dao;

import com.weip.pojo.Goods;
import com.weip.pojo.ShopCar;
import com.weip.pojo.Order_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:09
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsDao {

 public List<Goods> Finagoods(Map<String,Object> map);//手机页面显示升序

 public List<Goods> Finagoodsdesc(Map<String,Object> map);//手机页面显示降序

 public Goods goodsByID(int gid);//根据ID查询ID信息

  public  int ShopCarInsert(ShopCar ss);//新增数量和价钱

 public List<Map<String,Object>> shopcar();

 public ShopCar SelectCar(int gooid);//查询里面有没有过

 public int ShopCarupdate(ShopCar ss);//修改

 public int upOneStock(int gid);//加

 public int ShopCardelete(int gid);//删除订单

 public double ShopCarSum();//总金额

 public int ShopCarBiaoshiupdate(ShopCar ss);//修改标识

 public ShopCar dingdanjiesuandage(ShopCar ss);//订单结算单个对象查询

 public int dingdandelete(ShopCar ss);//结算成功删除订单

 public int orderdetailinsert(Order_detail od);//新增订单详情

 public List<Map<String,Object>> orderdetail(Map<String,Object> map);//订单管理

 public int Quxiao(String od_id);//取消订单

 public int QueRen(String od_id);//确认收货

 public int Gdelete(String od_id);//删除

 public int jianshao(@Param("number") int number,@Param("gooid") int gooid);//减少库存








}
