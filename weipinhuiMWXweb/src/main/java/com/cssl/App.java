package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/13 10:22
 * @Author: Mr.Deng
 * @Description:
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@EnableFeignClients
public class App
{
    public static void main(String[] args)
    {
       SpringApplication.run(App.class,args);
    }
}
