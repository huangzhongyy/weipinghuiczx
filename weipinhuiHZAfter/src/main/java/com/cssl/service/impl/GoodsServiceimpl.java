package com.cssl.service.impl;

import com.cssl.dao.GoodsDao;
import com.cssl.service.GoodsService;
import com.weip.pojo.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:38
 * @Author: Mr.Deng
 * @Description:
 */
@Service
public class GoodsServiceimpl implements GoodsService {

 @Autowired
 private GoodsDao goodsDao;

 @Override
 public List<goods> Finagoods(Map<String, Object> map) {
  return goodsDao.Finagoods(map);
 }

}
