package com.cssl.service;

import com.weip.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/31 16:04
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsService {
 // 商家对应的商品
 public List<Goods> selectGoodsBysid(int sid, int page, int rows);

 //  所有商品用于分页
 public int selectGoodsCount(int sid);

 //根据商品ID查出一年里每个月的销量
 public List<Map<String,Object>> selectXLBygid(int gid);

 // 查询今年所有订单的各个商品的销量
 public List<Map<String,Object>> selectAllCount(int sid);

 // 增加一个商品
 public int addgood(Goods good);

 // 删除一个商品
 public int deleteGoodBygid(int gid);

 //  根据g_id查整个商品信息
 public Goods selectGoodBygid(@Param("gid") int gid);

 // 修改一个商品
 public int updateGood(@Param("good") Goods good);


}
