package com.flyusoft.apps.jointoil.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.CompressorDataDao;
import com.flyusoft.apps.jointoil.entity.CompressorData;
import com.flyusoft.apps.jointoil.service.CompressorDataService;

@Service
@Transactional
public class CompressorDataServiceImpl  implements CompressorDataService{
	@Autowired
	private CompressorDataDao  compressorDataDao ;

	@Override
	public void insert(CompressorData compressorData) {
		compressorDataDao.insert(compressorData);
	}

	@Override
	public List<CompressorData> getMaxRound() {
		return compressorDataDao.getMaxRound();
	}

	@Override
	public BigInteger getMaxRoundInteger() {
		return compressorDataDao.getMaxRoundInteger();
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompressorData> getCompressorDataByRound(int _round) {
		return compressorDataDao.getCompressorDataByRound(_round);
	}

 
}
