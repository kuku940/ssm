package cn.xiaoyu.ssm.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.xiaoyu.ssm.domain.Mail;
import cn.xiaoyu.ssm.util.MailUtil;
/**
 * 使用实现MessageListener接口的方式来实现Queue（点对点）方式的实现类
 * @author 章小雨
 * @time 2016年3月28日 上午11:03:08
 * @email roingeek@qq.com
 * @qq 1349274643
 */
public class ConsumerMessageListener implements MessageListener{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	public void onMessage(Message msg) {
		if(msg instanceof MapMessage){
			try {
				MapMessage message = (MapMessage) msg;
				Mail mail = (Mail) message.getObject("mail");
				System.out.println("coming ..");
				boolean b = true;//MailUtil.send(mail);
				if(b){
					logger.info("向注册用户{}发送验证邮件成功！",mail.getReceiver());
				}else{
					logger.info("向注册用户{}发送验证邮件失败！",mail.getReceiver());
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
