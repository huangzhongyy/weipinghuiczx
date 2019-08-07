package com.cssl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/6 19:44
 * @Author: Mr.Deng
 * @Description:
 */

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
