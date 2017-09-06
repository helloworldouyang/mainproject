package com.activemq.topic.spring.impl;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.activemq.topic.spring.PublisherService;

public class PublisherServiceImpl implements PublisherService{
	
	JmsTemplate jmstemplate;
	 
	Destination destination;


	@Override
	public void send() {
		// TODO Auto-generated method stub
		MessageCreator messageCreator=new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				MapMessage message = session.createMapMessage();
				Date date = new Date();
				message.setLong("count", date.getTime());
				System.out.println("--发送消息："+date);
				return message;

			}
		};
		
		
		
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
