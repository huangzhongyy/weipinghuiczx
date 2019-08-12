package com.cssl.service.impl;

import com.cssl.dao.GoodsDao;
import com.cssl.service.GoodsService;
import com.weip.pojo.ShopCar;
import com.weip.pojo.Goods;
import com.weip.pojo.Order_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:38
 * @Author: Mr.Deng
 * @Description:
 */
@Service
public class GoodsServiceimpl implements GoodsService {
 @Autowired
 private GoodsDao goodsDao;

 @Override
 public int Quxiao(String od_id) {
  return goodsDao.Quxiao(od_id);
 }

 @Override
 public int Gdelete(String od_id) {
   return goodsDao.Gdelete(od_id);
 }

 @Override
 public List<Map<String, Object>> orderdetail(Map<String,Object> map) {
  return goodsDao.orderdetail(map);
 }

 @Override
 public int QueRen(String od_id) {
    return goodsDao.QueRen(od_id);
 }

 @Override
 public int upOneStock(int gooid) {
  return goodsDao.upOneStock(gooid);
 }

 @Override
 public int ShopCarupdate(ShopCar ss) {
  return goodsDao.ShopCarupdate(ss);
 }

 @Override
 public int dingdandelete(ShopCar ss) {
  return goodsDao.dingdandelete(ss);
 }

 @Override
 public ShopCar dingdanjiesuandage(ShopCar ss) {
  return goodsDao.dingdanjiesuandage(ss);
 }

 @Override
 public ShopCar SelectCar(int gid) {
  return goodsDao.SelectCar(gid);
 }

 @Override
 public List<Map<String,Object>> shopcar() {//查询全部
  return goodsDao.shopcar();
 }

 @Override
 public int orderdetailinsert(Order_detail od) {
  return goodsDao.orderdetailinsert(od);
 }

 @Override
 public int ShopCarInsert(ShopCar ss) {
  return goodsDao.ShopCarInsert(ss);
 }

 @Override
 public Goods goodsByID(int gid) {
  return goodsDao.goodsByID(gid);
 }

 @Override
 public int ShopCardelete(int gid) {
  return goodsDao.ShopCardelete(gid);
 }

 @Override
 public int ShopCarBiaoshiupdate(ShopCar ss) {
  return goodsDao.ShopCarBiaoshiupdate(ss);
 }

 @Override
 public double ShopCarSum() {
  return goodsDao.ShopCarSum();
 }

 @Override
 /*@Cacheable(value="Goods")*/
 public List<Goods> Finagoods(Map<String, Object> map) {
  return goodsDao.Finagoods(map);
 }
}
