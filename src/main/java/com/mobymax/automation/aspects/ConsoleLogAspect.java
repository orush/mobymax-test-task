package com.mobymax.automation.aspects;

import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Log
@Aspect
public class ConsoleLogAspect {

    @Around("@annotation(io.qameta.allure.Step) && execution(* *(..))")
    public Object log(final ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Step step = methodSignature.getMethod().getAnnotation(Step.class);
        log.info(step.value());
        return joinPoint.proceed();
    }
}
