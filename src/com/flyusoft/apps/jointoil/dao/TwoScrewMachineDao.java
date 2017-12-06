package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface TwoScrewMachineDao extends BaseDao<TwoScrewMachine, String> {

	public TwoScrewMachine searchMonitorDataByLastTime(String compressorCode);

	public List<TwoScrewMachine> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate);

	/**
	 * 取出该对象所有压缩机最后一条记录
	 * 
	 * @param _compressorNum
	 *            压缩机数量
	 */
	public List<TwoScrewMachine> getAllLastTwoScrewMachines(int _compressorNum);

	public Page<TwoScrewMachine> getTwoScrewMsg(
			Page<TwoScrewMachine> pageMonitor, String compressorCode, Date start_date,
			Date end_date);
}
