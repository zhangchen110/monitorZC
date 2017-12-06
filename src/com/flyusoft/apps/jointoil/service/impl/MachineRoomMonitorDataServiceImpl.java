package com.flyusoft.apps.jointoil.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.MachineRoomMonitorDataDao;
import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.service.MachineRoomMonitorDataService;
import com.flyusoft.common.orm.Page;

@Service
@Transactional
public class MachineRoomMonitorDataServiceImpl implements MachineRoomMonitorDataService{

	@Autowired
	private MachineRoomMonitorDataDao dao;
	@Override
	public void save(MachineRoomMonitorData _monitorData) {
		if(_monitorData!=null){
			dao.save(_monitorData);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public List<MachineRoomMonitorData> getMachineRoomMonitorDatasByNum(int _num) {
		return dao.getMachineRoomMonitorDatasByNum(_num);
	}
	@Override
	@Transactional(readOnly=true)
	public MachineRoomMonitorData getDataByRoomNo(String _roomNo,
			List<MachineRoomMonitorData> _mrmdList) {
		if(_mrmdList!=null){
			for (MachineRoomMonitorData machineRoomMonitorData : _mrmdList) {
				if(machineRoomMonitorData.getRoomNo().equals(_roomNo)){
					return machineRoomMonitorData;
				}
			}
		}
		return null;
	}
	@Override
	@Transactional(readOnly=true)
	public MachineRoomMonitorData getLastTimeDataByRoomNO(String _roomNo) {
		return dao.getLastTimeDataByRoomNo(_roomNo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<MachineRoomMonitorData> getMachineRoomMonitorDataMsg(Page<MachineRoomMonitorData> pageMonitor,
			String _roomNo, Date _startDate, Date _endDate) {
		return dao.getMachineRoomMonitorDataMsg(pageMonitor, _roomNo,
				_startDate, _endDate);
	}
}
