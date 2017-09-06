package com.activemq.queue.spring.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.activemq.queue.spring.ConsumerService;


public class ConsumerServiceImpl implements ConsumerService{

	JmsTemplate jmstemplate;
	Destination destination;
	
	@Override
	public void receive() {
		// TODO Auto-generated method stub
		MapMessage message = (MapMessage) jmstemplate.receive();
		try {
			System.out.println("--收到消息：" + new Date(message.getLong("count")));
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmstemplate = jmsTemplate;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
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

	

}
