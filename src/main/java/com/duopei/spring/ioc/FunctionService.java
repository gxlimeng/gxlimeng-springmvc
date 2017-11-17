package com.duopei.spring.ioc;

import org.springframework.stereotype.Service;

@Service // @Service：声明当前类FunctionService是Sping容器管理的Bean，使用@Component/@Controller/@Service/@Repository是等效的（根据业务场景使用）
public class FunctionService {

	public String sayHello(String world){
		return " Hello " + world ; 
	}

}
