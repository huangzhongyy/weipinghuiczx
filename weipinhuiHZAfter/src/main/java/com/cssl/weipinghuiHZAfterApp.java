package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:21
 * @Author: Mr.Deng
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient//客户端
public class weipinghuiHZAfterApp {
 public static void main(String[] args) {
  SpringApplication.run(weipinghuiHZAfterApp.class,args);
 }
}
