package com.duopei.spring.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionConfig.class);
		BaseCommondService service = ctx.getBean(BaseCommondService.class);
		System.out.println(ctx.getEnvironment().getProperty("os.name")+"相同的列表命令为="+service.showListCmd());
		ctx.close();
	}
}
