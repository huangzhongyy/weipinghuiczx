package com.cssl.dao;

import com.weip.pojo.goods;
import com.weip.pojo.onetype;
import com.weip.pojo.threetype;
import com.weip.pojo.twotype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 19:39
 * @Author: Mr.Deng
 * @Description:
 */
public interface ShouYeDao {

 //查询一级分类
 public List<onetype> selectOne();

 //查询二级分类
 public List<twotype> selectTwo(@Param("oneId") Integer oneId);

 //查询三级分类
 public List<threetype> selectThree(@Param("twoID") Integer twoID);

 //通过map查询订单
 public List<Map<String,Object>> selectOrderByMap(@Param("map") Map<String,Object> map);

 //总订单数用于分页
 public int selectOrderCountBysid(@Param("sid")Integer sid,@Param("od_id") String od_id);
}
