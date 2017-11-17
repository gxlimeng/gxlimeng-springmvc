package com.duopei.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

	@PostConstruct // @PostConstruct 在構造器函數執行完之後執行
	public void init(){
		System.out.println(" JSR250-init-method ");
	}
	
	public JSR250WayService(){
		super();
		System.out.println(" 初始化構造器函數 JSR250WayService ");
	}
	
	@PreDestroy // @PreDestroy 在Bean銷毀之前執行
	public void destroy(){
		System.out.println("@JSR250-destroy-method");
	}

}
