package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.service.ThreeScrewMachineService;

public class InsertThreeScrewMachineThread implements Runnable {

	private List<ThreeScrewMachine> list;
	private ThreeScrewMachineService threeScrewMachineService;

	public InsertThreeScrewMachineThread(ThreeScrewMachineService threeScrewMachineService,
			List<ThreeScrewMachine> list) {
		super();
		this.threeScrewMachineService = threeScrewMachineService;
		this.list = list;
	}

	public InsertThreeScrewMachineThread() {
		super();
	}

	@Override
	public void run() {
		for (ThreeScrewMachine threeScrewMachine : list) {
			threeScrewMachineService.save(threeScrewMachine);
		}
	}

	public List<ThreeScrewMachine> getList() {
		return list;
	}

	public void setList(List<ThreeScrewMachine> list) {
		this.list = list;
	}

	public ThreeScrewMachineService getThreeScrewMachineService() {
		return threeScrewMachineService;
	}

	public void setThreeScrewMachineService(
			ThreeScrewMachineService threeScrewMachineService) {
		this.threeScrewMachineService = threeScrewMachineService;
	}

	
}
