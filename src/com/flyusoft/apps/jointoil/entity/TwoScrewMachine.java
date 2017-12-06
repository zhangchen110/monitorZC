package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLY_TWO_SCREW_MACHINE")
public class TwoScrewMachine extends CompressorMD {
	private Double oilPressure;//  机油压力,
	private Double exhaustPressure;// 排气压力,
	private Double outScrewTemperature1;//螺杆出气温度1
	private Double outScrewTemperature2;//螺杆出气温度2
	
	private String compressorCode;//  压缩机的编码,

	public Double getOilPressure() {
		return oilPressure;
	}

	public void setOilPressure(Double oilPressure) {
		this.oilPressure = oilPressure;
	}


	public Double getExhaustPressure() {
		return exhaustPressure;
	}

	public void setExhaustPressure(Double exhaustPressure) {
		this.exhaustPressure = exhaustPressure;
	}

	public String getCompressorCode() {
		return compressorCode;
	}

	public void setCompressorCode(String compressorCode) {
		this.compressorCode = compressorCode;
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
