package com.cssl.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 订单详情
 * @program: weipinghuiczx
 * @Date: 2019/7/30 16:56
 * @Author: Mr.Deng
 * @Description:
 */
public interface Order_detailDao {
  // 根据ID更改订单的货物状态
  public int updateOrder_status(@Param("status") int status,@Param("od_id") String od_id);
}
