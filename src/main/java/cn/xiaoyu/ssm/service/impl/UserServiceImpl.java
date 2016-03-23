package cn.xiaoyu.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoyu.ssm.dao.UserDao;
import cn.xiaoyu.ssm.domain.User;
import cn.xiaoyu.ssm.service.UserService;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
}
