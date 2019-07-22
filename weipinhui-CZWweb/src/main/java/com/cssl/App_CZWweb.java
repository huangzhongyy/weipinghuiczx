package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:29
 * @Author: Mr.Deng
 * @Description:
 */

@SpringBootApplication
/*向eureka服务中心注册*/
@EnableEurekaClient
//使用接口来调用服务
@EnableFeignClients
public class App_CZWweb {
 public static void main(String[] args) {
  SpringApplication.run(App_CZWweb.class,args);
 }
}
