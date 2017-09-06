package com.activemq.queue.maintest;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息生产者  -对一模式
 * @author Administrator
 *
 */
public class Producer {
	
	
	public static void main(String[] args) {
		
		String user = ActiveMQConnection.DEFAULT_USER; 
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		String subject = "TOOL.DEFAULT";
		ConnectionFactory contectionFactory = new ActiveMQConnectionFactory( user, password, url);  //开启连接
		try {
			Connection connection = contectionFactory.createConnection();  //创建连接
			connection.start();  //启动连接
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); //创建session
			Destination destination = session.createQueue(subject);
			MessageProducer producer = session.createProducer(destination);
			
			for (int i = 0; i <= 20; i++) {
				MapMessage message = session.createMapMessage();
				Date date = new Date(); 
				message.setLong("count", date.getTime());
				Thread.sleep(1000);
				producer.send(message);
				System.out.println("--发送消息：" + date);
			}
			
			session.commit();
			session.close();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			
			
		}

	}
}
