package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.apps.jointoil.service.TwoBoosterCompressorService;

public class InsertTwoBoosterCompressorThread implements Runnable {

	private List<TwoBoosterCompressor> list;
	private TwoBoosterCompressorService twoBoosterCompressorService;

	public InsertTwoBoosterCompressorThread(TwoBoosterCompressorService twoBoosterCompressorService,
			List<TwoBoosterCompressor> list) {
		super();
		this.twoBoosterCompressorService = twoBoosterCompressorService;
		this.list = list;
	}

	public InsertTwoBoosterCompressorThread() {
		super();
	}

	@Override
	public void run() {
		for (TwoBoosterCompressor twoBoosterCompressor : list) {
			twoBoosterCompressorService.save(twoBoosterCompressor);
		}
	}

	public List<TwoBoosterCompressor> getList() {
		return list;
	}

	public void setList(List<TwoBoosterCompressor> list) {
		this.list = list;
	}

	public TwoBoosterCompressorService getTwoBoosterCompressorService() {
		return twoBoosterCompressorService;
	}

	public void setTwoBoosterCompressorService(
			TwoBoosterCompressorService twoBoosterCompressorService) {
		this.twoBoosterCompressorService = twoBoosterCompressorService;
	}

	
}
