package com.hason.study.spring_cxf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hason.study.spring_cxf.entity.Cat;
import com.hason.study.spring_cxf.entity.User;
import com.hason.study.spring_cxf.service.UserService;

public class UserServiceImpl implements UserService {
	
	// 这里使用 Map 模拟数据库的数据
	private static Map<User, List<Cat>> cat = new HashMap<User, List<Cat>>();
	
	static {
		List<Cat> catList = new ArrayList<Cat>();
		Cat cat1 = new Cat();
		cat1.setId(1);
		cat1.setName("叮当猫");
		cat1.setColor("蓝色+白色");
		catList.add(cat1);
		Cat cat2 = new Cat();
		cat2.setId(1);
		cat2.setName("咖啡猫");
		cat2.setColor("咖啡色");
		catList.add(cat2);
		User user1 = new User();
		user1.setId(1);
		user1.setName("hason1");
		user1.setAge(18);
		cat.put(user1, catList);
		
		List<Cat> catList2 = new ArrayList<Cat>();
		Cat cat3 = new Cat();
		cat3.setId(1);
		cat3.setName("叮当猫");
		cat3.setColor("蓝色+白色");
		catList2.add(cat3);
		Cat cat4 = new Cat();
		cat4.setId(1);
		cat4.setName("咖啡猫");
		cat4.setColor("咖啡色");
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
				resultMap.put("第" + i++ + "个", cat);
			}
		}
		return resultMap;
	}
	
}
