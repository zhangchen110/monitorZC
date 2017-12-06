package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.apps.jointoil.service.OneIntegratedMachineService;

public class InsertOneIntegratedMachineThread implements Runnable {

	private List<OneIntegratedMachine> list;
	private OneIntegratedMachineService oneIntegratedMachineService;

	public InsertOneIntegratedMachineThread(OneIntegratedMachineService oneIntegratedMachineService,
			List<OneIntegratedMachine> list) {
		super();
		this.oneIntegratedMachineService = oneIntegratedMachineService;
		this.list = list;
	}

	public InsertOneIntegratedMachineThread() {
		super();
	}

	@Override
	public void run() {
		for (OneIntegratedMachine oneIntegratedMachine : list) {
			oneIntegratedMachineService.save(oneIntegratedMachine);
		}
	}

	public List<OneIntegratedMachine> getList() {
		return list;
	}

	public void setList(List<OneIntegratedMachine> list) {
		this.list = list;
	}

	public OneIntegratedMachineService getAlarmLogService() {
		return oneIntegratedMachineService;
	}

	public void setAlarmLogService(OneIntegratedMachineService oneIntegratedMachineService) {
		this.oneIntegratedMachineService = oneIntegratedMachineService;
	}

}
