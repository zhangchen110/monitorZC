package com.flyusoft.apps.jointoil.dao;

import java.math.BigInteger;
import java.util.List;

import com.flyusoft.apps.jointoil.entity.CompressorData;
import com.flyusoft.common.dao.BaseDao;


public interface CompressorDataDao  extends BaseDao<CompressorData, String> {

	public void insert(CompressorData compressorData);

	public List<CompressorData> getMaxRound();

	public BigInteger getMaxRoundInteger();
	
	/**
	 * 通过轮次查找数据集合
	 * @param _round
	 * @return
	 */
	public List<CompressorData> getCompressorDataByRound(int _round);
	
	
}
