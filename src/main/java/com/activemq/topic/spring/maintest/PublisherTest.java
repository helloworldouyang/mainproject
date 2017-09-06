package com.activemq.topic.spring.maintest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.activemq.topic.spring.PublisherService;

/**
 * 消息生产者
 * @author Administrator
 *
 */
public class PublisherTest {

	private static ApplicationContext appContext = new ClassPathXmlApplicationContext( "spring-mybatis.xml");

	private static void send() {
		PublisherService publisherService = (PublisherService) appContext.getBean("publisherService");
		publisherService.send();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		send();
	}

	
	
}
