package com.duopei.springmvc.web.example;

import com.duopei.springmvc.config.WebConfig;
import com.duopei.springmvc.model.menu.Menu;
import com.duopei.springmvc.model.user.User;
import com.duopei.springmvc.web.admin.service.MenuService;
import com.duopei.springmvc.web.admin.service.TestItemService;
import com.duopei.springmvc.web.admin.service.UserService;
import com.duopei.springmvc.web.example.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebConfig.class)
//@WebAppConfiguration注解在类上，用来声明加载ApplicationContext是一个WebApplicationContext。他的属性是定位到web资源文件。
@WebAppConfiguration("src/main/resources") 
public class TestControllerIntegrationTests {

	private MockMvc mockMvc; // 模拟mvc对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build() 来初始化
	
	@Autowired
	private DemoService demoService;// 可以在测试中注入Spring Bean
	
	@Autowired
	WebApplicationContext wac;
	
	@SuppressWarnings("unused")
	@Autowired
	private MockHttpSession session; // 也可
	
	@SuppressWarnings("unused")
	@Autowired
	private MockHttpServletRequest request;


	@Autowired
	TestItemService testItemService;

	@Autowired
	UserService userService;

	@Autowired
	MenuService menuService;
	
	@Before // 测试开始之前的初始化工作
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void TestMybatisController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/user/xxx"));
	}


	@Test
	public void TestTransaction() throws Exception{
		//mockMvc.perform(MockMvcRequestBuilders.post("/trans/order")) ;
		testItemService.order("1001","100001",1);
	}

	@Test
	public void TestMethod() throws Exception{
		User user = new User();
		List<Menu> list = menuService.selectMenu(user);
		System.out.println("size="+list.size());
		for (Menu menu : list) {
			System.out.println(menu.getMenuName());
			if(null != menu.getDmenus()) {
				for (Menu menu1 : menu.getDmenus()) {
					System.out.println("======\t==" + menu1.getMenuName());
				}
			}
		}
		System.out.println(">>>>>>>>>>>>");

	}

	@Test
	public void TestPage(){
		testItemService.selectAllItemByPage();
	}


	@Test
	public void TestNormalController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/index")) //模拟想 /index 进行get请求
				.andExpect(MockMvcResultMatchers.status().isOk()) // 预期返回状态
				.andExpect(MockMvcResultMatchers.view().name("index")) // 预期view的名称
				
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/index.jsp")) // 预期页面跳转的真正路径
				//.andExpect(MockMvcResultMatchers.model().attribute("msg", this.demoService.saySomeThing()))
				;
				
	}
	
	@Test
	public void TestRestController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/book"))
		
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("page"))
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8")) // 预期返回的媒体类型
				
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp"))
				.andExpect(MockMvcResultMatchers.model().attribute("msg", this.demoService.saySomeThing()));
				
	}

}
