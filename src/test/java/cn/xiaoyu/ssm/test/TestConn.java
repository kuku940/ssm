package cn.xiaoyu.ssm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */
public class TestConn {
	ApplicationContext ctx;
	@Before
	public void init(){
		 ctx = new ClassPathXmlApplicationContext("beans.xml");  
	}
		
	@Test
	public void openSession(){
		System.out.println(ctx.getBean("sqlSessionFactory"));
		Object bean = ctx.getBean("userService");
	}

}
