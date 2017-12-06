package com.flyusoft.apps.jointoil.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.MonitorDataDao;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.flyusoft.common.orm.Page;

@Repository
public class MonitorDataDaoImpl extends
		BaseHibernateDaoImpl<MonitorData, String> implements MonitorDataDao {

	private final static String QUERY_MONITORDATA_BY_LAST_MONITORTIME = "from MonitorData data where data.wellNo = ? order by data.monitorTime desc";

	private final static String QUERY_MONITORDATA_BY_WELLID_AND_TIME_INTERVAL = "from MonitorData data where data.wellNo=? and (data.monitorTime between ? and ?) order by data.monitorTime";
	private final static String QUERY_MONITORDATA_BY_TIME = "from MonitorData where wellNo=?  and monitorTime between ? and ?";

	private final static String QUERY_MONITORDATA_CLASS_REPORT_TIME = "  select d.* from fly_monitor_data d  where DATE_FORMAT(d.monitor_time, '%Y-%m-%d') = ? and hour (d.monitor_time) = ? and minute(d.monitor_time) ='00'  and well_no = ?";
	
	private final static String QUERY_ALL_WELL_LASTTIME_MONITORDATA="select  m.* from fly_monitor_data m ,fly_well w where m.well_no = w.well_no group by m.well_no,m.id order by m.monitor_time desc limit ?";
	
	private final static String QUERY_ALL_WELL_MONITORDATA_AND_TIME_INTERVAL ="select i.* from fly_monitor_data i where i.monitor_time between ? and ? group by i.well_no ,i.id order by i.monitor_time ";
	@Override
	public MonitorData searchMonitorDataByLastMonitorTime(String wellNo) {
		List<MonitorData> list=createQuery(QUERY_MONITORDATA_BY_LAST_MONITORTIME,wellNo).list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	//	@SuppressWarnings("unchecked")   对unchecked异常保持沉默
	@SuppressWarnings("unchecked")
	@Override
	public List<MonitorData> searchMonitorDataByWellIdAndTimeInterval(
			String wellNo, Date startDate, Date endDate) {
		return createQuery(QUERY_MONITORDATA_BY_WELLID_AND_TIME_INTERVAL,
				wellNo, startDate, endDate).list();
	}

	@Override
	public Page<MonitorData> getMonitorDataMsg(Page<MonitorData> pageMonitor,
			String wellNo, Date start_date, Date end_date) {
		return findPage(pageMonitor, QUERY_MONITORDATA_BY_TIME, wellNo,
				start_date, end_date);
	}

	@Override
	public List<MonitorData> getMonitorDataClassReport(String wellNo,
			String reporttime, String time) {
		List<MonitorData> list = createSQLQuery(
				QUERY_MONITORDATA_CLASS_REPORT_TIME, reporttime, time, wellNo)
				.addEntity(MonitorData.class).list();
		return list;
	}

	@Override
	public List<MonitorData> getAllWellLastTimeMonitorData(int _wellNum) {
		return createSQLQuery(QUERY_ALL_WELL_LASTTIME_MONITORDATA,_wellNum).addEntity(MonitorData.class).list();
	}

	@Override
	public List<MonitorData> getAllWellMonitorDataByTimeInterval(
			Date _startDate, Date _endDate) {
		return createSQLQuery(QUERY_ALL_WELL_MONITORDATA_AND_TIME_INTERVAL, _startDate,_endDate).addEntity(MonitorData.class).list();
	}

}
