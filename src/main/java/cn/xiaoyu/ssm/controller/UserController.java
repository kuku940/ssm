package cn.xiaoyu.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.xiaoyu.ssm.service.UserService;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable(value="id") int id,Model model){
		model.addAttribute(userService.getUserById(id));
		return "user/show";
	}
}
