package com.hason.study.spring_cxf.webservice.impl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hason.study.spring_cxf.entity.Cat;
import com.hason.study.spring_cxf.entity.User;
import com.hason.study.spring_cxf.service.UserService;
import com.hason.study.spring_cxf.service.impl.UserServiceImpl;
import com.hason.study.spring_cxf.webservice.HelloWorldWebService;

/**
 * Web Service 本身不实现业务逻辑，业务由service实现
 * Web Service 只是调用业务组件的方法来暴露Web Service
 * @author hason
 *
 */
@WebService
public class HelloWorldWebServiceImpl implements HelloWorldWebService{

	@Override
	public String sayHi(String name) {
		String str = "Hello " + name;
		return str;
	}

	@Override
	public List<Cat> getCatByUser(User user) {
		// Web Service 本身不实现业务逻辑，业务由service实现
		// Web Service 只是调用业务组件的方法来暴露Web Service
		UserService userService = new UserServiceImpl();
		return userService.getCatByUser(user);
	}

	@Override
	public Map<String, Cat> getAllCats() {
		UserService userService = new UserServiceImpl();
		return userService.getAllCats();
	}

}
