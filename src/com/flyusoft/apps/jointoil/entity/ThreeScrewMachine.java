package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLY_THREE_SCREW_MACHINE")
public class ThreeScrewMachine extends CompressorMD {

	private Double exhaustTemperature;// 排气温度,
	private Double exhaustPressure;// 排气压力,
	private Double oilPressure;// 机油压力,
	private Double oilTemperature;// 机油温度,
	
	private String compressorCode;// 压缩机的编码,

	public Double getExhaustTemperature() {
		return exhaustTemperature;
	}

	public void setExhaustTemperature(Double exhaustTemperature) {
		this.exhaustTemperature = exhaustTemperature;
	}

	public Double getExhaustPressure() {
		return exhaustPressure;
	}

	public void setExhaustPressure(Double exhaustPressure) {
		this.exhaustPressure = exhaustPressure;
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
