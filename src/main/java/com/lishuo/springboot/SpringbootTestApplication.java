package com.lishuo.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


/**
 *  在启动类上面使用 @ServletComponentScan 注解后
 *  Servlet、Filter、listener 可以直接通过配置
 *  @WebServlet @WebFilter @WebListener 注解自动注册  无需代码
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.lishuo.springboot.mapper")
public class SpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}

}
