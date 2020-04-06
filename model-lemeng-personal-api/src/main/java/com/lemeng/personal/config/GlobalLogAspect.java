package com.lemeng.personal.config;

import com.nhsoft.provider.common.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class GlobalLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(GlobalLogAspect.class);

    @Around("execution(* com.lemeng.personal.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String classAndMethod = className + "." + joinPoint.getSignature().getName();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("HTTP METHOD : " + request.getMethod());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception ex) {
            logger.error("Method : {} ,  Exception:{} ", classAndMethod, ex);
            result = Response.error(2, "方法执行失败");
        } catch (Throwable throwable) {
            logger.error("Method : {} , unknown Exception: ", classAndMethod, throwable.getMessage());
            result = Response.error(3, "未知错误");
        }
        return result;
    }
}