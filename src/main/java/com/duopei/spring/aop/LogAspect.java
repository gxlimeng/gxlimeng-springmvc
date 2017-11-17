package com.duopei.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// 编写切面
@Aspect // 通过@Aspect注解声明一个切面
@Component // 通过@Component注解让此切面成为Spring管理的一个Bean
public class LogAspect {

	private static final ThreadLocal<Long> begin = new ThreadLocal<Long>();
	
	@Pointcut("@annotation(com.duopei.spring.aop.Action)") // @Pointcut注解声明切点
	public void annotationPointCut(){};
	
	@Before("annotationPointCut()") // 通过@Before声明一个建言，并使用@Pointcut定义的切点
	public void beforeAnnotationPoint(JoinPoint joinPoint){
		begin.set(System.currentTimeMillis());
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println(" 注解式拦截before：" + action.name()); // 通过反射获得注解上的属性，并做相关操作
	}
	
	@After("annotationPointCut()") // 通过@Before声明一个建言，并使用@Pointcut定义的切点
	public void afterAnnotationPoint(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println(" 注解式拦截after：" + action.name()); // 通过反射获得注解上的属性，并做相关操作
		System.out.println(" \t 方法执行时间=["+ (System.currentTimeMillis() - begin.get())  + "]ms \n");
	}
	
	@Around("annotationPointCut()") // 通过@Before声明一个建言，并使用@Pointcut定义的切点
	public void aroundAnnotationPoint(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around start ");
		joinPoint.proceed();
		System.out.println("Around end ");
	}
	
	
	@Before("execution(* com.duopei.spring.aop.MethodService.*(..))") // 通过@Before声明一个建言，此建言直接使用拦截规则作为参数
	public void beforeMethodPoint(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println(" 方法规则式拦截：" + method.getName());
	}
	
	
}
