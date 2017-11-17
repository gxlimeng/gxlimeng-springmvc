package com.duopei.spring.aop;

import org.springframework.stereotype.Service;

// 使用方法注解拦截
@Service
public class MethodService {

	public void add(){
		System.out.println(" 执行方法：MethodService.add() 方法 ");
	}
	
}
