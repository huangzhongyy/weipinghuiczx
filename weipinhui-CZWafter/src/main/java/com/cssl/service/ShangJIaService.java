package com.cssl.service;

import com.weip.pojo.shanjia;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/6 13:29
 * @Author: Mr.Deng
 * @Description:
 *
 */
public interface ShangJIaService {

 // 商家登录
 public shanjia login(shanjia sj);
}
