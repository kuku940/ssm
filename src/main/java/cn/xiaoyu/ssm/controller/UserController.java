package cn.xiaoyu.ssm.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		model.addAttribute("user", new User());
		return "user/regist";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,String confirmpass,Model model){
		if(user.getPassword().equals(confirmpass)){
			userService.saveUser(user);
			model.addAttribute("user", user);
			return "user/login";
		}else{
			model.addAttribute("error", "两次输入密码不一致");
			model.addAttribute("user", user);
			return "user/regist";
		}
	}
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("user",new User());
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model){
		User u = userService.getUserByEmail(user.getEmail());
		if(u != null && u.getPassword().equals(user.getPassword())){
			return "user/list";
		}else{
			model.addAttribute("user",user);
			model.addAttribute("error","用户名或密码不正确！");
			return "user/login";
		}
	}
}