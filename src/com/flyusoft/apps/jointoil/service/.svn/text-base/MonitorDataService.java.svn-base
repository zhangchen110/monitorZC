package com.flyusoft.apps.jointoil.service;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

public interface MonitorDataService {

	public void saveMonitorData(MonitorData monitorData);

	public Page<MonitorData> searchMonitorData(final Page<MonitorData> page,
			final List<PropertyFilter> filters);

	public MonitorData searchMonitorDataByLastMonitorTime(String wellNo);

	public MonitorData getMonitorDataMsg(String id);

	public Page<MonitorData> getMonitorDataMsg(Page<MonitorData> pageMonitor,
			String wellNo, Date start_date, Date end_date);

	/**
	 * 根据井Id与时间间隔去查询数据库
	 * 
	 * @return
	 */
	public List<MonitorData> getMonitorDataByWellIdAndTimeInterval(
			String wellNo, int timeInterval);
	/**
	 * 根据时间间隔获取所有井的实时数据
	 * @param _timeInterval 分钟
	 * @return
	 */
	public List<MonitorData> getAllWellMonitorDataByTimeInterval(int _timeInterval);

	/**
	 * 通过集合找到该井号对应的几分钟实时数据
	 * @param _wellNo 井号
	 * @param _timeInterval 分钟
	 * @param _list 已知集合
	 * @return
	 */
	public List<MonitorData> getAllWellMonitorDataByTimeInterval(String _wellNo,int _timeInterval,List<MonitorData> _list);
	
	// 查询班报信息
	public  MonitorData getMonitorDataClassReport(String wellNo,
			String reporttime, String time);
	/**
	 * 取所有井的最后一条数据
	 * @return
	 */
	public List<MonitorData> searchAllWellLastTimeMonitorData(int _wellNum);
	/**
	 * 从集合中获取最后一条数据
	 * @param _wellNo
	 * @param _list
	 * @return
	 */
	public MonitorData getLastTimeMonitorData(String _wellNo,List<MonitorData> _list);
}
