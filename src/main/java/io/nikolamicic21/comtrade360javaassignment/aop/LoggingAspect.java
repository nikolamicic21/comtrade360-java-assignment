package io.nikolamicic21.comtrade360javaassignment.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* io.nikolamicic21.comtrade360javaassignment.controller.*.*(..))")
    private void controllerPointcut() {}

    @Before("controllerPointcut()")
    public void beforeController(JoinPoint joinPoint) {
      log.info("Entering controller: {}", joinPoint.getSignature());
    }

}
