package com.duopei.spring.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//编写拦截规则的注解，註解本身沒有功能，就和xml一洋，属于元数据(解释性数据)就是所谓的配置。 注解的功能是来至用这个注解的地方
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

	String name();
	
}
