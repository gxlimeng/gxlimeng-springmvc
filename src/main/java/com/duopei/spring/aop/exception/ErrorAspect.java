package com.duopei.spring.aop.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.duopei.util.JacksonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
@Aspect
public class ErrorAspect {

	@Around("execution(* com.duopei.spring.aop.exception.*.*(..))")
	public Object aroundErrorAnnoation(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("异常方法：\t"+joinPoint.getSignature().toLongString() + " \t 参数=" +  JacksonUtil.toJSon(joinPoint.getArgs()) +" \t 异常类型："+e.toString());
		}
		return null;
	}

}
