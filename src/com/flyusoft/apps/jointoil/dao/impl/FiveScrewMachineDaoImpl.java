package com.flyusoft.apps.jointoil.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.FiveScrewMachineDao;
import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.flyusoft.common.orm.Page;

@Repository
public class FiveScrewMachineDaoImpl extends BaseHibernateDaoImpl<FiveScrewMachine, String> implements
		FiveScrewMachineDao {

	private final static String QUERY_MONITORDATA_BY_LAST_MONITORTIME = "from FiveScrewMachine data where data.compressorCode = ? order by data.time desc";

	private final static String QUERY_DATA_BY_WELLID_AND_TIME_INTERVAL = "from FiveScrewMachine data where data.compressorCode=? and (data.time between ? and ?) order by data.time";
	
	private final static String QUERY_ALL_LAST_DATA="select com.* from fly_five_screw_machine com group by com.id,com.compressor_code order by com.time desc,com.compressor_code asc limit ?";
	
	private final static String QUERY_DATA_BY_TIME = "from FiveScrewMachine where compressorCode=?  and time between ? and ? order by time desc";

	
	@Override
	public FiveScrewMachine searchMonitorDataByLastTime(String compressorCode) {
		List<FiveScrewMachine> list=createQuery(QUERY_MONITORDATA_BY_LAST_MONITORTIME, compressorCode).list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FiveScrewMachine> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate) {
		return createQuery(QUERY_DATA_BY_WELLID_AND_TIME_INTERVAL,
				_compressorCode, _startDate, _endDate).list();
	}
	@Override
	public List<FiveScrewMachine> getAllLastFiveScrewMachines(int _compressorNum) {
		return  createQuery(QUERY_ALL_LAST_DATA, _compressorNum).list();
	}
	@Override
	public Page<FiveScrewMachine> getFiveScrewMsg(
			Page<FiveScrewMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date) {
		return findPage(pageMonitor, QUERY_DATA_BY_TIME, compressorCode,start_date,end_date);
	}
}
