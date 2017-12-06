package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.AlarmLog;
import com.flyusoft.apps.jointoil.service.AlarmLogService;

public class InsertAlarmThread implements Runnable {

	private List<AlarmLog> list;
	private AlarmLogService alarmLogService;

	public InsertAlarmThread(AlarmLogService alarmLogService,
			List<AlarmLog> list) {
		super();
		this.alarmLogService = alarmLogService;
		this.list = list;
	}

	public InsertAlarmThread() {
		super();
	}

	@Override
	public void run() {
		for (AlarmLog alarmLog : list) {
			alarmLogService.saveAlarmLog(alarmLog);
		}
	}

	public List<AlarmLog> getList() {
		return list;
	}

	public void setList(List<AlarmLog> list) {
		this.list = list;
	}

	public AlarmLogService getAlarmLogService() {
		return alarmLogService;
	}

	public void setAlarmLogService(AlarmLogService alarmLogService) {
		this.alarmLogService = alarmLogService;
	}

}
