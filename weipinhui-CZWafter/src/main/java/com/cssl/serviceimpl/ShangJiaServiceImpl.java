package com.cssl.serviceimpl;

import com.cssl.dao.ShangJiaDao;
import com.cssl.service.ShangJIaService;
import com.weip.pojo.shanjia;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/6 13:30
 * @Author: Mr.Deng
 * @Description:
 */
@Service
@Transactional
public class ShangJiaServiceImpl implements ShangJIaService {

 @Resource
 private ShangJiaDao sjd;

 @Override
 @Cacheable(value = "sj",key = "#sj")
 public shanjia login(shanjia sj) {
  return sjd.login(sj);
 }
}
