package com.example.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.board.interceptor.SignInCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private SignInCheckInterceptor signInCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInCheckInterceptor).addPathPatterns("/board/write", "/board/update/**");
        // 모든 주소를 대상으로 할 때는 /** 사용
        // 특정 주소를 제외 할 때는 excludePathPatterns("url") 사용
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
