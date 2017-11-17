package com.duopei.spring.aop;

import org.springframework.stereotype.Service;

//编写使用注解的类
@Service
public class AnnotationService {

	@Action(name="注解是方式拦截add方法")
	public void add(){
		System.out.println(" \t 执行方法：AnnotationService.add() 注解 ");
	}
	
}
