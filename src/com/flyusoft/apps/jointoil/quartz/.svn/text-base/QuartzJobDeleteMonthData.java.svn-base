package com.flyusoft.apps.jointoil.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyusoft.apps.jointoil.service.DeleteMsgByMonthService;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

/**
 * 定时删除数据库数据
 * @author Yanglongquan
 *
 */
public class QuartzJobDeleteMonthData {
	@Autowired
	private DeleteMsgByMonthService deleteMsgByMonthService;
	public void deleteData(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date dDate=cal.getTime();
		deleteMsgByMonthService.deleteAllMsg(dDate);
	}
}
