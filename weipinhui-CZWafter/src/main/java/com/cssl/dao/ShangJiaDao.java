package com.cssl.dao;

import com.weip.pojo.shanjia;
import org.apache.ibatis.annotations.Param;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/6 13:21
 * @Author: Mr.Deng
 * @Description:
 */
public interface ShangJiaDao {

 // 商家登录
 public shanjia login(@Param("sj") shanjia sj);
}
