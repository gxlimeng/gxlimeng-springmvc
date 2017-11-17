package com.duopei.spring.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //　@Configuration表明当前类Config是一个配置类。相当于原来的xml配置文件
@ComponentScan("com.duopei.gxlimeng.spring.ioc")  // @ComponentScan注解：扫描对应的包下所有使用@Service 等注解的类。并注册为Bean。
public class Config {

}
