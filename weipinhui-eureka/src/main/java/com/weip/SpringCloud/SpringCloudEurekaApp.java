package com.weip.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/12 19:26
 * @Author: Mr.Deng
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer //EurekaServer服务器端启动类
public class SpringCloudEurekaApp {
 public static void main(String[] args) {
  SpringApplication.run(SpringCloudEurekaApp.class,args);
 }

}
