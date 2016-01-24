package com.hason.study.spring_cxf.webservice;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.hason.study.spring_cxf.entity.Cat;
import com.hason.study.spring_cxf.entity.User;
import com.hason.study.spring_cxf.utils.MapXMLAdapter;

@WebService
public interface HelloWorldWebService {

	public String sayHi(String name);
	
	public List<Cat> getCatByUser(User user);
	
	public @XmlJavaTypeAdapter(MapXMLAdapter.class) Map<String, Cat> getAllCats();
}
