package com.flyusoft.components.permission.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.flyusoft.components.permission.dao.UserDao;
import com.flyusoft.components.permission.entity.User;

@Repository
public class UserDaoImpl extends BaseHibernateDaoImpl<User, String> implements UserDao {

	//批量删除用户的HQL语句
	private static final String BATCH_DELETE_USER = "delete User u where u.id in (:ids)";

	/** 
	 * 批量删除
	 * @return 删除结果 -1为删除出错,大于0为删除成功
	 */
	@Override
	public int batchDeleteUser(List<String> ids) {
		Query query = getSession().createQuery(BATCH_DELETE_USER);
		if (ids != null && ids.size() > 0) {
			return query.setParameterList("ids", ids).executeUpdate();
		} else {
			return -1;
		}
	}
}
