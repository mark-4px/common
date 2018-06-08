/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.log;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author mark
 * @date 2018年5月9日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */

@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("@annotation(com.mark.common.log.Log)")
    public void doBefore(JoinPoint joinPoint) {
        String target = joinPoint.getTarget().getClass().getName();
        String signature = joinPoint.getSignature().getName();
        
        logger.info("target:{},signature:{},参数:{}",target,signature, 
                joinPoint.getArgs());
    }

    
   /* @AfterReturning("aspect()")
    public void afterReturing(JoinPoint joinPoint) {
        String target = joinPoint.getTarget().getClass().getName();
        String signature = joinPoint.getSignature().getName();
        
        logger.error("target:{},signature:{},参数:{}",target,signature, 
                joinPoint.getArgs());
    }*/
    
    
    
    
    /**
     * 异常通知 用于拦截service层记录异常日志
     * 
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "@annotation(com.mark.common.log.Log)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String target = joinPoint.getTarget().getClass().getName();
        String signature = joinPoint.getSignature().getName();
        String targetDescription = "";
        
        try {
            targetDescription = getTargetDescription(joinPoint);
        } catch (Exception e1) {
            logger.error("getTargetDescription", e1);
        }
        
        logger.error("target:{},signature:{},异常代码:{}异常信息:{}参数:{}",target + targetDescription,signature, 
                e.getClass().getName(), e.getMessage(), joinPoint.getArgs());
    }

    /**
     * 获取注解中对方法的描述信息
     * 
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    private String getTargetDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String name = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    name = method.getAnnotation(Log.class).name();
                    break;
                }
            }
        }
        return name;
    }
}
