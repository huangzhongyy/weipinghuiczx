package com.cssl.service;

import com.weip.pojo.goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/31 16:04
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsService {
 // 商家对应的商品
 public List<goods> selectGoodsBysid(int sid,int page,int rows);

 //  所有商品用于分页
 public int selectGoodsCount(int sid);

 // 增加一个商品
 public int addgood(goods good);

 // 删除一个商品
 public int deleteGoodBygid(int gid);

 //  根据g_id查整个商品信息
 public goods selectGoodBygid(@Param("gid") int gid);

 // 修改一个商品
 public int updateGood(@Param("good") goods good);


}
