package com.cssl.service;

import org.apache.ibatis.annotations.Param;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/30 17:19
 * @Author: Mr.Deng
 * @Description:
 */
public interface Order_detailService {
 // 根据ID更改订单的货物状态
 public int updateOrder_status(int status,String od_id);
}
