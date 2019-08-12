package com.cssl.serviceimpl;

import com.cssl.dao.GoodsDao;
import com.cssl.service.GoodsService;
import com.weip.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/31 16:21
 * @Author: Mr.Deng
 * @Description:
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

 @Resource
 private GoodsDao gd;



 //商家对应的商品
 @Override
 /*@Cacheable(value = "Goods",key = "#sid")*/
 public List<Goods> selectGoodsBysid(int sid, int page, int rows) {
  return gd.selectGoodsBysid(sid,page,rows);
 }

 //根据商品ID查出一年里每个月的销量
 @Override
 public int selectGoodsCount(int sid) {
  return gd.selectGoodsCount(sid);
 }


 // 查询今年所有订单的各个商品的销量
 @Override
 public List<Map<String, Object>> selectAllCount() {
  return gd.selectAllCount();
 }

 @Override
 public List<Map<String, Object>> selectXLBygid(int gid) {
  return gd.selectXLBygid(gid);
 }

 // 增加一个商品
 @Override
 public int addgood(@Param("good") Goods good){
  return gd.addgood(good);
 }

 // 删除商品
 @Override
 public int deleteGoodBygid(int gid) {
  return gd.deleteGoodBygid(gid);
 }

 // 通过id找商品
 @Override
 public Goods selectGoodBygid(int gid) {
  return gd.selectGoodBygid(gid);
 }

 // 修改商品
 @Override
 public int updateGood(Goods good) {
  return gd.updateGood(good);
 }
}
