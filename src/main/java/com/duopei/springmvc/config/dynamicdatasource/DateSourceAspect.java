package com.duopei.springmvc.config.dynamicdatasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/4/14.
 */
@Component
@Aspect
@Order(0)
public class DateSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DateSourceAspect.class);
    /**
     * 缓存
     */
    private static ConcurrentHashMap<String, String> methodIsReadCache = new ConcurrentHashMap<>();

    /**
     * 决策是否只读
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
//    @Around("execution(* com.duopei.springmvc.web.admin.service.*.*(..))")
//    public Object aroundErrorAnnoation(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
//        Object target = joinPoint.getTarget();
//        String cacheKey = target.getClass().getName() + "." + method.getName();
//        String cacheValueType = methodIsReadCache.get(cacheKey);
//        if (null == cacheValueType) {
//            // 重新获取方法，否则传递的是接口的方法信息
//            Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
//            cacheValueType = matchDataSource(realMethod);
//            methodIsReadCache.put(cacheKey, cacheValueType);
//        }
//
//        if (DataSourceType.read == cacheValueType) {
//            DynamicDataSourceHolder.markRead();
//        } else if (DataSourceType.write == cacheValueType) {
//            DynamicDataSourceHolder.markWrite();
//        } else {
//            DynamicDataSourceHolder.markRead();
//        }
//        try {
//            logger.info("1METHOD=[" + cacheKey + "] DATASOURCE=[" + DynamicDataSourceHolder.get() + "]");
//            System.out.println("2METHOD=[" + cacheKey + "] DATASOURCE=[" + DynamicDataSourceHolder.get() + "]");
//            return joinPoint.proceed();
//        } finally {
//            DynamicDataSourceHolder.reset();
//        }
//    }

    @Before("execution(* com.duopei.springmvc.web.*.service.*.*(..))")
    public void aroundErrorAnnoation(JoinPoint joinPoint){

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Object target = joinPoint.getTarget();
        String cacheKey = target.getClass().getName() + "." + method.getName();
        String cacheValueType = methodIsReadCache.get(cacheKey);
        if (null == cacheValueType) {
            // 重新获取方法，否则传递的是接口的方法信息
            cacheValueType = matchDataSource(method.getName());
            methodIsReadCache.put(cacheKey, cacheValueType);
        }

        if (DataSourceType.read == cacheValueType) {
            DynamicDataSourceHolder.markRead();
        } else if (DataSourceType.write == cacheValueType) {
            DynamicDataSourceHolder.markWrite();
        } else {
            DynamicDataSourceHolder.markRead();
        }
    }

    /**
     * 根据方法名 判断 哪个 数据源
     */
    private String matchDataSource(String methodName) {
        if (methodName.startsWith("select")) {
            return DataSourceType.read;
        } else if (methodName.startsWith("save")) {
            return DataSourceType.write;
        }
        return DataSourceType.read;
    }
}
