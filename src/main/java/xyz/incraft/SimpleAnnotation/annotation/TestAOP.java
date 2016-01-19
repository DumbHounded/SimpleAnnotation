package xyz.incraft.SimpleAnnotation.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Михаил on 20.01.2016.
 *
 */
@Component
@Aspect
public class TestAOP {
    private final Logger logger = LoggerFactory.getLogger("TestAOP.class");

    @Pointcut("execution(int *(..)) && within(xyz.incraft.SimpleAnnotation.testclass.*)")
    private void testMethod(){}

    @After("testMethod()")
    private void after(){
        logger.info("Вызвано после вызова метода");
    }

    @Before("testMethod()")
    private void before(){
        logger.info("Вызвано перед вызовом метода");
    }

    @AfterReturning(pointcut = "testMethod()", returning="obj")
    private void afterReturning(Object obj){
        logger.info("Метод вернул значение {}", obj);
    }

    @Around("testMethod()")
    private Object arount(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Вместо метода :)");
        //если есть аргументы метода
        for (Object o : joinPoint.getArgs()) {
            logger.info("Аргумент: {}",o);
        }
        return joinPoint.proceed();
    }


}
