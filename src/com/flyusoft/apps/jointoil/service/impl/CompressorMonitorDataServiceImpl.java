package com.flyusoft.apps.jointoil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.CompressorMonitorDataDao;
import com.flyusoft.apps.jointoil.entity.CompressorMonitorData;
import com.flyusoft.apps.jointoil.service.CompressorMonitorDataService;

@Service
public class CompressorMonitorDataServiceImpl implements CompressorMonitorDataService{

	@Autowired
	private CompressorMonitorDataDao compressorMonitorDataDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CompressorMonitorData> getAllCompressorLastMonitorDatas() {
		return compressorMonitorDataDao.getAllCompressorMonitorDatas();
	}

}
