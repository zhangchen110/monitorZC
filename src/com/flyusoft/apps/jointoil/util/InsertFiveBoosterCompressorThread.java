package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.service.FiveBoosterCompressorService;

public class InsertFiveBoosterCompressorThread implements Runnable {

	private List<FiveBoosterCompressor> list;
	private FiveBoosterCompressorService fiveBoosterCompressorService;

	public InsertFiveBoosterCompressorThread(FiveBoosterCompressorService fiveBoosterCompressorService,
			List<FiveBoosterCompressor> list) {
		super();
		this.fiveBoosterCompressorService = fiveBoosterCompressorService;
		this.list = list;
	}

	public InsertFiveBoosterCompressorThread() {
		super();
	}

	@Override
	public void run() {
		for (FiveBoosterCompressor fiveBoosterCompressor : list) {
			fiveBoosterCompressorService.save(fiveBoosterCompressor);
		}
	}

	public List<FiveBoosterCompressor> getList() {
		return list;
	}

	public void setList(List<FiveBoosterCompressor> list) {
		this.list = list;
	}

	public FiveBoosterCompressorService getFiveBoosterCompressorService() {
		return fiveBoosterCompressorService;
	}

	public void setFiveBoosterCompressorService(
			FiveBoosterCompressorService fiveBoosterCompressorService) {
		this.fiveBoosterCompressorService = fiveBoosterCompressorService;
	}

	
}
