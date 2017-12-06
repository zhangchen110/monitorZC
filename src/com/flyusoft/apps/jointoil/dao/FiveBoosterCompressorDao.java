package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface FiveBoosterCompressorDao extends
		BaseDao<FiveBoosterCompressor, String> {

	public FiveBoosterCompressor searchMonitorDataByLastTime(
			String compressorCode);

	public List<FiveBoosterCompressor> searchDataByCompressorCodeAndTimeInterval(
			String _compressorCode, Date _startDate, Date _endDate);

	/**
	 * 取出该对象所有压缩机最后一条记录
	 * 
	 * @param _compressorNum
	 *            压缩机数量
	 */
	public List<FiveBoosterCompressor> getAllLastFiveBoosterCompressors(
			int _compressorNum);

	public Page<FiveBoosterCompressor> getFiveBoosterMsg(
			Page<FiveBoosterCompressor> pageMonitor, String compressorCode,
			Date start_date, Date end_date);
}
