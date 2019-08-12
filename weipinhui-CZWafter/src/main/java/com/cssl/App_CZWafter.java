package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:32
 * @Author: Mr.Deng
 * @Description:
 */
//@ServletComponentScan(basePackages = "com.cssl.control")
//启动事务啊
@EnableTransactionManagement
@MapperScan("com.cssl.dao")
@SpringBootApplication
@EnableEurekaClient
//RedisFlushMode.IMMEDIATE，可以确保zuul存储到redis的session对象在请求服务中能立即被获取
@EnableRedisHttpSession
@EnableCaching
public class App_CZWafter {
 public static void main(String[] args) {
  SpringApplication.run(App_CZWafter.class,args);
 }
}
