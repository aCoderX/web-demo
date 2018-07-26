package com.acoderx.webdemo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xudi on 2017/11/6.
 */
@Configuration
@EnableWebMvc
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Bean
    public BaseInterceptor baseInterceptor() {
        return new BaseInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
