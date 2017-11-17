package com.duopei.spring.aop.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.duopei.gxlimeng.spring.aop.exception")
@EnableAspectJAutoProxy
public class ErrorConfig {

}
