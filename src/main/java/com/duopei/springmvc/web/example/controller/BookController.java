package com.duopei.springmvc.web.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duopei.springmvc.web.example.dto.Book;

@Controller // 1 @Controller注解声明此类是一个控制器
@RequestMapping("/book") // 2 @RequestMapping("/book")  映射的访问路径为 /book
public class BookController {

	@RequestMapping(produces = "text/plain;charset=UTF-8") //3 此方法为标注路径，则使用类级别的路径 /book , produces可定制返回的response的媒体类型和字符串，或需要返回json对象，则设置produces = "application/json;charset=UTF-8"
	public @ResponseBody String index(HttpServletRequest request) { // 4 
		return "接受访问地址url =" + request.getRequestURL();
	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8") // 5 接收路径参数，并在方法参数前结合@PathVariable使用 ，访问路径为：/book/pathvar/xx
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "接受访问地址url =" + request.getRequestURL() + " 参数str=" + str;
	}
	
	@RequestMapping(value = "/reqparam", produces = "text/plain;charset=UTF-8") // 6 演示常规request访问参数，访问路径 /book/requparam?id=123
	public @ResponseBody String demoPathVar(Long id, HttpServletRequest request) {
		return "接受访问地址url =" + request.getRequestURL() + " 参数id=" + id;
	}
	
	// TODO IE浏览器还是出现下载提示（spring4添加jackson包后会自动注册messageconverter。 为何还提示下载？ 不明白）
	@ResponseBody 
	@RequestMapping(value = "/returnJson", produces = "application/json;charset=UTF-8") // 演示常规request访问参数，访问路径 /book/returnJson?id=123
	public Book returnJson(Long id, HttpServletRequest request) {
		return new Book(id,"鲁冰逊漂流记");
	}
	
	@ResponseBody
	@RequestMapping(value="/book",produces="text/plain;charset=UTF-8") // 演示解释参数到对象，访问路径为 /book/book?id=1&name=书名
	public String passBook(Book book,HttpServletRequest request){
		return "接受访问地址url =" + request.getRequestURL() + " 参数 book.id=" + book.getId() +" book.name=" + book.getName() ;
	}
	
	@RequestMapping(value={"/name1","/name2"}, produces = "text/plain;charset=UTF-8")// 映射不同访问路径到相同方法 访问路径 /book/name1  /book/name2
	public @ResponseBody String remove(HttpServletRequest request){
		return "接受访问地址url =" + request.getRequestURL() ;
	}
	
}
