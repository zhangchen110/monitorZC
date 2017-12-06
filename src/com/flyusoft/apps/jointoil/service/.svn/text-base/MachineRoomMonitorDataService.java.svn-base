package com.flyusoft.apps.jointoil.service;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.common.orm.Page;

public interface MachineRoomMonitorDataService {
	/**
	 * 存机房数据记录
	 * @param _monitorData
	 */
	public void save(MachineRoomMonitorData _monitorData);
	/**
	 * 查找最近_num个记录  按时间排序的
	 * @param _num
	 * @return
	 */
	public List<MachineRoomMonitorData> getMachineRoomMonitorDatasByNum(int _num);
	
	public MachineRoomMonitorData getDataByRoomNo(String _roomNo,List<MachineRoomMonitorData> _mrmdList);
	/**
	 * 取时间上最后一条数据
	 * @param _roomNo
	 * @return
	 */
	public MachineRoomMonitorData getLastTimeDataByRoomNO(String _roomNo);
	
	public Page<MachineRoomMonitorData> getMachineRoomMonitorDataMsg(Page<MachineRoomMonitorData> pageMonitor,
			String _roomNo, Date _startDate, Date _endDate);
}
