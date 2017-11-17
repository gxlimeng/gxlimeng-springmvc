package com.duopei.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=  new AnnotationConfigApplicationContext(ScopeConfig.class);
		DefaultSingleService sb1  = ctx.getBean(DefaultSingleService.class);
		DefaultSingleService sb2  = ctx.getBean(DefaultSingleService.class);
		PrototypeService ps1  = ctx.getBean(PrototypeService.class);
		PrototypeService ps2  = ctx.getBean(PrototypeService.class);
		System.out.println("sb1=sb2>"+(sb1 == sb2));
		System.out.println("ps1=ps2>"+(ps1 == ps2));
		ctx.close();
	}
	
}
