package com.flyusoft.apps.jointoil.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flyusoft.apps.jointoil.entity.CompressorMD;
import com.flyusoft.apps.jointoil.entity.CompressorMonitorData;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.FiveScrewMachineService;
import com.flyusoft.apps.jointoil.service.FourIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.OneIntegratedMachineService;
import com.flyusoft.apps.jointoil.service.ThreeBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;
import com.flyusoft.apps.jointoil.service.TwoBoosterCompressorService;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;
import com.google.common.collect.Lists;
/**
 * 获取压缩机工具类
 * @author Yanglongquan
 *
 */

@Component
public class GainCompressorData {
	
	@Autowired
	private OneIntegratedMachineService oneIntegratedMachineService;
	@Autowired
	private TwoBoosterCompressorService twoBoosterCompressorService;
	@Autowired
	private TwoScrewMachineService twoScrewMachineService;
	@Autowired
	private ThreeBoosterCompressorService threeBoosterCompressorService;
	@Autowired
	private ThreeScrewMachineService threeScrewMachineService;
	@Autowired
	private FourIntegratedMachineService fourIntegratedMachineService;
	@Autowired
	private FiveBoosterCompressorService fiveBoosterCompressorService;
	@Autowired
	private FiveScrewMachineService fiveScrewMachineService;
	
	
	
	/**
	 * 取出所有压缩机最后一条数据
	 * @return
	 */
	public List<? extends CompressorMD> getAllLastCompressorList(){
		List<? extends CompressorMD> list=Lists.newArrayList();
		return list;
	}
	/**
	 * 从集合中取压缩机最后一个对象
	 * @param _compressorCode
	 * @param _dataList
	 * @return
	 */
	public CompressorMonitorData getCompressorMonitorDataByCompressorCode(String _compressorCode,List<CompressorMonitorData> _dataList){
		for (CompressorMonitorData compressorMonitorData : _dataList) {
			if(compressorMonitorData.getCompressorCode()!=null){
				if(compressorMonitorData.getCompressorCode().equals(_compressorCode)){
					return compressorMonitorData;
				}
			}
		}
		return null;
		
	}
	
	
	/**
	 * 获取最后一个对象
	 * @param compressorCode
	 * @return
	 */
	public  CompressorMD getCompressorMD(String compressorCode) {
		CompressorMD md = null;
		if (compressorCode.startsWith("J1-Y")) {
			md = oneIntegratedMachineService.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J2-L")) {
			md = twoScrewMachineService.searchMonitorDataByLastTime(compressorCode);
		} else if (compressorCode.startsWith("J2-Y")) {
			md = twoBoosterCompressorService.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J3-L")) {
			md = threeScrewMachineService.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J3-Y")) {
			md = threeBoosterCompressorService.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J4-Y")) {
			md = fourIntegratedMachineService.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J5-L")) {
			md = fiveScrewMachineService.searchMonitorDataByLastTime(compressorCode);

		} else if (compressorCode.startsWith("J5-Y")) {
			md = fiveBoosterCompressorService.searchMonitorDataByLastTime(compressorCode);
		}
		return md;
	}
	public List<? extends CompressorMD> getCompressorMDList(String _compressorCode, int _timeInterval) {
		List<? extends CompressorMD> compressorMDList = null;
		if (_compressorCode.startsWith("J1-Y")) {
			compressorMDList = oneIntegratedMachineService.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);
		} else if (_compressorCode.startsWith("J2-L")) {
			compressorMDList = twoScrewMachineService.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);
		} else if (_compressorCode.startsWith("J2-Y")) {
			compressorMDList = twoBoosterCompressorService
			.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);

		} else if (_compressorCode.startsWith("J3-L")) {
			compressorMDList = threeScrewMachineService
			.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);

		} else if (_compressorCode.startsWith("J3-Y")) {
			compressorMDList = threeBoosterCompressorService
			.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);

		} else if (_compressorCode.startsWith("J4-Y")) {
			compressorMDList = fourIntegratedMachineService
			.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);

		} else if (_compressorCode.startsWith("J5-L")) {
			compressorMDList = fiveScrewMachineService
			.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);

		} else if (_compressorCode.startsWith("J5-Y")) {
			compressorMDList = fiveBoosterCompressorService
			.getDataByCompressorCodeAndTimeInterval(_compressorCode,_timeInterval);
		}
		return compressorMDList;
	}
}
