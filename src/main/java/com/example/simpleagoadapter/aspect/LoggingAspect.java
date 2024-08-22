package com.example.simpleagoadapter.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(public * com.example.simpleagoadapter.endpoint.AgoServiceEndpoint.*(..))")
    public Object logAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String messageBefore = String.format("Invoking method '{}'");
        log.info(messageBefore, methodName);

        Object proceed = joinPoint.proceed();

        String messageAfter = String.format("Method '{}' finished");
        log.info(messageAfter, methodName);
        return proceed;
    }

}
