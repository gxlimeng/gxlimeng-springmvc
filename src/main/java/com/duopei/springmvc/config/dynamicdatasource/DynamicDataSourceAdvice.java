//package com.duopei.springmvc.config.dynamicdatasource;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Created by Administrator on 2017/4/13.
// */
//public class DynamicDataSourceAdvice {
//
//    private static final String SELECT = "select";
//    private static final String SLAVE = "slave";
//    private static final String MASTER = "master";
//    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAdvice.class);
//
//    private static final ThreadLocal<Long> BEGIN = new ThreadLocal<Long>();
//
//
//    public void processAfter() {
//        Long elapsedTime = System.currentTimeMillis() - BEGIN.get();
//        logger.info("====::elapsedTime:" + elapsedTime + "ms");
//    }
//
//
//    @Around("execution(* com.duopei.springmvc.*.*.service.*.*(..))")
//    public Object processAround(ProceedingJoinPoint PJ) throws Throwable {
//        return PJ.proceed();
//    }
//
//    @Pointcut("execution(* com.duopei.springmvc.*.*.service.*.*(..))")
//    public void processBefore(JoinPoint point) {
//        BEGIN.set(System.currentTimeMillis());
//        String method = point.getSignature().getName();
//        if (method.startsWith(SELECT)) {
//            logger.info("====::datasource:" + SLAVE);
//            DynamicDataSourceHolder.markRead();
//        } else {
//            logger.info("====::datasource:" + MASTER);
//            DynamicDataSourceHolder.markWrite();
//        }
//    }
//
//}
