package cn.xiaoyu.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import cn.xiaoyu.ssm.domain.User;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */
public interface UserService {

	// 根据ID来查询用户
	public User getUserById(int id);

	// 根据名称来模糊查询
	public List<User> getUserByName(String username);

	// 根据邮箱来查找用户
	public User getUserByEmail(String email);

	// 保存用户
	public void saveUser(User user);

	@Update("update user set username=#{username},age=#{age},address=#{address},birth=#{birth} where id=#{id}")
	public void updateUser(User user);

	@Delete("delete from user where id=#{id}")
	public void deleteUser(int id);
}
