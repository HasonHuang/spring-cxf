package com.hason.study.spring_cxf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 项目的唯一启动入口
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}
}
