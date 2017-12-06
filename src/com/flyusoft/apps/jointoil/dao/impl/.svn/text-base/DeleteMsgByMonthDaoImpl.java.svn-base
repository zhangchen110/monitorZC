package com.flyusoft.apps.jointoil.dao.impl;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.DeleteMsgByMonthDao;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
@Repository
public class  DeleteMsgByMonthDaoImpl extends BaseHibernateDaoImpl implements DeleteMsgByMonthDao {

	private static final String DELETE_MSG_MONTH="call delete_data_proc(:dtime)";
	@Override
	public void delteMsg(Date _dTime) {
		Query query=getSession().createSQLQuery(DELETE_MSG_MONTH);
		query.setParameter("dtime", _dTime);
		query.executeUpdate();
	}

}
