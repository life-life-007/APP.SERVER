package org.veight.logon.action;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.veight.logon.service.LogonService;

public class TestAopLog4j {
	public static void main(String args[]){
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		LogonService logonService = (LogonService)factory.getBean("logonService");
		logonService.logon("GuoJing", "888888");
	}
}	
