package com.flyusoft.apps.jointoil.util;

import java.util.Date;

import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.ThreeBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;
import com.flyusoft.apps.jointoil.quartz.RandomNumber;

public class CompressorSaveEmpty {

	public OneIntegratedMachine OneIntegratedMachinePojo(String compressorNo,Date date) {
		OneIntegratedMachine one = new OneIntegratedMachine();
		
		one.setOilPressure(null);// 机油压力
		one.setCoolingWaterPressure(null);// 冷却水压力
		one.setScrewPressure(null);// 螺杆压力
		one.setScrewTemperature(null);// 螺杆温度
		one.setFirstPistonPressure(null);// 一级活塞压力
		one.setFirstPistonTemperature(null);// 一级活塞温度
		one.setSecondPistonPressure(null);// 二级活塞压力
		one.setSecondPistonTemperature(null);// 二级活塞温度
		one.setThirdPistonPressure(null);// 三级活塞压力
		one.setThirdPistonTemperature(null);// 三级活塞温度
		one.setOilTemperature(null);// 机油温度
		one.setCoolingWaterTemperature(null);// 冷却水温度
		one.setTime(  date);
		one.setCompressorCode(compressorNo);
		return one;
	}
	
	
	
	public TwoBoosterCompressor TwoBoosterCompressorPojo(String compressorNo,Date date){
		TwoBoosterCompressor twob=new TwoBoosterCompressor();
		
		twob.setInletPressure(null);
		twob.setOilPressure(null);
		twob.setOilTemperature(null);
		twob.setFirstPistonPressure(null);
		twob.setFirstPistonTemperature(null);
		twob.setSecondPistonPressure(null);
		twob.setSecondPistonTemperature(null);
		twob.setThirdPistonTemperature(null);
		twob.setThirdPistonPressure(null);
		twob.setTime(date);
		twob.setCompressorCode(  compressorNo);
		return twob;
	}

	
	 
	
	public TwoScrewMachine TwoScrewMachinePojo(String compressorNo,Date date){
		TwoScrewMachine twos = new TwoScrewMachine();
		
		twos.setOilPressure(null);// 机油压力,
		twos.setExhaustPressure(null);// 排气压力,
		twos.setTime(date);// 监控时间,
		twos.setCompressorCode( compressorNo);// 压缩机的编码,
		
		return twos;
	}
	

	public ThreeBoosterCompressor ThreeBoosterCompressorPojo(String compressorNo,Date date){
		ThreeBoosterCompressor threeb = new ThreeBoosterCompressor();
		
		threeb.setFirstPistonPressure(null); // 一级活塞压力
		threeb.setFirstPistonTemperature(null); // 一级活塞温度,
		threeb.setSecondPistonTemperature(null); // 一级活塞温度,
		threeb.setSecondPistonPressure(null); // 二级活塞压力,
		threeb.setOilPressure(null); // 机油压力,
		threeb.setOilTemperature(null); // 机油温度,
		threeb.setTime(date); // 监控时间,
		threeb.setCompressorCode(  compressorNo); // 压缩机的编码,

		return threeb;

	}
	
	
	public ThreeScrewMachine ThreeScrewMachinePojo(String compressorNo,Date date){
		ThreeScrewMachine threes = new ThreeScrewMachine();
		
		threes.setExhaustTemperature(null);// 排气温度,
		threes.setExhaustPressure(null);// 排气压力,
		threes.setOilPressure(null);// 机油压力,
		threes.setOilTemperature(null);// 机油温度,
		threes.setCompressorCode(  compressorNo);// 压缩机的编码,
		threes.setTime(date);// 监控时间,
		return threes;
	}

	public FourIntegratedMachine FourIntegratedMachinePojo(String compressorNo,Date date){
		FourIntegratedMachine four=new FourIntegratedMachine();
		
		four.setOilPressure(null);// 机油压力,
		four.setCoolingWaterPressure(null);// 冷却水压力,
		four.setScrewPressure(null);// 螺杆压力,
		four.setScrewTemperature(null);// 螺杆温度,
		four.setFirstPistonPressure(null);// 一级活塞压力,
		four.setFirstPistonTemperature(null);// 一级活塞温度,
		four.setSecondPistonPressure(null);// 二级活塞压力,
		four.setSecondPistonTemperature(null);// 二级活塞温度,
		four.setOilTemperature(null);// 机油温度,
		four.setCoolingWaterTemperature(null);// 冷却水温度,
		four.setTime( date);// 监控时间,
		four.setCompressorCode(  compressorNo);// 压缩机的编码,
		return four;
	}

	
	public FiveBoosterCompressor  FiveBoosterCompressorPojo(String compressorNo,Date date){
		FiveBoosterCompressor fiveb=new FiveBoosterCompressor();
		
		fiveb.setFirstPistonPressure(null);// 一级活塞压力 ,
		fiveb.setFirstExhaustTemperature(null);// 一级排气温度 ,
		fiveb.setSecondInletTemperature(null);// 二级进气温度 ,
		fiveb.setSecondPistonPressure(null);// 二级活塞压力 ,
		fiveb.setSecondExhaustTemperature(null);// 二级排气温度 ,
		fiveb.setOilPressure(null);// 机油压力 ,
		fiveb.setOilTemperature(null);// 机油温度 ,
		fiveb.setInletPressure(null);
		fiveb.setInletTemperature(null);
		fiveb.setCompressorCode(   compressorNo);// 压缩机的编码,
		fiveb.setTime(date);// 监控时间,
		return fiveb;
	}
	
	 	
	public FiveScrewMachine FiveScrewMachinePojo(String compressorNo,Date date) {
		FiveScrewMachine fives=new FiveScrewMachine();
		
		fives.setBearingTemperature(null);// 轴承温度,
		fives.setOutScrewTemperature1(null);
		fives.setOutScrewTemperature2(null);
		fives.setCompressorCode(  compressorNo);// 压缩机的编码,
		fives.setTime(date);// 监控时间,
		return fives;
	}
}
