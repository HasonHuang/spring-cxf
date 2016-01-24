package com.hason.study.spring_cxf.utils;

import java.util.List;

import com.hason.study.spring_cxf.entity.Cat;

public class StringCatMap {

	private List<MyEntry> entries ;
	
	public List<MyEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MyEntry> entries) {
		this.entries = entries;
	}
}

class MyEntry {
	private String key;
	private Cat value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Cat getValue() {
		return value;
	}
	public void setValue(Cat value) {
		this.value = value;
	}
}