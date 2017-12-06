package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.ThreeBoosterCompressor;
import com.flyusoft.apps.jointoil.service.ThreeBoosterCompressorService;

public class InsertThreeBoosterCompressorThread implements Runnable {

	private List<ThreeBoosterCompressor> list;
	private ThreeBoosterCompressorService threeBoosterCompressorService;

	public InsertThreeBoosterCompressorThread(ThreeBoosterCompressorService threeBoosterCompressorService,
			List<ThreeBoosterCompressor> list) {
		super();
		this.threeBoosterCompressorService = threeBoosterCompressorService;
		this.list = list;
	}

	public InsertThreeBoosterCompressorThread() {
		super();
	}

	@Override
	public void run() {
		for (ThreeBoosterCompressor threeBoosterCompressor : list) {
			threeBoosterCompressorService.save(threeBoosterCompressor);
		}
	}

	public List<ThreeBoosterCompressor> getList() {
		return list;
	}

	public void setList(List<ThreeBoosterCompressor> list) {
		this.list = list;
	}

	public ThreeBoosterCompressorService getThreeBoosterCompressorService() {
		return threeBoosterCompressorService;
	}

	public void setThreeBoosterCompressorService(
			ThreeBoosterCompressorService threeBoosterCompressorService) {
		this.threeBoosterCompressorService = threeBoosterCompressorService;
	}

	
}
