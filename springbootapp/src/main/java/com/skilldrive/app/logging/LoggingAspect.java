package com.skilldrive.app.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.skilldrive.app.*.*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        Object retVal = null;
        final Class<?> targetClass = joinPoint.getTarget().getClass();
        final Logger logger = LogManager.getLogger(targetClass);

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        logger.info("Entered into "+className +"."+methodName+(".."));

        retVal = joinPoint.proceed();

        logger.info("Compled execution of "+className +"."+methodName+(".."));


        return retVal;
    }
}