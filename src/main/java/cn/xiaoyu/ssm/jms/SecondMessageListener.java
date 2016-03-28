package cn.xiaoyu.ssm.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
/**
 * 使用实现MessageListener接口的方式来实现Topic（发布/订阅）方式实现类
 * @author 章小雨
 * @time 2016年3月28日 上午11:05:49
 * @email roingeek@qq.com
 * @qq 1349274643
 */
public class SecondMessageListener implements MessageListener {

	public void onMessage(Message msg) {
		if (msg instanceof MapMessage) {
			MapMessage message = (MapMessage) msg;
			try {
				System.out.println("--订阅者二MessageListener收到信息：" + message.getString("message"));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

}
