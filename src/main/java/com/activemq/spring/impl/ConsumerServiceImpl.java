package com.activemq.spring.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.activemq.spring.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService{

	JmsTemplate jmsTemplate;
	Destination destination;
	
	@Override
	public void receive() {
		// TODO Auto-generated method stub
		MapMessage message = (MapMessage) jmsTemplate.receive();
		try {
			System.out.println("--收到消息：" + new Date(message.getLong("count")));
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}


}
