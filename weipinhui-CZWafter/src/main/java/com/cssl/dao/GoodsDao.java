package com.cssl.dao;

import com.weip.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
 public List<Goods> selectGoodsBysid(@Param("sid") int sid, @Param("page") int page, @Param("rows") int rows);

 //  所有商品用于分页
  public int selectGoodsCount(@Param("sid") int sid);

  // 增加一个商品
  public int addgood(@Param("good") Goods good);

  // 删除一个商品
  public int deleteGoodBygid(@Param("gid") int gid);

  //  根据g_id查整个商品信息
  public Goods selectGoodBygid(@Param("gid") int gid);

  // 修改一个商品
  public int updateGood(@Param("good") Goods good);

  //根据商品ID查出一年里每个月的销量
  public List<Map<String,Object>> selectXLBygid(@Param("gid") int gid);

  // 查询今年所有订单的各个商品的销量
  public List<Map<String,Object>> selectAllCount(@Param("sid") int sid);
}
