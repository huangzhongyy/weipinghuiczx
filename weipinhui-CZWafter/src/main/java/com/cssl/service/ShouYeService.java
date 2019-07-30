package com.cssl.service;

import com.weip.pojo.onetype;
import com.weip.pojo.twotype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 20:13
 * @Author: Mr.Deng
 * @Description:
 */
public interface ShouYeService {
 public List<twotype> fenLei(Integer oneid);

 //通过map查询订单
 public List<Map<String,Object>> selectOrderByMap(Map<String,Object> map);

 //总订单数用于分页
 public int selectOrderCountBysid(Integer sid,String od_id);
}
