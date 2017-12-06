package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.MachineRoomMonitorData;
import com.flyusoft.apps.jointoil.service.MachineRoomMonitorDataService;

public class InsertMachineRoomMonitorDataThread implements Runnable {

	private List<MachineRoomMonitorData> list;
	private MachineRoomMonitorDataService machineRoomMonitorDataService;

	public InsertMachineRoomMonitorDataThread(MachineRoomMonitorDataService machineRoomMonitorDataService,
			List<MachineRoomMonitorData> list) {
		super();
		this.machineRoomMonitorDataService = machineRoomMonitorDataService;
		this.list = list;
	}

	public InsertMachineRoomMonitorDataThread() {
		super();
	}

	@Override
	public void run() {
		for (MachineRoomMonitorData machineRoomMonitorData : list) {
			machineRoomMonitorDataService.save(machineRoomMonitorData);
		}
	}

	public List<MachineRoomMonitorData> getList() {
		return list;
	}

	public void setList(List<MachineRoomMonitorData> list) {
		this.list = list;
	}

	public MachineRoomMonitorDataService getMachineRoomMonitorDataService() {
		return machineRoomMonitorDataService;
	}

	public void setMachineRoomMonitorDataService(
			MachineRoomMonitorDataService machineRoomMonitorDataService) {
		this.machineRoomMonitorDataService = machineRoomMonitorDataService;
	}

	

}
