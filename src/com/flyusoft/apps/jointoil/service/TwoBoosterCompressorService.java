package com.flyusoft.apps.jointoil.service;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.common.orm.Page;

public interface TwoBoosterCompressorService {

	public void save(TwoBoosterCompressor twoBoosterCompressor);

	public TwoBoosterCompressor searchMonitorDataByLastTime(String compressorCode);
	
	/**
	 * 根据压缩机编码 查找最后几分种的数据
	 * @param _compressorCode  压缩机编码
	 * @param _timeInterval   分钟
	 * @return
	 */
	public List<TwoBoosterCompressor> getDataByCompressorCodeAndTimeInterval(String _compressorCode,int _timeInterval);
	
	public List<TwoBoosterCompressor> getDataByCompressor(String _compressorCode, Date datetime);
	
	/**
	 * 获取时间数据
	 * @param pageMonitor
	 * @param wellNo
	 * @param start_date
	 * @param end_date
	 * @return
	 */
	public Page<TwoBoosterCompressor> getTwoBoosterMsg(Page<TwoBoosterCompressor> pageMonitor,
			String compressorCode, Date start_date, Date end_date);
}
