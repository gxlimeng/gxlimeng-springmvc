package com.duopei.spring.inject;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.duopei.gxlimeng.spring.inject")
@PropertySource(value="classpath:com/duopei/gxlimeng/spring/inject/test.properties" ,encoding="UTF-8") //
public class ElConfig {

	// 注入普通字符串
	@Value("注入普通字符串")
	private String normal;

	// 注入操作系統屬性
	@Value("#{systemProperties['os.name']}")
	private String osName;

	// 注入表達式結果
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;

	// 注入其它Bean的屬性
	@Value("#{propertiesService.another}")
	private String fromAnother;

	// 注入文件資源
	@Value("classpath:com/duopei/gxlimeng/spring/inject/test.txt")
	private Resource resFile;

	// 注入網址資源
	@Value("http://www.baidu.com")
	private Resource url;

	// 注入配置文件 ，注入配置文件需要使用@PropertySource指定文件路徑，注意@Value("${book.name}") 使用的是“$”而不是”#“
	@Value("${book.name}")
	private String bookName;

	// 注入配置文件，還可以從Environment中得到
	@Autowired
	private Environment environment;

	/*@Bean 
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}*/

	public void outputResource() {
		try {
			System.out.println("normal=" + normal);
			System.out.println("osName=" + osName);
			System.out.println("randomNumber=" + randomNumber);
			System.out.println("fromAnother=" + fromAnother);
			System.out.println("resFile=" + IOUtils.toString(resFile.getInputStream()));
			System.out.println("url=" + IOUtils.toString(url.getInputStream()));
			System.out.println("bookName=" + bookName);
			System.out.println("environment.book.aother=" + environment.getProperty("book.aother"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
