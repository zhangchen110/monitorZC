package com.flyusoft.apps.jointoil.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.FiveBoosterCompressorDao;
import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;
import com.flyusoft.apps.jointoil.util.CompressorSaveEmpty;
import com.flyusoft.common.orm.Page;

@Service
@Transactional
public class FiveBoosterCompressorServiceImpl implements FiveBoosterCompressorService {
	@Autowired
	private FiveBoosterCompressorDao fiveBoosterCompressorDao;

	@Override
	public void save(FiveBoosterCompressor fiveBoosterCompressor) {
		fiveBoosterCompressorDao.save(fiveBoosterCompressor);
	}

	@Override
	@Transactional(readOnly = true)
	public FiveBoosterCompressor searchMonitorDataByLastTime(String compressorCode) {
		return fiveBoosterCompressorDao.searchMonitorDataByLastTime(compressorCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FiveBoosterCompressor> getDataByCompressorCodeAndTimeInterval(
			String _compressorCode, int _timeInterval) {
		Calendar nowDate = Calendar.getInstance();// 取得现在时间
		Date endDate = nowDate.getTime();// 转成Date
		nowDate.add(Calendar.MINUTE, -(_timeInterval));
		Date startDate = nowDate.getTime();
		return fiveBoosterCompressorDao.searchDataByCompressorCodeAndTimeInterval(_compressorCode,startDate, endDate);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<FiveBoosterCompressor> getDataByCompressor(String _compressorCode, Date datetime) {
		 List<FiveBoosterCompressor> fiveBoosterCompressor=new ArrayList();
		for (int i = 0; i <=23; i++) {
			Calendar cal=Calendar.getInstance();
			cal.setTime(datetime);
			cal.add(Calendar.HOUR_OF_DAY,+i);//循环取值+i
			Date datetime_end = cal.getTime();//得到当前时间想用的时间
			cal.add(Calendar.MINUTE, -1);//得到结束时间前的1分钟时间
			Date datetime_sta = cal.getTime();//得到当前时间想用的时间
			List<FiveBoosterCompressor> comList=   fiveBoosterCompressorDao.searchDataByCompressorCodeAndTimeInterval(_compressorCode,datetime_sta, datetime_end);
			if(comList.size()<=0){
				//调用一个方法
				fiveBoosterCompressor.add(new CompressorSaveEmpty().FiveBoosterCompressorPojo(_compressorCode, datetime_sta)); //如果为空 将所有的值副0
			}else{
				fiveBoosterCompressor.add(comList.get(0));
			}
		}
		return fiveBoosterCompressor;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<FiveBoosterCompressor> getFiveBoosterMsg(
			Page<FiveBoosterCompressor> pageMonitor, String compressorCode,
			Date start_date, Date end_date) {
		return fiveBoosterCompressorDao.getFiveBoosterMsg(pageMonitor, compressorCode, start_date, end_date);
	}
}
