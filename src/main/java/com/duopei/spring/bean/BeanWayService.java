package com.duopei.spring.bean;

public class BeanWayService {

	public void init(){
		System.out.println(" @Bean-init-method ");
	}
	
	public BeanWayService(){
		super();
		System.out.println(" 初始化構造器函數 BeanWayService ");
	}
	
	public void destroy(){
		System.out.println("@Bean-destroy-method");
	}
	
}
