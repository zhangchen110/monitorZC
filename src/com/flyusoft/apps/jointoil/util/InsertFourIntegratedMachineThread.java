package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.service.FourIntegratedMachineService;

public class InsertFourIntegratedMachineThread implements Runnable {

	private List<FourIntegratedMachine> list;
	private FourIntegratedMachineService fourIntegratedMachineService;

	public InsertFourIntegratedMachineThread(FourIntegratedMachineService fourIntegratedMachineService,
			List<FourIntegratedMachine> list) {
		super();
		this.fourIntegratedMachineService = fourIntegratedMachineService;
		this.list = list;
	}

	public InsertFourIntegratedMachineThread() {
		super();
	}

	@Override
	public void run() {
		for (FourIntegratedMachine fourIntegratedMachine : list) {
			fourIntegratedMachineService.save(fourIntegratedMachine);
		}
	}

	public List<FourIntegratedMachine> getList() {
		return list;
	}

	public void setList(List<FourIntegratedMachine> list) {
		this.list = list;
	}

	public FourIntegratedMachineService getFourIntegratedMachineService() {
		return fourIntegratedMachineService;
	}

	public void setFourIntegratedMachineService(
			FourIntegratedMachineService fourIntegratedMachineService) {
		this.fourIntegratedMachineService = fourIntegratedMachineService;
	}

	
}
