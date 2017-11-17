package com.duopei.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrePostConfig.class);
		ctx.getBean(BeanWayService.class);
		ctx.getBean(JSR250WayService.class);
		ctx.close();
	}

}
