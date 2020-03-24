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
    private LoginIntercept loginIntercept; //注入拦截器

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept) //添加拦截器
                .addPathPatterns("/**") //拦截地址,/**代表拦截所有请求
                //不拦截的请求,需要放行静态资源,静态资源一般在static下
                .excludePathPatterns("/login","/","/html/**","/js/**","css/**","/images/**","/error/**");
    }
}
