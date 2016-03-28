package cn.xiaoyu.ssm.test;

import java.util.Date;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestActivemq {
	
	@Test
	public void testQueueSend(){
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:beans.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsQueueTemplate");
		jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("message", "当前时间是："+new Date().getTime());
                System.out.println(123);
                return message;
            }
        });
	}
	
	@Test
	public void testQueueReceive(){
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:beans.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsQueueTemplate");
		while(true) {  
            Map<String, Object> map =  (Map<String, Object>) jmsTemplate.receiveAndConvert();  
            System.out.println("收到消息：" + map.get("message"));  
        } 
	}
}
