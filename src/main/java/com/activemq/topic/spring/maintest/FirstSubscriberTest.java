package com.activemq.topic.spring.maintest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.activemq.topic.spring.SubscriberService;

/**
 * 第一个订阅者消费消息
 * @author Administrator
 *
 */
public class FirstSubscriberTest {
	
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext( "spring-mybatis.xml");

	private static void receive() {
		SubscriberService firstSubscriberService = (SubscriberService) appContext.getBean("firstSubscriberService");
		firstSubscriberService.receive();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		receive();
	}


}
