package com.flyusoft.apps.jointoil.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.apps.jointoil.service.WellService;

public class QuartzJobWell {
	public TimerTools timertools = new TimerTools();
	@Autowired
	private MonitorDataService monitorDataService;
	@Autowired
	private WellService wellService;
	
	public void monitorDataSave() {
		// 查询已经存在的井id
		// 想历史数据表中添加数据，每个井都要添加
		List<Well> listwell = wellService.getAllWell();
		for (int i = 0; i < listwell.size(); i++) {
			Well well = (Well) listwell.get(i);//取出实体
			String wellno = "";// 将要插入的井号
			wellno = well.getWellNo();
			if (!(wellno.equals("") || wellno == "")) {// 如果no不存在,则不插入.
				monitorDataService.saveMonitorData(timertools.monitorDataPojo(wellno));
			}
		}// for循环读取井号结束
		
	}
 
}
