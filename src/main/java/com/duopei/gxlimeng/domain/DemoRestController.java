package com.duopei.gxlimeng.domain;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController 声明控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {

	// 返回数据的媒体类型为 json ,produces = "application/json;charset=UTF-8"
	@RequestMapping(value = "/getjson" ) // produces：指定返回内容类型
	public DemoObj getJson(DemoObj obj, HttpServletResponse response) {
		//response.setHeader("content-type", "text/html");
		//response.setCharacterEncoding("UTF-8");
		return new DemoObj(obj.getId() + 1, obj.getName() + "-AAAAAA"); // 直接返回对象，对象会自动转换成json
	}

	// 返回数据的媒体类型为 xml
	@RequestMapping(value = "/getxml")
	public DemoObj getXml(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "-BBBBBBB"); // 直接返回对象，对象会自动转换成xml
	}

}
