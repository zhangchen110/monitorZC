package com.flyusoft.apps.jointoil.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.AlarmLogDao;
import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.flyusoft.common.orm.Page;

@Repository
public class AlarmLogDaoImpl extends BaseHibernateDaoImpl<AlarmLog, String> implements AlarmLogDao{
	
	private static final String BATCH_DELETE_USER = "from  AlarmLog a where a.time >no1 and a.time <no2 and a.id (:ids)";
	
	private final static String QUERY_ALARMLOG_BY_TIME = "from AlarmLog where time between ? and ?";

	private final static String QUERY_ALL_ISALARM_MESSAGE="from AlarmLog al where al.status=0";
	@Override
	public List searchDate(Date dateSta, Date dateEnd, List ids) {
		
			Query query = getSession().createQuery(BATCH_DELETE_USER);
			
			return query.setParameter("no1", dateSta.toString()).setParameter("no2", dateEnd.toString() ).setParameterList("ids",ids ).list();
		 
		
	}

	@Override
	public Page<AlarmLog> getAlarmLogTime(Page<AlarmLog> page,
			Date today_start, Date today_end) {
		return findPage(page,QUERY_ALARMLOG_BY_TIME, today_start,today_end);
	}

	@Override
	public List<AlarmLog> searchAllAlarmLogs() {
		return createQuery(QUERY_ALL_ISALARM_MESSAGE).list();
	}

	 

}
