package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface ThreeScrewMachineDao extends
		BaseDao<ThreeScrewMachine, String> {

	public ThreeScrewMachine searchMonitorDataByLastTime(String compressorCode);

	public List<ThreeScrewMachine> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate);

	/**
	 * 取出该对象所有压缩机最后一条记录
	 * 
	 * @param _compressorNum
	 *            压缩机数量
	 */
	public List<ThreeScrewMachine> getAllLastThreeScrewMachines(
			int _compressorNum);

	public Page<ThreeScrewMachine> getThreeScrewMsg(
			Page<ThreeScrewMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date);
}
