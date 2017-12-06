package com.flyusoft.apps.jointoil.service;

import java.math.BigInteger;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.CompressorData;

public interface CompressorDataService {

	public void insert(CompressorData compressorData);
	//得到插入的最后一批集合
	public List<CompressorData> getMaxRound();
	//得到插入的最大数
	public BigInteger getMaxRoundInteger();
	
	/**
	 * 通过轮次获取数据集合
	 * @param _round
	 * @return
	 */
	public List<CompressorData> getCompressorDataByRound(int _round);

}
