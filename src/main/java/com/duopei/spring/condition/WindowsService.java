package com.duopei.spring.condition;

public class WindowsService implements BaseCommondService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}
