package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.apps.jointoil.service.FiveScrewMachineService;

public class InsertFiveScrewMachineThread implements Runnable {

	private List<FiveScrewMachine> list;
	private FiveScrewMachineService fiveScrewMachineService;

	public InsertFiveScrewMachineThread(FiveScrewMachineService fiveScrewMachineService,
			List<FiveScrewMachine> list) {
		super();
		this.fiveScrewMachineService = fiveScrewMachineService;
		this.list = list;
	}

	public InsertFiveScrewMachineThread() {
		super();
	}

	@Override
	public void run() {
		for (FiveScrewMachine fiveScrewMachine : list) {
			fiveScrewMachineService.save(fiveScrewMachine);
		}
	}

	public List<FiveScrewMachine> getList() {
		return list;
	}

	public void setList(List<FiveScrewMachine> list) {
		this.list = list;
	}

	public FiveScrewMachineService getFiveScrewMachineService() {
		return fiveScrewMachineService;
	}

	public void setFiveScrewMachineService(
			FiveScrewMachineService fiveScrewMachineService) {
		this.fiveScrewMachineService = fiveScrewMachineService;
	}

	
}
