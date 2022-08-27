package com.cx.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 切面
 * @createTime 2022-05-01 09:53:53
 */
@Component
@Aspect
public class AopAspect {

    @Pointcut("@annotation(com.cx.test.aop.LogShow)")
    public void showLog(){}

    @Around("showLog()")
    public Object dealLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("2:around=========================");
        return joinPoint.proceed();
    }

    @Before("showLog()")
    public void beforeAction(){
        System.out.println("1:beforeAction=========================");
    }

    @AfterThrowing("showLog()")
    public void AfterThrowing(){
        System.out.println("4:AfterThrowing=========================");
    }

    @AfterReturning("showLog()")
    public void AfterReturning(){
        System.out.println("3:AfterReturning=========================");
    }

    @After("showLog()")
    public void After(){
        System.out.println("3:After=========================");
    }





}
