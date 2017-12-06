package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface MonitorDataDao extends BaseDao<MonitorData, String> {

	public MonitorData searchMonitorDataByLastMonitorTime(String wellNo);
	
	public List<MonitorData> searchMonitorDataByWellIdAndTimeInterval(String wellNo, Date startDate, Date endDate);

	public Page<MonitorData> getMonitorDataMsg(Page<MonitorData> pageMonitor,String wellNo, Date start_date, Date end_date);

	public List<MonitorData> getMonitorDataClassReport(String wellNo,String reporttime, String time);
	
	/**
	 * 获取所有井的最后一条实时数据
	 * @return
	 */
	public List<MonitorData> getAllWellLastTimeMonitorData(int _wellNum);
	
	public List<MonitorData> getAllWellMonitorDataByTimeInterval(Date _startDate, Date _endDate);
}
