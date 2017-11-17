package com.duopei.spring.ioc.way2;

public class UserFunctionService {

	private FunctionService funService;
	
	public void setFunService(FunctionService funService) {
		this.funService = funService;
	}

	public String sayHello(String world){
		return funService.sayHello(world);
	}
}
