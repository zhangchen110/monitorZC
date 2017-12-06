package com.flyusoft.apps.jointoil.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.CompressorDataDao;
import com.flyusoft.apps.jointoil.entity.CompressorData;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;

@Repository
public class CompressorDataDaoImpl extends
		BaseHibernateDaoImpl<CompressorData, String> implements
		CompressorDataDao {
	private String GET_MAX_ROUND_INTEGER = "select MAX(round)   from fly_compressor_data";

	private String GET_MAX_ROUND = "select com1.* from fly_compressor_data com1 where com1.round =(select MAX(round) from fly_compressor_data)";

	private final static String GET_COMPRESSORDATA_BY_ROUND = "from CompressorData cd where cd.round=?";

	@Override
	public void insert(CompressorData compressorData) {
		save(compressorData);
	}

	// 返回round最大值
	@Override
	public List<CompressorData> getMaxRound() {
		return createSQLQuery(GET_MAX_ROUND).addEntity(CompressorData.class).list();
	}

	@Override
	public BigInteger getMaxRoundInteger() {
		List maxRoundList = createSQLQuery(GET_MAX_ROUND_INTEGER).list();
		BigInteger maxround = new BigInteger("0");
		if (maxRoundList != null ) {
			if(maxRoundList.size()>0){
				maxround = (BigInteger) maxRoundList.get(0);
				if (maxround == null) {
					maxround = new BigInteger("0");
				}
			}
		}
		return maxround;
	}

	@Override
	public List<CompressorData> getCompressorDataByRound(int _round) {

		return createQuery(GET_COMPRESSORDATA_BY_ROUND, _round).list();
	}
}
