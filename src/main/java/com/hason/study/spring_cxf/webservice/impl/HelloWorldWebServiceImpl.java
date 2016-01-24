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
 * Web Service ����ʵ��ҵ���߼���ҵ����serviceʵ��
 * Web Service ֻ�ǵ���ҵ������ķ�������¶Web Service
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
		// Web Service ����ʵ��ҵ���߼���ҵ����serviceʵ��
		// Web Service ֻ�ǵ���ҵ������ķ�������¶Web Service
		UserService userService = new UserServiceImpl();
		return userService.getCatByUser(user);
	}

	@Override
	public Map<String, Cat> getAllCats() {
		UserService userService = new UserServiceImpl();
		return userService.getAllCats();
	}

}
