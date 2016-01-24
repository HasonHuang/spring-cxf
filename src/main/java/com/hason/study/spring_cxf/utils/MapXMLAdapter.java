package com.hason.study.spring_cxf.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.hason.study.spring_cxf.entity.Cat;

/**
 * 转换器：StringCatMap 与 Map<String, Cat> 之间互相转换
 * @author hason
 *
 */
public class MapXMLAdapter extends XmlAdapter<StringCatMap, Map<String, Cat>>{

	@Override
	public Map<String, Cat> unmarshal(StringCatMap v) throws Exception {
		// StringCatMap  -->  Map<String, Cat>
		Map<String, Cat> resultMap = new HashMap<String, Cat>();
		
		for(MyEntry entry : v.getEntries()) {
			resultMap.put(entry.getKey(), entry.getValue());
		}
		
		return resultMap;
	}

	@Override
	public StringCatMap marshal(Map<String, Cat> v) throws Exception {
		// Map<String, Cat>  -->  StringCatMap
		StringCatMap result = new StringCatMap();
		List<MyEntry> myEnties = new ArrayList<MyEntry>();
		
		for(Entry<String, Cat> entry : v.entrySet()) {
			MyEntry myEntry = new MyEntry();
			myEntry.setKey(entry.getKey());
			myEntry.setValue(entry.getValue());
			myEnties.add(myEntry);
		}
		
		result.setEntries(myEnties);
		
		return result;
	}

}
