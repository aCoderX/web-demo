package com.acoderx.webdemo.core;

import com.acoderx.webdemo.handler.websocket.WebsocketHandler1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by xudi on 2017/12/26.
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebsocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //允许连接的域,只能以http或https开头
        String[] allowsOrigins = {"http://test1.dxy.net"};
        registry.addHandler(chatWebSocketHandler(),"/websocket").setAllowedOrigins(allowsOrigins);
    }
    @Bean
    public WebsocketHandler1 chatWebSocketHandler() {
        return new WebsocketHandler1();
    }

}
