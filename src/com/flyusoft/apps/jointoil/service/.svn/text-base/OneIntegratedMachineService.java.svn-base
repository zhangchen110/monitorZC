package com.flyusoft.apps.jointoil.service;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.common.orm.Page;

public interface OneIntegratedMachineService {

	public void save(OneIntegratedMachine oneIntegratedMachine);

	public OneIntegratedMachine searchMonitorDataByLastTime(String compressorCode);
	
	/**
	 * 根据压缩机编码 查找最后几分种的数据
	 * @param _compressorCode  压缩机编码
	 * @param _timeInterval   分钟
	 * @return
	 */
	public List<OneIntegratedMachine> getDataByCompressorCodeAndTimeInterval(String _compressorCode,int _timeInterval);
	
	/**
	 * 根据压缩机编码  查找当天时间从8：00 - 7：00
	 * @param _compressorCode  压缩机编码
	 * @param datetime  天数
	 * @return
	 */
	public List<OneIntegratedMachine> getDataByCompressor(String _compressorCode,Date datetime);
	
	/**
	 * 获取时间数据
	 * @param pageMonitor
	 * @param wellNo
	 * @param start_date
	 * @param end_date
	 * @return
	 */
	public Page<OneIntegratedMachine> getOneIntegratedMsg(Page<OneIntegratedMachine> pageMonitor,
			String compressorCode, Date start_date, Date end_date);
}
