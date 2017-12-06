package com.flyusoft.apps.jointoil.dao;

import java.util.Date;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.common.dao.BaseDao;
import com.flyusoft.common.orm.Page;

public interface MachineRoomMonitorDataDao extends BaseDao<MachineRoomMonitorData, String>{
	
	public List<MachineRoomMonitorData> getMachineRoomMonitorDatasByNum(int _num);
	
	/**
	 * 取时间最后一条记录
	 * @param _roomNo
	 * @return
	 */
	public MachineRoomMonitorData getLastTimeDataByRoomNo(String _roomNo);
	
	public Page<MachineRoomMonitorData> getMachineRoomMonitorDataMsg(Page<MachineRoomMonitorData> pageMonitor,
			String _roomNo, Date _startDate, Date _endDate);

}
