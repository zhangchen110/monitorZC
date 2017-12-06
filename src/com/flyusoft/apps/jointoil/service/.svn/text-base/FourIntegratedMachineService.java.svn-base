package com.flyusoft.apps.jointoil.service;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.common.orm.Page;

public interface FourIntegratedMachineService {

	public	void save(FourIntegratedMachine fourIntegratedMachine);
	
	public FourIntegratedMachine searchMonitorDataByLastTime(String compressorCode);

	/**
	 * 根据压缩机编码 查找最后几分种的数据
	 * @param _compressorCode  压缩机编码
	 * @param _timeInterval   分钟
	 * @return
	 */
	public List<FourIntegratedMachine> getDataByCompressorCodeAndTimeInterval(String _compressorCode,int _timeInterval);

	public List<FourIntegratedMachine> getDataByCompressor(String _compressorCode,
			Date datetime);
	
	/**
	 * 获取时间数据
	 * @param pageMonitor
	 * @param wellNo
	 * @param start_date
	 * @param end_date
	 * @return
	 */
	public Page<FourIntegratedMachine> getFourIntegratedMsg(Page<FourIntegratedMachine> pageMonitor,
			String compressorCode, Date start_date, Date end_date);
}
