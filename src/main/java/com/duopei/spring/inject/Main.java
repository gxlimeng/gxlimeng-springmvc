package com.duopei.spring.inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ElConfig.class);
		ElConfig config = ctx.getBean(ElConfig.class);
		config.outputResource();
		ctx.close();
	}
}
