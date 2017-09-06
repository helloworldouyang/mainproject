package com.activemq.topic.spring.impl;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;

import com.activemq.topic.spring.SubscriberService;


/**
 * 订阅者一接收消息
 * @author Administrator
 *
 */
public class FirstSubscriberServiceImpl implements SubscriberService{

	JmsTemplate jmstemplate;
	Destination destination;
	
	
	@Override
	public void receive() {
		
		MapMessage message = (MapMessage) jmstemplate.receive();
		try {
			System.out.println("--订阅者一收到消息：" + new Date(message.getLong("count")));
		} catch (JMSException e) {
			e.printStackTrace();
		}

		
	}


	
	
	public JmsTemplate getJmstemplate() {
		return jmstemplate;
	}


	public void setJmstemplate(JmsTemplate jmstemplate) {
		this.jmstemplate = jmstemplate;
	}


	public Destination getDestination() {
		return destination;
	}


	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	
	

}
