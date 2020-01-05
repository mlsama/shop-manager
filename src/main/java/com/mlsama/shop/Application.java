package com.mlsama.shop;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		/** 创建SpringApplication应用对象 */
		SpringApplication springApplication = new SpringApplication(Application.class);
		/** 设置横幅模式(设置关闭) */
		springApplication.setBannerMode(Banner.Mode.OFF);
		/** 运行 */
		springApplication.run(args);
	}
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//指定启动类
		return builder.sources(Application.class);
	}*/
}
