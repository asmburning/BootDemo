package org.lxy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Slf4j
@Component
public class AuthAspect {

    // https://docs.spring.io/spring/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html#aop-pointcuts-designators
    // Spring support 9 kind of pointcuts
    @Around("@annotation(org.lxy.anno.Auth)")
    public Object auth(ProceedingJoinPoint joinPoint) throws Throwable{
        Signature signature = joinPoint.getSignature();
        // https://stackoverflow.com/questions/29803323/access-httpservletrequest-object-inside-aspect-which-one-is-better-solution-bet
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Object result = joinPoint.proceed();
        return result;
    }
}
