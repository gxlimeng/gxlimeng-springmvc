package com.duopei.spring.aop.exception;

import org.springframework.stereotype.Service;

@Service
public class MathMethodService {

	public Integer division(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			return 0;
		}
	}
	
	public Integer edivision(int a, int b) {
			return a / b;
	}

}
