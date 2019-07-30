package com.cssl.service;

import com.weip.pojo.goods;

import java.util.List;
import java.util.Map;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/25 17:38
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsService {
 //查询全部
 public List<goods> Finagoods(Map<String,Object> map);
}
