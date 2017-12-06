package com.flyusoft.apps.jointoil.service;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

public interface AlarmLogService {

	public AlarmLog getAlarmLog(String id);

	/**
	 * 使用属性过滤条件查询用户.
	 */
	public Page<AlarmLog> searchAlarmLog(final Page<AlarmLog> page,	final List<PropertyFilter> filters);

	public void saveAlarmLog(AlarmLog alarmLog);

	public Page<AlarmLog> getAlarmLogTime(Page<AlarmLog> page,	Date today_start, Date today_end);
	
	/**
	 * 查找所有需要报警的信息
	 * 
	 */
	public List<AlarmLog> searchAllAlarmLogs();

}
