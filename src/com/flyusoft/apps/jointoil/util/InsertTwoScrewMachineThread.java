package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;
import com.flyusoft.apps.jointoil.service.TwoScrewMachineService;

public class InsertTwoScrewMachineThread   implements Runnable {
	private List<TwoScrewMachine> list;
	private TwoScrewMachineService twoScrewMachineService;
	
	public InsertTwoScrewMachineThread(TwoScrewMachineService twoScrewMachineService,
			List<TwoScrewMachine> list) {
		super();
		this.twoScrewMachineService = twoScrewMachineService;
		this.list = list;
	}
	public InsertTwoScrewMachineThread() {
		super();
	}
	@Override
	public void run() {
		for (TwoScrewMachine twoScrewMachine : list) {
			twoScrewMachineService.save(twoScrewMachine);
		}
	}
	public List<TwoScrewMachine> getList() {
		return list;
	}
	public void setList(List<TwoScrewMachine> list) {
		this.list = list;
	}
	public TwoScrewMachineService getTwoScrewMachineService() {
		return twoScrewMachineService;
	}
	public void setTwoScrewMachineService(
			TwoScrewMachineService twoScrewMachineService) {
		this.twoScrewMachineService = twoScrewMachineService;
	}
	
	
 
}
