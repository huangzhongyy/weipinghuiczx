package com.cssl.serviceimpl;

import com.cssl.dao.GoodsDao;
import com.cssl.service.GoodsService;
import com.weip.pojo.goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
 @Cacheable(value = "goods",key = "#sid")
 public List<goods> selectGoodsBysid(int sid,int page,int rows) {
  return gd.selectGoodsBysid(sid,page,rows);
 }

 @Override
 public int selectGoodsCount(int sid) {
  return gd.selectGoodsCount(sid);
 }

 // 增加一个商品
 @Override
 public int addgood(@Param("good") goods good){
  return gd.addgood(good);
 }

 // 删除商品
 @Override
 public int deleteGoodBygid(int gid) {
  return gd.deleteGoodBygid(gid);
 }

 // 通过id找商品
 @Override
 public goods selectGoodBygid(int gid) {
  return gd.selectGoodBygid(gid);
 }

 // 修改商品
 @Override
 public int updateGood(goods good) {
  return gd.updateGood(good);
 }
}
