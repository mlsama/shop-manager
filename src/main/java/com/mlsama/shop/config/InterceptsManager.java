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
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/","/login.html","/index.html");
    }

    /**
     * 放行静态资源
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/**");
    }


    /*private static final String VIEW_PREFIX = "/html/";// 视图前缀
    private static final String VIEW_SUFFIX = ".html";// 视图后缀
    private static final String VIEW_CONTENT_TYPE = "text/html;charset=UTF-8";//视图的内容类型。

    *//**
     * 配置 视图解析器
     * @return
     *//*
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setCache(true);
        resolver.setPrefix(VIEW_PREFIX);
        resolver.setSuffix(VIEW_SUFFIX);
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setContentType(VIEW_CONTENT_TYPE);
        return resolver;
    }*/

}
