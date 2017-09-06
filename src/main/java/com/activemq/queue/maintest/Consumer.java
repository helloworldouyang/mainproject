package com.activemq.queue.maintest;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 * 消息消费者 -对一模式
 * @author Administrator
 *
 */
public class Consumer {
	
	public static void main(String[] args) {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		String subject = "TOOL.DEFAULT";
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( user, password, url);
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(subject);
			MessageConsumer message = session.createConsumer(destination);
			message.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message msg) {
					// TODO Auto-generated method stub
					MapMessage message=(MapMessage)msg;
					try {
						System.out.println("----收到消息："+new Date(message.getLong("count")));
						session.commit();
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			Thread.sleep(30000);
			session.close();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

}
