package com.flyusoft.components.permission.service;

import java.util.List;

import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.flyusoft.components.permission.entity.User;

public interface UserService {

	public void saveUser(User user);

	public void deleteUser(String id);

	/** 
	 * 批量删除
	 * @return 删除结果 -1为删除出错,大于0为删除成功
	 */
	public void batchDeleteUser(List<String> ids);

	public User getUser(String id);

	/**
	 * 使用属性过滤条件查询用户.
	 */
	public Page<User> searchUser(final Page<User> page, final List<PropertyFilter> filters);

	/**
	 * 根据用户名查询用户.
	 *
	 * @return loginName在数据库中对应的User.
	 */
	public User findUserByLoginName(String loginName);

	/**
	 * 检查用户名是否唯一.
	 *
	 * @return loginName在数据库中唯一或等于oldLoginName时返回true.
	 */
	public boolean isLoginNameUnique(String newLoginName, String oldLoginName);
}
