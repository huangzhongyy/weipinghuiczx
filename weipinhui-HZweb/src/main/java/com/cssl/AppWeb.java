package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @program: weipinghuiczx
 * @Date: 2019/7/10 10:40
 * @Author: Mr.Deng
 * @Description:
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient//eureka客户端
@EnableFeignClients
public class AppWeb {
 public static void main(String[] args) {
  SpringApplication.run(AppWeb.class,args);
 }
}
