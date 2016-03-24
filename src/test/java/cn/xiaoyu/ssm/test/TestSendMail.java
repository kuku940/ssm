package cn.xiaoyu.ssm.test;

import org.junit.Test;

import cn.xiaoyu.ssm.domain.Mail;
import cn.xiaoyu.ssm.util.MD5Util;
import cn.xiaoyu.ssm.util.MailUtil;

/**
 * @author 章小雨
 * @date 2016年3月24日
 * @email roingeek@qq.com
 */
public class TestSendMail {
	@Test
	public void sendMail(){
		Mail mail = new Mail();
		mail.setReceiver("roingeek@qq.com");
		mail.setSubject("邮箱验证信息");
		String message = MD5Util.encrypt("roingeek@qq.com");
		System.out.println(message);
		mail.setMessage(message);
		
		//new MailUtil().send(mail);
	}
}
