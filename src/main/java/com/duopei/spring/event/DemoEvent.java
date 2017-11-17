package com.duopei.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author GXLIMENG
 *
 */
public class DemoEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
	}



}
