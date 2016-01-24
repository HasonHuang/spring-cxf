package com.hason.study.spring_cxf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hason.study.spring_cxf.entity.Cat;
import com.hason.study.spring_cxf.entity.User;
import com.hason.study.spring_cxf.service.UserService;

public class UserServiceImpl implements UserService {
	
	// ����ʹ�� Map ģ�����ݿ������
	private static Map<User, List<Cat>> cat = new HashMap<User, List<Cat>>();
	
	static {
		List<Cat> catList = new ArrayList<Cat>();
		Cat cat1 = new Cat();
		cat1.setId(1);
		cat1.setName("����è");
		cat1.setColor("��ɫ+��ɫ");
		catList.add(cat1);
		Cat cat2 = new Cat();
		cat2.setId(1);
		cat2.setName("����è");
		cat2.setColor("����ɫ");
		catList.add(cat2);
		User user1 = new User();
		user1.setId(1);
		user1.setName("hason1");
		user1.setAge(18);
		cat.put(user1, catList);
		
		List<Cat> catList2 = new ArrayList<Cat>();
		Cat cat3 = new Cat();
		cat3.setId(1);
		cat3.setName("����è");
		cat3.setColor("��ɫ+��ɫ");
		catList2.add(cat3);
		Cat cat4 = new Cat();
		cat4.setId(1);
		cat4.setName("����è");
		cat4.setColor("����ɫ");
		catList2.add(cat4);
		User user2 = new User();
		user2.setId(2);
		user2.setName("hason2");
		user2.setAge(19);
		cat.put(user2, catList2);
	}

	@Override
	public List<Cat> getCatByUser(User user) {
		return cat.get(user);
	}

	@Override
	public Map<String, Cat> getAllCats() {
		Map<String, Cat> resultMap = new HashMap<String, Cat>();
		int i = 0;
		for(List<Cat> catList : cat.values()) {
			for(Cat cat : catList) {
				resultMap.put("��" + i++ + "��", cat);
			}
		}
		return resultMap;
	}
	
}
