package com.mlsama.shop.config;

import com.mlsama.shop.intercept.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * DESC: 拦截器配置
 * AUTHOR:mlsama
 * 2020/1/3 9:25
 */
@Configuration
public class InterceptsManager implements WebMvcConfigurer {

    @Resource
    private LoginIntercept loginIntercept;

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/","/html/**","/js/**","css/**","/images/**","/error");
    }

}
