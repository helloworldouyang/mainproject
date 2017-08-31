package com.activemq.spring.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.activemq.spring.ProducerService;

/**
 * 消息生产者实现类
 * @author Administrator
 *
 */
public class ProducerServiceImpl implements ProducerService{

	JmsTemplate jmsTemplate;
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
		jmsTemplate.send(this.destination,messageCreator);
		
	}

}
