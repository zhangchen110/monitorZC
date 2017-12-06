package com.flyusoft.apps.jointoil.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.TwoScrewMachineDao;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;
import com.flyusoft.apps.jointoil.util.CompressorSaveEmpty;
import com.flyusoft.common.orm.Page;

@Service
@Transactional
public class TwoScrewMachineServiceImpl implements TwoScrewMachineService {
	@Autowired
	private TwoScrewMachineDao twoScrewMachineDao;

	@Override
	public void save(TwoScrewMachine twoScrewMachine) {
		twoScrewMachineDao.save(twoScrewMachine);
	}

	@Override
	@Transactional(readOnly = true)
	public TwoScrewMachine searchMonitorDataByLastTime(String compressorCode) {
		return twoScrewMachineDao.searchMonitorDataByLastTime(compressorCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TwoScrewMachine> getDataByCompressorCodeAndTimeInterval(
			String _compressorCode, int _timeInterval) {
		Calendar nowDate = Calendar.getInstance();// 取得现在时间
		Date endDate = nowDate.getTime();// 转成Date
		nowDate.add(Calendar.MINUTE, -(_timeInterval));
		Date startDate = nowDate.getTime();
		return twoScrewMachineDao.searchDataByCompressorCodeAndTimeInterval(_compressorCode,startDate, endDate);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<TwoScrewMachine> getDataByCompressor(String _compressorCode, Date datetime) {
		 List<TwoScrewMachine> twoScrewMachine=new ArrayList();
		for (int i = 0; i <=23; i++) {
			Calendar cal=Calendar.getInstance();
			cal.setTime(datetime);
			cal.add(Calendar.HOUR_OF_DAY,+i);//循环取值+i
			Date datetime_end = cal.getTime();//得到当前时间想用的时间
			cal.add(Calendar.MINUTE, -1);//得到结束时间前的1分钟时间
			Date datetime_sta = cal.getTime();//得到当前时间想用的时间
			List<TwoScrewMachine> comList=  twoScrewMachineDao.searchDataByCompressorCodeAndTimeInterval(_compressorCode,datetime_sta, datetime_end);
			if(comList.size()<=0){
				//调用一个方法
				twoScrewMachine.add(new CompressorSaveEmpty().TwoScrewMachinePojo(_compressorCode, datetime_sta)); //如果为空 将所有的值副0
			}else{
				twoScrewMachine.add(comList.get(0));
			}
		}
		return twoScrewMachine;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TwoScrewMachine> getTwoScrewMsg(
			Page<TwoScrewMachine> pageMonitor, String compressorCode,
			Date start_date, Date end_date) {
		return twoScrewMachineDao.getTwoScrewMsg(pageMonitor, compressorCode, start_date, end_date);
	}
}
