package com.cssl.serviceimpl;

import com.cssl.dao.Order_detailDao;
import com.cssl.service.Order_detailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/30 17:19
 * @Author: Mr.Deng
 * @Description:
 */
@Service
@Transactional
public class Order_detailServiceImpl implements Order_detailService {

    @Resource
    private Order_detailDao odd;

    // 根据订单改订单的货物状态
    @Override
    public int updateOrder_status(int status, String od_id) {
     return odd.updateOrder_status(status,od_id);
    }
}
