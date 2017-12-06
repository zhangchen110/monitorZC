package com.flyusoft.components.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.flyusoft.common.service.ServiceException;
import com.flyusoft.components.permission.dao.UserDao;
import com.flyusoft.components.permission.entity.User;
import com.flyusoft.components.permission.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteUser(String id) {
		userDao.delete(id);
	}

	/** 
	 * 批量删除
	 * @return 删除结果 -1为删除出错,大于0为删除成功
	 */
	@Override
	public void batchDeleteUser(List<String> ids) {
		int num = userDao.batchDeleteUser(ids);
		if (num == -1) {
			throw new ServiceException("批量删除用户失败");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public User getUser(String id) {
		return userDao.get(id);
	}

	/**
	 * 使用属性过滤条件查询用户.
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<User> searchUser(final Page<User> page, final List<PropertyFilter> filters) {
		return userDao.findPage(page, filters);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByLoginName(String loginName) {
		return userDao.findUniqueBy("loginName", loginName);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isLoginNameUnique(String newLoginName, String oldLoginName) {
		return userDao.isPropertyUnique("loginName", newLoginName, oldLoginName);
	}

}
