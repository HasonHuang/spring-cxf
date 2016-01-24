package com.hason.study.spring_cxf.utils;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 通过 PhaseInterceptor，可以指定拦截器在哪个阶段起作用
 * 
 * @author hason
 *
 */
public class MyAuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	private static final String USER_ID = "hason";
	private static final String USER_PASS = "hason";

	public MyAuthInterceptor() {
		// 参数PRE_INVOKE 表示拦截器在调用之前拦截消息
		super(Phase.PRE_INVOKE);
	}

	/**
	 * 实现自己的拦截器时，需要实现 handleMessage 方法。
	 * handleMessage 方法的参数 message 就是拦截到的SOAP消息
	 * 一旦程序获取到Soap消息，就可以解析、修改SOAP消息
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		System.out.println("MyAuthInterceptor 拦截到啦");
		
		// 开始解析SOAP消息（XML片段）
		List<Header> headerList = message.getHeaders(); // 所有头部
		if(headerList == null || headerList.size() == 0) {
			throw new Fault(new IllegalArgumentException("没有头部"));
		}
		
		// 假如要求第一个头部携带 用户名和密码
		Header header = headerList.get(0);
		Element element = (Element) header.getObject();
		// 检验格式
		NodeList userIds = element.getElementsByTagName("userId");
		NodeList userPasswords = element.getElementsByTagName("userPassword");
		if(userIds.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("用户名格式不对"));
		}
		if(userPasswords.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("密码格式不对"));
		}
		
		// 得到第一个userId元素里的文本内容，以该内容作为用户名；密码同理
		String userId = userIds.item(0).getTextContent();
		String password = userPasswords.item(0).getTextContent();
		
		// 实际项目中，会查询数据库，匹配用户信息
		if(!USER_ID.equals(userId) || !USER_PASS.equals(password)) {
			throw new Fault(new IllegalArgumentException("用户、密码错误"));
		}
		
	}

}
