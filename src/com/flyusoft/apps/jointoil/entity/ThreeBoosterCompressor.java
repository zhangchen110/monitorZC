package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLY_THREE_BOOSTER_COMPRESSOR")
public class ThreeBoosterCompressor extends CompressorMD {
	private Double firstPistonPressure; // 一级活塞压力
	private Double firstPistonTemperature; //  一级活塞温度,
	private Double secondPistonPressure; // 二级活塞压力,
	private Double secondPistonTemperature;//二级活塞温度
	private Double oilPressure; // 机油压力,
	private Double oilTemperature; // 机油温度,
	
	private String compressorCode; // 压缩机的编码,

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

	public Double getOilPressure() {
		return oilPressure;
	}

	public void setOilPressure(Double oilPressure) {
		this.oilPressure = oilPressure;
	}

	public Double getOilTemperature() {
		return oilTemperature;
	}

	public void setOilTemperature(Double oilTemperature) {
		this.oilTemperature = oilTemperature;
	}

	public String getCompressorCode() {
		return compressorCode;
	}

	public void setCompressorCode(String compressorCode) {
		this.compressorCode = compressorCode;
	}

	

}
