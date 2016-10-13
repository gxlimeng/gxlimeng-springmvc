package com.duopei.gxlimeng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // @Controller 声明一个控制器
public class HelloController {

	@RequestMapping("/index") // 利用@RequestMapping配置URL和方法之间的映射
	public String hello() {
		return "index"; // 通过ViewResolver的Bean配置，返回index，说明我们的业务放置路径为/WEB-INFO/classes/views/index.jsp
	}
}
