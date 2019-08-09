package com.cssl.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/8 17:27
 * @Author: Mr.Deng
 * @Description:
 */
@Configuration
public class WebSocketConfig {
  @Bean
  public ServerEndpointExporter serverEndpointExporter(){
   return  new ServerEndpointExporter();
  }
}
