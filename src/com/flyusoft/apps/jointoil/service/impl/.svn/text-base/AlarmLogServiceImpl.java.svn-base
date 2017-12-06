package com.flyusoft.apps.jointoil.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.AlarmLogDao;
import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.apps.jointoil.service.AlarmLogService;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

@Service
@Transactional
public class AlarmLogServiceImpl implements AlarmLogService {

	@Autowired
	private AlarmLogDao alarmLogDao;

	@Override
	@Transactional(readOnly = true)
	public AlarmLog getAlarmLog(String id) {
		return alarmLogDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<AlarmLog> searchAlarmLog(Page<AlarmLog> page, List<PropertyFilter> filters) {
		return alarmLogDao.findPage(page, filters);
	}

	@Override
	public void saveAlarmLog(AlarmLog alarmLog) {
		alarmLogDao.save(alarmLog);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<AlarmLog> getAlarmLogTime(Page<AlarmLog> page,
			Date today_start, Date today_end) {
		return alarmLogDao.getAlarmLogTime(  page,  today_start,   today_end);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlarmLog> searchAllAlarmLogs() {
		
		return alarmLogDao.searchAllAlarmLogs();
	}

	 

}
