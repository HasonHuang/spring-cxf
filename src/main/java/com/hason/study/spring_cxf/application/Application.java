package com.hason.study.spring_cxf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// ��Ŀ��Ψһ�������
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}
}
