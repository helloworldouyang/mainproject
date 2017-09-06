package com.activemq.topic.spring.maintest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.activemq.topic.spring.SubscriberService;

public class SecondSubscriberTest {
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext( "spring-mybatis.xml");

	private static void receive() {
		SubscriberService secondSubscriberService = (SubscriberService) appContext.getBean("secondSubscriberService");
		secondSubscriberService.receive();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		receive();
	}


}
