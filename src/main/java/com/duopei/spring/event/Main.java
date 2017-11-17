package com.duopei.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=  new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher publisher = ctx.getBean(DemoPublisher.class);
		publisher.publish("事件發佈");
		ctx.close();
	}
}
