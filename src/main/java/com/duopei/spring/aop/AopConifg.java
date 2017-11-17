package com.duopei.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.duopei.gxlimeng.spring.aop")
@EnableAspectJAutoProxy // 通过@EnableAspectJAutoProxy注解开启Spirng对AspectJ代理的支持
public class AopConifg {

}
