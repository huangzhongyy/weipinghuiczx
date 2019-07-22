package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 17:32
 * @Author: Mr.Deng
 * @Description:
 */
//@ServletComponentScan(basePackages = "com.cssl.control")
//启动事务
@EnableTransactionManagement
@MapperScan("com.cssl.dao")
@SpringBootApplication
@EnableEurekaClient
public class App_CZWafter {
 public static void main(String[] args) {
  SpringApplication.run(App_CZWafter.class,args);
 }
}
