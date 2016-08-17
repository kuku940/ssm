package cn.xiaoyu.ssm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.xiaoyu.ssm.service.UserService;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */
public class TestConn {
	ApplicationContext ctx;
	@Before
	public void init(){
		 //ctx = new ClassPathXmlApplicationContext("beans.xml");  
		ctx = new FileSystemXmlApplicationContext("classpath*:beans.xml");
	}
		
	@Test
	public void openSession(){
		System.out.println(ctx.getBean("sqlSessionFactory"));
		UserService bean = (UserService) ctx.getBean("userService");
	}

}
