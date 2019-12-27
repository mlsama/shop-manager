
package com.mlsama.shop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * DESC:异常处理切面
 * AUTHOR:mlsama
 * 2019/12/26 15:16
 */
@Slf4j
@Aspect
@Component
public class ExceptionAspect {
    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(public * com.mlsama.shop.controller.*.*(..))")
    public void cutPoint(){}

    @Around("cutPoint()")
    public Object execute(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            //获得类名
            String clazzName = joinPoint.getTarget().getClass().getSimpleName();
            //获得方法名
            String methodName = joinPoint.getSignature().getName();
            //获得参数列表
            Object[] args = joinPoint.getArgs();
            log.info("clazzName:{},methodName:{},args:{}",clazzName,methodName, Arrays.asList(args));
            //执行切点
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("发生异常:{}",e);
            //处理异常
        }
        return result;
    }
}

