package com.activemq.queue.spring.maintest;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.activemq.queue.spring.ProducerService;
import com.util.framework.ApplicationContextHelper;

/**
 * 消息生产者测试类
 * @author Administrator
 *
 */


public class ProducerTest {

	private static ApplicationContext appContext = new ClassPathXmlApplicationContext( "spring-mybatis.xml");
	
	private static void send(){
		ProducerService producerService=(ProducerService)appContext.getBean("producerService");
		producerService.send();
		
	}
	
	
	public static void main(String[] args) {
		send();
	}
}
