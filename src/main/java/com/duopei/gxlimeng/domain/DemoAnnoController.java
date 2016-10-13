package com.duopei.gxlimeng.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Controller 声明此类事一个控制器
@RequestMapping("/anno") // 映射此类的访问路径是 /anno
public class DemoAnnoController {
	
	 // 此方法未标注路径，因此使用类级别路径/anno，produces可定制返回response媒体类型和字符集。返回json=application/json
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}

	// 演示接受路径作为参数，并结合方法参数@PathVariable使用，访问路径为： /anno/pathvar/xxx
	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String pathvar(HttpServletRequest request, @PathVariable String str) {
		return "url:" + request.getRequestURL() + " can access, str = " + str;
	}

	// 演示常规request获取参数，访问路径为：/anno/requestParam?id=1
	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(HttpServletRequest request, Long id) {
		return "url:" + request.getRequestURL() + " can access, id = " + id;
	}
	// 演示解释参数到对象，反问路径问： /anno/obj?id=1&name=xxx
	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
	@ResponseBody // @ResponseBody 也可以用在方法上
	public String passobj(HttpServletRequest request, DemoObj obj) {
		return "url:" + request.getRequestURL() + " can access, obj.id = " + obj.getId() + ",obj.name = "
				+ obj.getName();
	}

	// 演示映射不同路径到相同方法，访问路径为： /anno/name1  /anno/name2
	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access ... ";
	}

}
