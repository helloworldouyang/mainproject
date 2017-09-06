package com.activemq.queue.spring.maintest;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.activemq.queue.spring.ConsumerService;
import com.util.framework.ApplicationContextHelper;

/**
 * 消息消费者测试类
 * @author Administrator
 *
 */


public class ConsumerTest {
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext( "spring-mybatis.xml");
	
	private static void receive(){
		ConsumerService consumerService=(ConsumerService)appContext.getBean("consumerService");
		consumerService.receive();
	}
	
	
	public static void main(String[] args) {
		receive();
	}
}
