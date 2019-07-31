package com.cssl.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/27 16:11
 * @Author: Mr.Deng
 * @Description:
 */
public interface GoodsDao {

 public int selectCountBygid(@Param("gid") int gid);
}
