package com.duopei.spring.profile;

public class ProfileBean {

	private String content;

	public ProfileBean(String content){
		super();
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
