package com.duopei.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

	@Bean
	@Conditional(WindowsCondition.class)
	public BaseCommondService windowsService(){
		return new WindowsService();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public BaseCommondService linuxService(){
		return new LinuxService();
	}
}
