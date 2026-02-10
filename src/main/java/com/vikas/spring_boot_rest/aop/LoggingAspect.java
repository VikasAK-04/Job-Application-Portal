package com.vikas.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.vikas.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("method called " + jp.getSignature().getName());
    }

    @After("execution(* com.vikas.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("method executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.vikas.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("method has some issues " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.vikas.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("method has successfully executed" + jp.getSignature().getName());
    }



}
