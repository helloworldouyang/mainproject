package com.activemq.queue.spring;


/**
 * 消费者接口
 * @author Administrator
 *
 */
public interface ConsumerService {

	
	/**
	 * 接受消息
	 */
	public void receive();
}
