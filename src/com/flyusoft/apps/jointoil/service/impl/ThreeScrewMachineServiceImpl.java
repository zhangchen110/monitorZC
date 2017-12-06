package com.flyusoft.apps.jointoil.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.ThreeScrewMachineDao;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;
import com.flyusoft.apps.jointoil.util.CompressorSaveEmpty;
import com.flyusoft.common.orm.Page;
@Service
@Transactional
public class ThreeScrewMachineServiceImpl implements ThreeScrewMachineService{
	@Autowired
	private ThreeScrewMachineDao threeScrewMachineDao;

	@Override
	public void save(ThreeScrewMachine threeScrewMachine) {
		threeScrewMachineDao.save(threeScrewMachine);		
	}

	@Override
	@Transactional(readOnly = true)
	public ThreeScrewMachine searchMonitorDataByLastTime(String compressorCode) {
		return threeScrewMachineDao.searchMonitorDataByLastTime(compressorCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThreeScrewMachine> getDataByCompressorCodeAndTimeInterval(
			String _compressorCode, int _timeInterval) {
		Calendar nowDate = Calendar.getInstance();// 取得现在时间
		Date endDate = nowDate.getTime();// 转成Date
		nowDate.add(Calendar.MINUTE, -(_timeInterval));
		Date startDate = nowDate.getTime();
		return threeScrewMachineDao.searchDataByCompressorCodeAndTimeInterval(_compressorCode,startDate, endDate);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ThreeScrewMachine> getDataByCompressor(String _compressorCode, Date datetime) {
		 List<ThreeScrewMachine> threeScrewMachine=new ArrayList();
		for (int i = 0; i <=23; i++) {
			Calendar cal=Calendar.getInstance();
			cal.setTime(datetime);
			cal.add(Calendar.HOUR_OF_DAY,+i);//循环取值+i
			Date datetime_end = cal.getTime();//得到当前时间想用的时间
			cal.add(Calendar.MINUTE, -1);//得到结束时间前的1分钟时间
			Date datetime_sta = cal.getTime();//得到当前时间想用的时间
			List<ThreeScrewMachine> comList=  threeScrewMachineDao.searchDataByCompressorCodeAndTimeInterval(_compressorCode,datetime_sta, datetime_end);
			if(comList.size()<=0){
				//调用一个方法
				threeScrewMachine.add(new CompressorSaveEmpty().ThreeScrewMachinePojo(_compressorCode, datetime_sta)); //如果为空 将所有的值副0
			}else{
				threeScrewMachine.add(comList.get(0));
			}
		}
		return threeScrewMachine;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ThreeScrewMachine> getThreeScrewMsg(
			Page<ThreeScrewMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date) {
		return threeScrewMachineDao.getThreeScrewMsg(pageMonitor, compressorCode, start_date, end_date);
	}
}
