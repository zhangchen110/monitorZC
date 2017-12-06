package com.flyusoft.apps.jointoil.quartz;

import java.text.DecimalFormat;

import java.util.Date;
import java.util.Random;

import com.flyusoft.apps.jointoil.entity.FiveBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.FiveScrewMachine;
import com.flyusoft.apps.jointoil.entity.FourIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.OneIntegratedMachine;
import com.flyusoft.apps.jointoil.entity.ThreeBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.ThreeScrewMachine;
import com.flyusoft.apps.jointoil.entity.TwoBoosterCompressor;
import com.flyusoft.apps.jointoil.entity.TwoScrewMachine;

public class TimerTools {


	public MonitorData monitorDataPojo(String wellno) {
		// 根据wellno 填充数据，每个wellno一个对应实体
			MonitorData monitorData = new MonitorData();
			Random random = new Random();
			
			DecimalFormat df = new DecimalFormat("0.00");
			Double numDouble=9.95;
			Double dou_1 = random.nextDouble() * 40+numDouble;
			Double dou_2 = random.nextDouble() * 40+numDouble;
			Double dou_3 = random.nextDouble() * 40+numDouble;
			Double dou_4 = random.nextDouble() * 40+numDouble;

			dou_1 = Double.valueOf(df.format(dou_1));
			dou_2 = Double.valueOf(df.format(dou_2));
			dou_3 = Double.valueOf(df.format(dou_3));
			dou_4 = Double.valueOf(df.format(dou_4));

			monitorData.setWellNo(wellno);
			monitorData.setTemperature(dou_1);
			monitorData.setPressure(dou_2);
			monitorData.setInstantaneousFlow(dou_3);
			monitorData.setAccumulativeFlow(dou_4);
			monitorData.setMonitorTime(new Date());
			return monitorData;
	}

	


	public OneIntegratedMachine oneIntegratedMachinePojo(String compressorNo) {
		OneIntegratedMachine one = new OneIntegratedMachine();
		RandomNumber random = new RandomNumber();
		one.setOilPressure(random.dou_1);// 机油压力
		one.setCoolingWaterPressure(random.dou_2);// 冷却水压力
		one.setScrewPressure(random.dou_3);// 螺杆压力
		one.setScrewTemperature(random.dou_4);// 螺杆温度
		one.setFirstPistonPressure(random.dou_5);// 一级活塞压力
		one.setFirstPistonTemperature(random.dou_6);// 一级活塞温度
		one.setSecondPistonPressure(random.dou_7);// 二级活塞压力
		one.setSecondPistonTemperature(random.dou_8);// 二级活塞温度
		one.setThirdPistonPressure(random.dou_9);// 三级活塞压力
		one.setThirdPistonTemperature(random.dou_10);// 三级活塞温度
		one.setOilTemperature(random.dou_11);// 机油温度
		one.setCoolingWaterTemperature(random.dou_12);// 冷却水温度
		one.setTime(new Date());
		one.setCompressorCode(compressorNo);
		return one;
	}
	
	
	
	public TwoBoosterCompressor twoBoosterCompressorPojo(String compressorNo){
		TwoBoosterCompressor twob=new TwoBoosterCompressor();
		RandomNumber random = new RandomNumber();
		twob.setInletPressure(random.dou_1);
		twob.setFirstPistonPressure(random.dou_2);
		twob.setSecondPistonPressure(random.dou_3);
		twob.setThirdPistonPressure(random.dou_4);
		twob.setOilPressure(random.dou_5);
		twob.setFirstPistonTemperature(random.dou_6);
		twob.setSecondPistonTemperature(random.dou_8);
		twob.setThirdPistonTemperature(random.dou_9);
		twob.setOilTemperature(random.dou_10);
		twob.setTime(new Date());
		twob.setCompressorCode(  compressorNo);
 
		return twob;
	}

	
	 
	
	public TwoScrewMachine twoScrewMachinePojo(String compressorNo){
		TwoScrewMachine twos = new TwoScrewMachine();
		RandomNumber random = new RandomNumber();
		twos.setOilPressure(random.dou_1);// 机油压力,
		twos.setExhaustPressure(random.dou_4);// 排气压力,
		twos.setTime(new Date());// 监控时间,
		twos.setCompressorCode(  compressorNo);// 压缩机的编码,
		
		return twos;
	}
	

	public ThreeBoosterCompressor threeBoosterCompressorPojo(String compressorNo){
		ThreeBoosterCompressor threeb = new ThreeBoosterCompressor();
		RandomNumber random = new RandomNumber();
		threeb.setFirstPistonPressure(random.dou_1); // 一级活塞压力
		threeb.setFirstPistonTemperature(random.dou_2); // 一级活塞温度,
		threeb.setSecondPistonPressure(random.dou_3); // 二级活塞压力,
		threeb.setOilPressure(random.dou_4); // 机油压力,
		threeb.setOilTemperature(random.dou_5); // 机油温度,
		threeb.setTime(new Date()); // 监控时间,
		threeb.setCompressorCode(  compressorNo); // 压缩机的编码,

		return threeb;

	}
	
	
	public ThreeScrewMachine threeScrewMachinePojo(String compressorNo){
		ThreeScrewMachine threes = new ThreeScrewMachine();
		RandomNumber random = new RandomNumber();
		threes.setExhaustTemperature(random.dou_1);// 排气温度,
		threes.setExhaustPressure(random.dou_2);// 排气压力,
		threes.setOilPressure(random.dou_3);// 机油压力,
		threes.setOilTemperature(random.dou_4);// 机油温度,
		threes.setCompressorCode(  compressorNo);// 压缩机的编码,
		threes.setTime(new Date());// 监控时间,
		return threes;
	}

	public FourIntegratedMachine fourIntegratedMachinePojo(String compressorNo){
		FourIntegratedMachine four=new FourIntegratedMachine();
		RandomNumber random = new RandomNumber();
		four.setOilPressure(random.dou_1);// 机油压力,
		four.setCoolingWaterPressure(random.dou_2);// 冷却水压力,
		four.setScrewPressure(random.dou_3);// 螺杆压力,
		four.setScrewTemperature(random.dou_4);// 螺杆温度,
		four.setFirstPistonPressure(random.dou_5);// 一级活塞压力,
		four.setFirstPistonTemperature(random.dou_6);// 一级活塞温度,
		four.setSecondPistonPressure(random.dou_7);// 二级活塞压力,
		four.setSecondPistonTemperature(random.dou_8);// 二级活塞温度,
		four.setOilTemperature(random.dou_19);// 机油温度,
		four.setCoolingWaterTemperature(random.dou_10);// 冷却水温度,
		four.setTime(new Date());// 监控时间,
		four.setCompressorCode(  compressorNo);// 压缩机的编码,
		return four;
	}

	
	public FiveBoosterCompressor  fiveBoosterCompressorPojo(String compressorNo){
		FiveBoosterCompressor fiveb=new FiveBoosterCompressor();
		RandomNumber random = new RandomNumber();
		fiveb.setFirstPistonPressure(random.dou_2);// 一级活塞压力 ,
		fiveb.setFirstExhaustTemperature(random.dou_3);// 一级排气温度 ,
		fiveb.setSecondInletTemperature(random.dou_4);// 二级进气温度 ,
		fiveb.setSecondPistonPressure(random.dou_5);// 二级活塞压力 ,
		fiveb.setSecondExhaustTemperature(random.dou_6);// 二级排气温度 ,
		fiveb.setOilPressure(random.dou_7);// 机油压力 ,
		fiveb.setOilTemperature(random.dou_8);// 机油温度 ,
		fiveb.setInletPressure(random.dou_9);
		fiveb.setInletTemperature(random.dou_10);
		fiveb.setCompressorCode(   compressorNo);// 压缩机的编码,
		fiveb.setTime(new Date());// 监控时间,
		return fiveb;
	}
	
	 	
	public FiveScrewMachine fiveScrewMachinePojo(String compressorNo) {
		FiveScrewMachine fives=new FiveScrewMachine();
		RandomNumber random = new RandomNumber();
		fives.setBearingTemperature(random.dou_3);// 轴承温度,
		fives.setOutScrewTemperature1(random.dou_4);
		fives.setOutScrewTemperature2(random.dou_5);
		fives.setCompressorCode(  compressorNo);// 压缩机的编码,
		fives.setTime(new Date());// 监控时间,
		return fives;
	}
}
