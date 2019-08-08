package com.cssl.dao;

import com.weip.pojo.goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/27 16:11
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsDao {

 //库存
 public int selectCountBygid(@Param("gid") int gid);

 // 商家对应的商品
 public List<goods> selectGoodsBysid(@Param("sid") int sid,@Param("page") int page,@Param("rows") int rows);

 //  所有商品用于分页
  public int selectGoodsCount(@Param("sid") int sid);

  // 增加一个商品
  public int addgood(@Param("good") goods good);

  // 删除一个商品
  public int deleteGoodBygid(@Param("gid") int gid);

  //  根据g_id查整个商品信息
  public goods selectGoodBygid(@Param("gid") int gid);

  // 修改一个商品
  public int updateGood(@Param("good") goods good);
}