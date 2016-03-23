package cn.xiaoyu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

	@Override
	public List<User> getUserByName(String username) {
		return this.userDao.getUserByName(username);
	}

	@Override
	public User getUserByEmail(String email) {
		return this.userDao.getUserByEmail(email);
	}


	@Override
	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}


	@Override
	public void updateUser(User user) {
		this.userDao.updateUser(user); 
	}

	@Override
	public void deleteUser(int id) {
		this.userDao.deleteUser(id);
	}
	
}
