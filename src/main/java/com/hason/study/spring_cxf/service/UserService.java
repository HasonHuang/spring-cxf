package com.hason.study.spring_cxf.service;

import java.util.List;
import java.util.Map;

import com.hason.study.spring_cxf.entity.Cat;
import com.hason.study.spring_cxf.entity.User;


public interface UserService {

	public List<Cat> getCatByUser(User user);
	
	public Map<String, Cat> getAllCats();
}
