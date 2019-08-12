package com.cssl;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: weipinghuiczx
 * @Date: 2019/7/15 20:16
 * @Author: Mr.Deng
 * @Description:
 */
@MapperScan("com.cssl.dao")
@SpringBootApplication
@EnableEurekaClient
public class App
{
    public static void main(String[] args)
    {
     SpringApplication.run(App.class,args);
    }
}
