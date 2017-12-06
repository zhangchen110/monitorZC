package com.flyusoft.apps.jointoil.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.MonitorDataDao;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.google.common.collect.Lists;

@Service
@Transactional
public class MonitorDataServiceImpl implements MonitorDataService {

	@Autowired
	private MonitorDataDao monitorDataDao;

	@Override
	public void saveMonitorData(MonitorData monitorData) {
		monitorDataDao.save(monitorData);
	}

	/**
	 * 使用属性过滤条件查询用户.
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<MonitorData> searchMonitorData(final Page<MonitorData> page,
			final List<PropertyFilter> filters) {
		return monitorDataDao.findPage(page, filters);
	}

	/**
	 * 查询最近时间的监测数据.
	 */
	@Override
	@Transactional(readOnly = true)
	public MonitorData searchMonitorDataByLastMonitorTime(String wellNo) {
		return monitorDataDao.searchMonitorDataByLastMonitorTime(wellNo);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<MonitorData> getMonitorDataMsg(Page<MonitorData> pageMonitor,
			String wellNo, Date start_date, Date end_date) {
		return monitorDataDao.getMonitorDataMsg(pageMonitor, wellNo,
				start_date, end_date);
	}

	@Override
	@Transactional(readOnly = true)
	public MonitorData getMonitorDataMsg(String id) {
		return monitorDataDao.get(id);
	}

	/**
	 * 通过时间间隔和井号查询MonitorData
	 */
	@Override
	@Transactional(readOnly = true)
	public List<MonitorData> getMonitorDataByWellIdAndTimeInterval(
			String wellNo, int timeInterval) {

		Calendar nowDate = Calendar.getInstance();// 取得现在时间
		Date endDate = nowDate.getTime();// 转成Date
		nowDate.add(Calendar.MINUTE, -(timeInterval));
		Date startDate = nowDate.getTime();
		return monitorDataDao.searchMonitorDataByWellIdAndTimeInterval(wellNo,
				startDate, endDate);
	}


	@Override
	@Transactional(readOnly = true)
	public  MonitorData  getMonitorDataClassReport(String wellNo,
			String reporttime, String time) {
		//查询一段时间内的信息
		List<MonitorData> list = monitorDataDao.getMonitorDataClassReport(
				wellNo, reporttime, time);
		MonitorData mon = new MonitorData();
		//取出第一个信息
		if (list.size() > 0) {
			mon = list.get(0);
		}else{
			mon.setTemperature(0.0);
			mon.setPressure(0.00);
			mon.setInstantaneousFlow(0.00);
			mon.setAccumulativeFlow(0.00);
		}
		return mon;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MonitorData> searchAllWellLastTimeMonitorData(int _wellNum) {
		return monitorDataDao.getAllWellLastTimeMonitorData(_wellNum);
	}

	@Override
	public MonitorData getLastTimeMonitorData(String _wellNo,
			List<MonitorData> _list) {
		MonitorData md=null;
		for (MonitorData monitorData : _list) {
			if(monitorData.getWellNo().equalsIgnoreCase(_wellNo)){
				md=monitorData;
				break;
			}
		}
		return md;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MonitorData> getAllWellMonitorDataByTimeInterval(
			int _timeInterval) {
		Calendar nowDate = Calendar.getInstance();// 取得现在时间
		Date endDate = nowDate.getTime();// 转成Date
		nowDate.add(Calendar.MINUTE, -(_timeInterval));
		Date startDate = nowDate.getTime();
		return monitorDataDao.getAllWellMonitorDataByTimeInterval(startDate, endDate);
	}

	@Override
	public List<MonitorData> getAllWellMonitorDataByTimeInterval(
			String _wellNo, int _timeInterval, List<MonitorData> _list) {
		List<MonitorData> newList=Lists.newArrayList();
		for (MonitorData md : _list) {
			if(md.getWellNo().equalsIgnoreCase(_wellNo)){
				newList.add(md);
			}
		}
		return newList;
	}
	
	
}
