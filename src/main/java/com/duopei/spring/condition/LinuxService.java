package com.duopei.spring.condition;

public class LinuxService implements BaseCommondService {

	@Override
	public String showListCmd() {
		return "ls";
	}

}
