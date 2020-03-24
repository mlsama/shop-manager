package com.mlsama.shop.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DESC: 登陆拦截器
 * AUTHOR:mlsama
 * 2020/1/3 9:05
 */
@Slf4j
@Component
public class LoginIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        log.info("进入拦截器!请求URL:{}", requestURL);
        if (request.getSession().getAttribute("token") == null){
            //重定向
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
