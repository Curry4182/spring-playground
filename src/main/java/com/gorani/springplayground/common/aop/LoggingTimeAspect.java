package com.gorani.springplayground.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingTimeAspect {

    @Around("execution(* com.gorani.springplayground.java.stream.*.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        Object proceed = joinPoint.proceed();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // 밀리초로 변환

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("Execution time of " + methodName + " :: " + duration + " ms");

        return proceed;
    }
}