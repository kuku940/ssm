package cn.xiaoyu.ssm.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xiaoyu.ssm.domain.User;
import cn.xiaoyu.ssm.service.UserService;

/**
 * @author 章小雨
 * @date 2016年3月23日
 * @email roingeek@qq.com
 */
public class TestMybatis {
	private UserService userService;
	 
    /**
     * 这个before方法在所有的测试方法之前执行，并且只执行一次
     * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
     * 比如在before方法里面初始化ApplicationContext和userService
     */
    @Before
    public void before(){
        //使用"beans.xml"配置文件创建Spring上下文
    	//ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"bean.xml","spring-mybatis.xml"});
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //从Spring容器中根据bean的id取出我们要使用的userService对象
        userService = (UserService) ctx.getBean("userService");
    }
 
    @Test
    public void testGetUserById(){
        User user = userService.getUserById(1);
        System.out.println(user.getUsername());
		System.out.println(user.getEmail());
    }
    
    @Test
    public void testSaveUser(){
    	User user = new User();
    	user.setUsername("wukong");
    	user.setEmail("wukong@xiaoyu.cn");
    	user.setPassword("123456");
    	user.setBirth(new Date());
    	userService.saveUser(user);
    }
    
    @Test
    public void testUpdateUser(){
    	User user = new User();
    	user.setId(3);
    	user.setUsername("wukong");
    	user.setEmail("wukong@xiaoyu.cn");
    	user.setPassword("wukong");
    	user.setBirth(new Date());
    	userService.updateUser(user);
    }
    
    @Test
    public void testDeleteUser(){
    	userService.deleteUser(3);
    }
}
