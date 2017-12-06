package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface TwoBoosterCompressorDao extends
		BaseDao<TwoBoosterCompressor, String> {

	public TwoBoosterCompressor searchMonitorDataByLastTime(
			String compressorCode);

	public List<TwoBoosterCompressor> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate);

	public List<TwoBoosterCompressor> getAllLastTwoBoosterCompressors(
			int _compressorNum);

	public Page<TwoBoosterCompressor> getTwoBoosterMsg(
			Page<TwoBoosterCompressor> pageMonitor, String compressorCode,
			Date start_date, Date end_date);
}
