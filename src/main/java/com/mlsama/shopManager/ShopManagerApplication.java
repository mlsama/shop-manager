package com.mlsama.shopManager;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopManagerApplication {

	public static void main(String[] args) {
		/** 创建SpringApplication应用对象 */
		SpringApplication springApplication = new SpringApplication(ShopManagerApplication.class);
		/** 设置横幅模式(设置关闭) */
		springApplication.setBannerMode(Banner.Mode.OFF);
		/** 运行 */
		springApplication.run(args);
	}
}
