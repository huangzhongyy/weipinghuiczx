package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:21
 * @Author: Mr.Deng
 * @Description:
 */
@MapperScan("com.cssl.dao")//扫描接口
@SpringBootApplication
@EnableEurekaClient//客户端
//@EnableCaching//开启redis
public class weipinghuiHZAfterApp {
 public static void main(String[] args) {
  SpringApplication.run(weipinghuiHZAfterApp.class,args);
 }
}
