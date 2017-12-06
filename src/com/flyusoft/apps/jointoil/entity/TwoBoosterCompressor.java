package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLY_TWO_BOOSTER_COMPRESSOR")
public class TwoBoosterCompressor extends CompressorMD {
	private Double inletPressure;// 进气压力,
	private Double firstPistonPressure;// 一级活塞压力,
	private Double secondPistonPressure;// 二级活塞压力,
	private Double thirdPistonPressure;//  三级活塞压力,
	private Double oilPressure;// 机油压力,
	private Double firstPistonTemperature;//  一级活塞温度,
	private Double secondPistonTemperature;// 二级活塞温度,
	private Double thirdPistonTemperature;// 三级活塞温度,
	private Double oilTemperature;// 机油温度,
	private String compressorCode;//  压缩机的编码,

	public Double getInletPressure() {
		return inletPressure;
	}

	public void setInletPressure(Double inletPressure) {
		this.inletPressure = inletPressure;
	}

	public Double getFirstPistonPressure() {
		return firstPistonPressure;
	}

	public void setFirstPistonPressure(Double firstPistonPressure) {
		this.firstPistonPressure = firstPistonPressure;
	}

	public Double getSecondPistonPressure() {
		return secondPistonPressure;
	}

	public void setSecondPistonPressure(Double secondPistonPressure) {
		this.secondPistonPressure = secondPistonPressure;
	}

	public Double getThirdPistonPressure() {
		return thirdPistonPressure;
	}

	public void setThirdPistonPressure(Double thirdPistonPressure) {
		this.thirdPistonPressure = thirdPistonPressure;
	}

	public Double getOilPressure() {
		return oilPressure;
	}

	public void setOilPressure(Double oilPressure) {
		this.oilPressure = oilPressure;
	}

	public Double getFirstPistonTemperature() {
		return firstPistonTemperature;
	}

	public void setFirstPistonTemperature(Double firstPistonTemperature) {
		this.firstPistonTemperature = firstPistonTemperature;
	}

	public Double getSecondPistonTemperature() {
		return secondPistonTemperature;
	}

	public void setSecondPistonTemperature(Double secondPistonTemperature) {
		this.secondPistonTemperature = secondPistonTemperature;
	}

	public Double getThirdPistonTemperature() {
		return thirdPistonTemperature;
	}

	public void setThirdPistonTemperature(Double thirdPistonTemperature) {
		this.thirdPistonTemperature = thirdPistonTemperature;
	}

	public Double getOilTemperature() {
		return oilTemperature;
	}

	public void setOilTemperature(Double oilTemperature) {
		this.oilTemperature = oilTemperature;
	}

//	public String getRunningState() {
//		return runningState;
//	}
//
//	public void setRunningState(String runningState) {
//		this.runningState = runningState;
//	}


	//	public String getRunningTime() {
	//		return runningTime;
	//	}
	//
	//	public void setRunningTime(String runningTime) {
	//		this.runningTime = runningTime;
	//	}

	public String getCompressorCode() {
		return compressorCode;
	}

	public void setCompressorCode(String compressorCode) {
		this.compressorCode = compressorCode;
	}

	//	public Date getTime() {
	//		return time;
	//	}
	//
	//	public void setTime(Date time) {
	//		this.time = time;
	//	}

}
