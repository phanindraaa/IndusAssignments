package com.indus.training.spring.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.indus.training.spring.impl.CalculatorServiceImpl*(..))")
    public void calculatorServiceMethods() {}

    @Before("calculatorServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.debug("Executing method: " + joinPoint.getSignature().getName());
        logger.debug("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "calculatorServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method " + joinPoint.getSignature().getName() + " executed successfully");
        logger.debug("Result: " + result);
    }

    @AfterThrowing(pointcut = "calculatorServiceMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: " + joinPoint.getSignature().getName(), exception);
    }

    @After("calculatorServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        logger.debug("Method execution completed: " + joinPoint.getSignature().getName());
    }

    @Around("calculatorServiceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        logger.debug("Starting method: " + joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed();
        
        long executionTime = System.currentTimeMillis() - start;
        logger.info("Method " + joinPoint.getSignature().getName() + " executed in " + executionTime + " ms");
        
        return result;
    }
}