package com.cssl.lanjieqi;

import com.cssl.lanjieqi.LoginLanJieQi;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/13 16:43
 * @Author: Mr.Deng
 * @Description:
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
 @Override
 public void addInterceptors(InterceptorRegistry registry) {
   registry.addInterceptor(new LoginLanJieQi()).addPathPatterns("/**")
    .excludePathPatterns("/aftercss/**","/easyui/**","/echarts/**","/weipinhui_login_files/**");
 }
}
