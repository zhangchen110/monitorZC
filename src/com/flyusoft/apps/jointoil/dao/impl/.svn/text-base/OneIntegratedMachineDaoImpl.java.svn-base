package com.flyusoft.apps.jointoil.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.OneIntegratedMachineDao;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.flyusoft.common.orm.Page;

@Repository
public class OneIntegratedMachineDaoImpl extends BaseHibernateDaoImpl<OneIntegratedMachine, String> implements
		OneIntegratedMachineDao {

	private final static String QUERY_MONITORDATA_BY_LAST_MONITORTIME = "from OneIntegratedMachine data where data.compressorCode= ? order by data.time desc";

	private final static String QUERY_DATA_BY_WELLID_AND_TIME_INTERVAL = "from OneIntegratedMachine data where data.compressorCode=? and (data.time between ? and ?) order by data.time";
	
	private final static String QUERY_ALL_LAST_DATA="select com.* from fly_one_integrated_machine com group by com.id,com.compressor_code order by com.time desc,com.compressor_code asc limit ?";
	
	private final static String QUERY_DATA_BY_TIME = "from OneIntegratedMachine where compressorCode=?  and time between ? and ? order by time desc";

	
	@Override
	public OneIntegratedMachine searchMonitorDataByLastTime(String compressorCode) {
		List<OneIntegratedMachine> oneList=createQuery(QUERY_MONITORDATA_BY_LAST_MONITORTIME, compressorCode).list();
		if(oneList!=null&&oneList.size()>0){
			return oneList.get(0);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OneIntegratedMachine> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate) {
		return createQuery(QUERY_DATA_BY_WELLID_AND_TIME_INTERVAL,
				_compressorCode, _startDate, _endDate).list();
	}
	@Override
	public List<OneIntegratedMachine> getAllLastOneIntegratedMachines(int _compressorNum) {
		
		return createQuery(QUERY_ALL_LAST_DATA, _compressorNum).list();
	}
	@Override
	public Page<OneIntegratedMachine> getOneIntegratedMsg(
			Page<OneIntegratedMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date) {
		return findPage(pageMonitor, QUERY_DATA_BY_TIME, compressorCode,start_date,end_date);
	}

}
