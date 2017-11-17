package com.duopei.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件發佈類
 * @author GXLIMENG
 *
 */
@Component
public class DemoPublisher {

	@Autowired
	ApplicationContext applicationContext; // 注入ApplicationContext用來發佈事件
	
	public void publish(String msg){
		applicationContext.publishEvent(new DemoEvent(this, msg)); // 發佈事件
	}
}
