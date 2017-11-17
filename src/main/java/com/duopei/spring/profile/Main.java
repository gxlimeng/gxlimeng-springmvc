package com.duopei.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("dev"); // 把当前活动的Profile设置为"dev"
		ctx.register(ProfileConfig.class); // 后置注册Bean配置类，不然会报Bean未定义 错误
		ctx.refresh(); // 刷新容器

		ProfileBean profileBean = ctx.getBean(ProfileBean.class);
		System.out.println(profileBean.getContent());

		ctx.close();
	}

}
