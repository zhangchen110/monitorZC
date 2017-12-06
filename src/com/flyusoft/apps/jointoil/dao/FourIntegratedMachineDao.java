package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface FourIntegratedMachineDao extends
		BaseDao<FourIntegratedMachine, String> {

	public FourIntegratedMachine searchMonitorDataByLastTime(
			String compressorCode);

	public List<FourIntegratedMachine> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate);

	/**
	 * 取出该对象所有压缩机最后一条记录
	 * 
	 * @param _compressorNum
	 *            压缩机数量
	 */
	public List<FourIntegratedMachine> getAllLastFourIntegratedMachines(
			int _compressorNum);

	public Page<FourIntegratedMachine> getFourIntegratedMsg(
			Page<FourIntegratedMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date);
}
