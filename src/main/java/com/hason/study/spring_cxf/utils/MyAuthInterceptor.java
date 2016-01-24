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
 * ͨ�� PhaseInterceptor������ָ�����������ĸ��׶�������
 * 
 * @author hason
 *
 */
public class MyAuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	private static final String USER_ID = "hason";
	private static final String USER_PASS = "hason";

	public MyAuthInterceptor() {
		// ����PRE_INVOKE ��ʾ�������ڵ���֮ǰ������Ϣ
		super(Phase.PRE_INVOKE);
	}

	/**
	 * ʵ���Լ���������ʱ����Ҫʵ�� handleMessage ������
	 * handleMessage �����Ĳ��� message �������ص���SOAP��Ϣ
	 * һ�������ȡ��Soap��Ϣ���Ϳ��Խ������޸�SOAP��Ϣ
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		System.out.println("MyAuthInterceptor ���ص���");
		
		// ��ʼ����SOAP��Ϣ��XMLƬ�Σ�
		List<Header> headerList = message.getHeaders(); // ����ͷ��
		if(headerList == null || headerList.size() == 0) {
			throw new Fault(new IllegalArgumentException("û��ͷ��"));
		}
		
		// ����Ҫ���һ��ͷ��Я�� �û���������
		Header header = headerList.get(0);
		Element element = (Element) header.getObject();
		// �����ʽ
		NodeList userIds = element.getElementsByTagName("userId");
		NodeList userPasswords = element.getElementsByTagName("userPassword");
		if(userIds.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("�û�����ʽ����"));
		}
		if(userPasswords.getLength() != 1) {
			throw new Fault(new IllegalArgumentException("�����ʽ����"));
		}
		
		// �õ���һ��userIdԪ������ı����ݣ��Ը�������Ϊ�û���������ͬ��
		String userId = userIds.item(0).getTextContent();
		String password = userPasswords.item(0).getTextContent();
		
		// ʵ����Ŀ�У����ѯ���ݿ⣬ƥ���û���Ϣ
		if(!USER_ID.equals(userId) || !USER_PASS.equals(password)) {
			throw new Fault(new IllegalArgumentException("�û����������"));
		}
		
	}

}
