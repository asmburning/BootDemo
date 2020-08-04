package org.lxy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAspect {

    @Pointcut("execution(public * org.lxy.controller..*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeLog(JoinPoint joinPoint) {
        log.info("before : {}, {}", joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @After("pointCut()")
    public void afterLog(JoinPoint joinPoint) {
        log.info("after");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningLog(JoinPoint joinPoint, Object result) {
        log.info("after");
    }

    @Around("pointCut()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around begin");
        Object proceed = joinPoint.proceed();
        log.info("around end");
        return proceed;
    }
}
