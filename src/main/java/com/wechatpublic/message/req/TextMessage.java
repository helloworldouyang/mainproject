package com.wechatpublic.message.req;

import com.wechatpublic.message.req.BaseMessage;
/**
 * ��Ϣ����
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage{
	
	// ��Ϣ����  
    private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}  

}
