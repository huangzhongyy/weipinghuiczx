package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:29
 * @Author: Mr.Deng
 * @Description:
 */

@SpringBootApplication
@ServletComponentScan(basePackages = "com.cssl")
/*向eureka服务中心注册*/
@EnableEurekaClient
//使用接口来调用服务
@EnableFeignClients
//RedisFlushMode.IMMEDIATE，可以确保zuul存储到redis的session对象在请求服务中能立即被获取
@EnableRedisHttpSession(
 maxInactiveIntervalInSeconds = 30)
@EnableScheduling // 定时任务
public class App_CZWweb {
 public static void main(String[] args) {
  SpringApplication.run(App_CZWweb.class,args);
 }
}
