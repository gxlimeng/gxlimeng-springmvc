package com.duopei.spring.aop.exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ErrorConfig.class);
		MathMethodService mathService = ctx.getBean(MathMethodService.class);
		System.out.println("return= "  +mathService.division(6, 0));
		System.out.println("ereturn= "  +mathService.edivision(6, 0));
		ctx.close();
		
	}
}
