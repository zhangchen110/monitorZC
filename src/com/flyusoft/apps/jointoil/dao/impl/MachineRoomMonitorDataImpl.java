package com.flyusoft.apps.jointoil.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.MachineRoomMonitorDataDao;
import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.flyusoft.common.orm.Page;

@Repository
public class MachineRoomMonitorDataImpl extends BaseHibernateDaoImpl<MachineRoomMonitorData, String> implements MachineRoomMonitorDataDao{

	
	private final static String QUERY_ALL_MACHINEROOM_LASTTIME_MONITORDATA="select  m.* from fly_machine_room_monitor_data m ,fly_machine_room w where m.room_no = w.room_no group by m.room_no,m.id order by m.time desc limit ?";
	
	private final static String QUERY_MACHINEROOMMONITORDATA_BY_LAST_TIME = "from MachineRoomMonitorData data where data.roomNo = ? order by data.time desc";
	
	private final static String QUERY_MACHINEROOMMONITORDATA_BY_TIME = "from MachineRoomMonitorData where roomNo=?  and time between ? and ?";
	
	@Override
	public List<MachineRoomMonitorData> getMachineRoomMonitorDatasByNum(int _num) {
		return createSQLQuery(QUERY_ALL_MACHINEROOM_LASTTIME_MONITORDATA, _num).addEntity(MachineRoomMonitorData.class).list();
	}


	@Override
	public MachineRoomMonitorData getLastTimeDataByRoomNo(String _roomNo) {
		List<MachineRoomMonitorData> list=createQuery(QUERY_MACHINEROOMMONITORDATA_BY_LAST_TIME,_roomNo).list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public Page<MachineRoomMonitorData> getMachineRoomMonitorDataMsg(
			Page<MachineRoomMonitorData> pageMonitor, String _roomNo,
			Date _startDate, Date _endDate) {
		return findPage(pageMonitor,QUERY_MACHINEROOMMONITORDATA_BY_TIME, _roomNo,_startDate,_endDate);
	}

}
