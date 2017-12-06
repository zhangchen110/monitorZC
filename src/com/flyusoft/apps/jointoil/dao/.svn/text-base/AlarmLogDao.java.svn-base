package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface AlarmLogDao extends BaseDao<AlarmLog,String> {
	
	public List  searchDate(Date dateSta,Date dateEnd, List ids);

	public Page<AlarmLog> getAlarmLogTime(Page<AlarmLog> page,Date today_start, Date today_end);

	/**
	 * 查找所有需要报警的信息
	 * @return
	 */
	public List<AlarmLog> searchAllAlarmLogs();
	
}
