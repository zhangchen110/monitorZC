package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLY_FIVE_BOOSTER_COMPRESSOR")
public class FiveBoosterCompressor extends CompressorMD {

	private Double oilPressure;// 机油压力 ,
	private Double oilTemperature;// 机油温度 ,
	private Double firstPistonPressure;// 一级活塞压力 ,
	private Double firstExhaustTemperature;// 一级排气温度 ,
	private Double secondInletTemperature;// 二级进气温度 ,
	private Double secondPistonPressure;// 二级活塞压力 ,
	private Double secondExhaustTemperature;// 二级排气温度 ,
	private Double inletPressure;// 进气压力,
	private Double inletTemperature;// 进气温度,
	private String compressorCode;// 压缩机的编码,

	public Double getFirstExhaustTemperature() {
		return firstExhaustTemperature;
	}

	public void setFirstExhaustTemperature(Double firstExhaustTemperature) {
		this.firstExhaustTemperature = firstExhaustTemperature;
	}

	public Double getFirstPistonPressure() {
		return firstPistonPressure;
	}

	public void setFirstPistonPressure(Double firstPistonPressure) {
		this.firstPistonPressure = firstPistonPressure;
	}


	public Double getSecondInletTemperature() {
		return secondInletTemperature;
	}

	public void setSecondInletTemperature(Double secondInletTemperature) {
		this.secondInletTemperature = secondInletTemperature;
	}

	public Double getSecondPistonPressure() {
		return secondPistonPressure;
	}

	public void setSecondPistonPressure(Double secondPistonPressure) {
		this.secondPistonPressure = secondPistonPressure;
	}

	public Double getSecondExhaustTemperature() {
		return secondExhaustTemperature;
	}

	public void setSecondExhaustTemperature(Double secondExhaustTemperature) {
		this.secondExhaustTemperature = secondExhaustTemperature;
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

	public Double getInletPressure() {//进气压力
		return inletPressure;
	}

	public void setInletPressure(Double inletPressure) {
		this.inletPressure = inletPressure;
	}
	public Double getInletTemperature() {
		return inletTemperature;
	}

	public void setInletTemperature(Double inletTemperature) {
		this.inletTemperature = inletTemperature;
	}

}
