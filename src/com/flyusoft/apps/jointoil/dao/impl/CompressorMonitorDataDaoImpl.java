package com.flyusoft.apps.jointoil.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.CompressorMonitorDataDao;
import com.flyusoft.apps.jointoil.entity.CompressorMonitorData;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;

@Repository
@SuppressWarnings("unchecked")
public class CompressorMonitorDataDaoImpl extends BaseHibernateDaoImpl<CompressorMonitorData, String> implements CompressorMonitorDataDao {

	private final static String QUERY_ALL_COMPRESSOR_LAST_MONITORDATA_VIEW="select * from jointoil_compressor_view";
	
	
	@Override
	public List<CompressorMonitorData> getAllCompressorMonitorDatas() {
		List<CompressorMonitorData> datas=new ArrayList<CompressorMonitorData>();
		List<Object[]> list=createSQLQuery(QUERY_ALL_COMPRESSOR_LAST_MONITORDATA_VIEW).list();
		for (Object[] obj : list) {
			CompressorMonitorData c=new CompressorMonitorData();
			c.setOilPressure((Double)obj[0]);// 机油压力 ,
			c.setCoolingWaterPressure((Double)obj[1]);// 冷却水压力,
			c.setScrewPressure((Double)obj[2]);// 螺杆压力,
			c.setScrewTemperature((Double)obj[3]);// 螺杆温度,
			c.setFirstPistonPressure((Double)obj[4]);// 一级活塞压力 ,
			c.setFirstPistonTemperature((Double)obj[5]);// 一级活塞温度,
			c.setSecondPistonPressure((Double)obj[6]);// 二级活塞压力 ,
			c.setSecondPistonTemperature((Double)obj[7]);// 二级活塞温度,
			c.setThirdPistonPressure((Double)obj[8]);//三级活塞压力
			c.setThirdPistonTemperature((Double)obj[9]);//三级活塞温度
			c.setOilTemperature((Double)obj[10]);// 机油温度 ,
			c.setCoolingWaterTemperature((Double)obj[11]);// 冷却水温度,
			c.setExhaustPressure((Double)obj[12]);// 排气压力,
			c.setInletPressure((Double)obj[13]);// 进气压力,
			c.setExhaustTemperature((Double)obj[14]);// 排气温度,
			c.setFirstInletTemperature((Double)obj[15]);// 一级进气温度 ,
			c.setFirstExhaustTemperature((Double)obj[16]);// 一级排气温度 ,
			c.setSecondInletTemperature((Double)obj[17]);// 二级进气温度 ,
			c.setSecondExhaustTemperature((Double)obj[18]);// 二级排气温度 ,
			c.setBearingTemperature((Double)obj[19]);// 轴承温度,
			c.setInletTemperature((Double)obj[20]);//进气温度
			c.setOutScrewTemperature1((Double)obj[21]);//螺杆出气温度1
			c.setOutScrewTemperature2((Double)obj[22]);//螺杆出气温度2
			
			c.setTime((Date)obj[23]);// 监控时间,
			c.setCompressorCode((String)obj[24]);// 压缩机的编码,
			datas.add(c);
		}
		
		return datas;
	}

}
