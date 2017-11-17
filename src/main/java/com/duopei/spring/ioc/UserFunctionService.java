package com.duopei.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 声明当前类是Spring容器管理的Bean
public class UserFunctionService {

	@Autowired  
	// @Autowired：把当前的FunctionService的实体Bean注入到UserFunctionService中。让UserFunctionService具备FunctionService的功能
	// 使用 JSR-330的@Inject 和 JSR-250的@Resource注解 也是等效的
	private FunctionService funService;
	
	public String sayHello(String world){
		return funService.sayHello(world);
	}
}
