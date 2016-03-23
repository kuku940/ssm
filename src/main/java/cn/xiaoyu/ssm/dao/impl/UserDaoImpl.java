package cn.xiaoyu.ssm.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.xiaoyu.ssm.dao.UserDao;
import cn.xiaoyu.ssm.domain.User;

/**
 * @author 章小雨
 * @date 2016年3月15日
 * @email roingeek@qq.com
 */

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User getUserById(int id) {
		return this.getSqlSession().selectOne("cn.xiaoyu.mybatis.inter.IUserOperation.getUserById",id);
	}
	
}
