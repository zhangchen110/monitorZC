package com.flyusoft.apps.jointoil.dao;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.CompressorMonitorData;
import com.flyusoft.common.dao.BaseDao;

public interface CompressorMonitorDataDao extends  BaseDao<CompressorMonitorData, String> {
	
	public List<CompressorMonitorData> getAllCompressorMonitorDatas();
}
