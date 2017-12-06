package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface OneIntegratedMachineDao extends
		BaseDao<OneIntegratedMachine, String> {

	public OneIntegratedMachine searchMonitorDataByLastTime(
			String compressorCode);

	public List<OneIntegratedMachine> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate);

	public List<OneIntegratedMachine> getAllLastOneIntegratedMachines(
			int compressorNum);

	public Page<OneIntegratedMachine> getOneIntegratedMsg(
			Page<OneIntegratedMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date);
}
