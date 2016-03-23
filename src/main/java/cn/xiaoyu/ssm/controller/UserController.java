package cn.xiaoyu.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.xiaoyu.ssm.domain.User;
import cn.xiaoyu.ssm.service.UserService;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */

@Controller
@SessionAttributes("loginUser")
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String regist(Model model){
		System.out.println("hello world!");
		return "user/regist";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,String confirmpass){
		System.out.println(confirmpass);
		System.out.println(user.getUsername());
		return "user/login";
	}
}
