package com.duopei.springmvc.web.example.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/sse")
public class SseController {

	/**
	 * 所谓SSE，就是浏览器向服务器发送一个HTTP请求，然后服务器不断单向地向浏览器推送“信息”（message）。
	 * 		
	 * 	这种信息在格式上很简单，就是“信息”加上前缀“data: ”，然后以“\n\n”结尾
	 * @return
	 */
	@RequestMapping(value = "/push", produces = "text/event-stream;charset=utf-8") // 定义输出类型 text/event-stream，这是服务器端SSE的支持，本列演示每五秒向浏览器推送随机信息
	public @ResponseBody String push() {
		Random r = new Random();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "data:abc" +r.nextInt() +"\n\n";
	}
}
