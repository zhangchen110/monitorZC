package com.flyusoft.apps.jointoil.entity;

import java.util.Date;


/**
 * 这个类是包括8中压缩机类型的所有指标
 * @author Yanglongquan
 * 2011-10-14
 * yanglongquan@flyu.com
 *
 */
public class CompressorMonitorData {
	private Double oilPressure;// 机油压力 ,
	private Double coolingWaterPressure;// 冷却水压力,
	private Double screwPressure;// 螺杆压力,
	private Double screwTemperature;// 螺杆温度,
	private Double firstPistonPressure;// 一级活塞压力 ,
	private Double firstPistonTemperature;// 一级活塞温度,
	private Double secondPistonPressure;// 二级活塞压力 ,
	private Double secondPistonTemperature;// 二级活塞温度,
	private Double thirdPistonPressure;//三级活塞压力
	private Double thirdPistonTemperature;//三级活塞温度
	private Double oilTemperature;// 机油温度 ,
	private Double coolingWaterTemperature;// 冷却水温度,
	private Double exhaustPressure;// 排气压力,
	private Double inletPressure;// 进气压力, //五机房后来的也叫这名字
	private Double exhaustTemperature;// 排气温度,
	private Double firstInletTemperature;// 一级进气温度 ,
	private Double firstExhaustTemperature;// 一级排气温度 ,
	private Double secondInletTemperature;// 二级进气温度 ,
	private Double secondExhaustTemperature;// 二级排气温度 ,
	private Double outletTemperature;// 出气温度,
	private Double inletTemperature;// 进气温度,
	private Double bearingTemperature;// 轴承温度,
	
	//5机房2机房螺杆机
	private Double outScrewTemperature1;//螺杆出气温度1
	private Double outScrewTemperature2;//螺杆出气温度2
	private String runningState;// 运行状态 ,
	private String runningStartTime;// 运行开始时间 ,1989-10-1
	private String runningTime;// 运行时间 , 1天3小时24分钟
	
	
	//其他参数
	private Date time;// 监控时间,
	private String compressorCode;// 压缩机的编码,
	public Double getOilPressure() {
		return oilPressure;
	}
	public void setOilPressure(Double oilPressure) {
		this.oilPressure = oilPressure;
	}
	public Double getCoolingWaterPressure() {
		return coolingWaterPressure;
	}
	public void setCoolingWaterPressure(Double coolingWaterPressure) {
		this.coolingWaterPressure = coolingWaterPressure;
	}
	public Double getScrewPressure() {
		return screwPressure;
	}
	public void setScrewPressure(Double screwPressure) {
		this.screwPressure = screwPressure;
	}
	public Double getScrewTemperature() {
		return screwTemperature;
	}
	public void setScrewTemperature(Double screwTemperature) {
		this.screwTemperature = screwTemperature;
	}
	public Double getFirstPistonPressure() {
		return firstPistonPressure;
	}
	public void setFirstPistonPressure(Double firstPistonPressure) {
		this.firstPistonPressure = firstPistonPressure;
	}
	public Double getFirstPistonTemperature() {
		return firstPistonTemperature;
	}
	public void setFirstPistonTemperature(Double firstPistonTemperature) {
		this.firstPistonTemperature = firstPistonTemperature;
	}
	public Double getSecondPistonPressure() {
		return secondPistonPressure;
	}
	public void setSecondPistonPressure(Double secondPistonPressure) {
		this.secondPistonPressure = secondPistonPressure;
	}
	public Double getSecondPistonTemperature() {
		return secondPistonTemperature;
	}
	public void setSecondPistonTemperature(Double secondPistonTemperature) {
		this.secondPistonTemperature = secondPistonTemperature;
	}
	public Double getThirdPistonPressure() {
		return thirdPistonPressure;
	}
	public void setThirdPistonPressure(Double thirdPistonPressure) {
		this.thirdPistonPressure = thirdPistonPressure;
	}
	public Double getThirdPistonTemperature() {
		return thirdPistonTemperature;
	}
	public void setThirdPistonTemperature(Double thirdPistonTemperature) {
		this.thirdPistonTemperature = thirdPistonTemperature;
	}
	public String getRunningState() {
		return runningState;
	}
	public void setRunningState(String runningState) {
		this.runningState = runningState;
	}
	public String getRunningStartTime() {
		return runningStartTime;
	}
	public void setRunningStartTime(String runningStartTime) {
		this.runningStartTime = runningStartTime;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public Double getOilTemperature() {
		return oilTemperature;
	}
	public void setOilTemperature(Double oilTemperature) {
		this.oilTemperature = oilTemperature;
	}
	public Double getCoolingWaterTemperature() {
		return coolingWaterTemperature;
	}
	public void setCoolingWaterTemperature(Double coolingWaterTemperature) {
		this.coolingWaterTemperature = coolingWaterTemperature;
	}
	public Double getExhaustPressure() {
		return exhaustPressure;
	}
	public void setExhaustPressure(Double exhaustPressure) {
		this.exhaustPressure = exhaustPressure;
	}
	public Double getInletPressure() {
		return inletPressure;
	}
	public void setInletPressure(Double inletPressure) {
		this.inletPressure = inletPressure;
	}
	public Double getExhaustTemperature() {
		return exhaustTemperature;
	}
	public void setExhaustTemperature(Double exhaustTemperature) {
		this.exhaustTemperature = exhaustTemperature;
	}
	public Double getFirstInletTemperature() {
		return firstInletTemperature;
	}
	public void setFirstInletTemperature(Double firstInletTemperature) {
		this.firstInletTemperature = firstInletTemperature;
	}
	public Double getFirstExhaustTemperature() {
		return firstExhaustTemperature;
	}
	public void setFirstExhaustTemperature(Double firstExhaustTemperature) {
		this.firstExhaustTemperature = firstExhaustTemperature;
	}
	public Double getSecondInletTemperature() {
		return secondInletTemperature;
	}
	public void setSecondInletTemperature(Double secondInletTemperature) {
		this.secondInletTemperature = secondInletTemperature;
	}
	public Double getSecondExhaustTemperature() {
		return secondExhaustTemperature;
	}
	public void setSecondExhaustTemperature(Double secondExhaustTemperature) {
		this.secondExhaustTemperature = secondExhaustTemperature;
	}
	public Double getOutletTemperature() {
		return outletTemperature;
	}
	public void setOutletTemperature(Double outletTemperature) {
		this.outletTemperature = outletTemperature;
	}
	public Double getBearingTemperature() {
		return bearingTemperature;
	}
	public void setBearingTemperature(Double bearingTemperature) {
		this.bearingTemperature = bearingTemperature;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getCompressorCode() {
		return compressorCode;
	}
	public void setCompressorCode(String compressorCode) {
		this.compressorCode = compressorCode;
	}
	public Double getInletTemperature() {
		return inletTemperature;
	}
	public void setInletTemperature(Double inletTemperature) {
		this.inletTemperature = inletTemperature;
	}
	public Double getOutScrewTemperature1() {
		return outScrewTemperature1;
	}
	public void setOutScrewTemperature1(Double outScrewTemperature1) {
		this.outScrewTemperature1 = outScrewTemperature1;
	}
	public Double getOutScrewTemperature2() {
		return outScrewTemperature2;
	}
	public void setOutScrewTemperature2(Double outScrewTemperature2) {
		this.outScrewTemperature2 = outScrewTemperature2;
	}
	
}
