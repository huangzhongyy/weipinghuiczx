package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/13 10:22
 * @Author: Mr.Deng
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class App
{
    public static void main(String[] args)
    {
       SpringApplication.run(App.class,args);
    }
}
