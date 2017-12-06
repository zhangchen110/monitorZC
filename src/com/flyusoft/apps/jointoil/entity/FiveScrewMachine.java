package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLY_FIVE_SCREW_MACHINE")
public class FiveScrewMachine extends CompressorMD {

	private Double bearingTemperature;// 轴承温度,
	
	
	private String compressorCode;// 压缩机的编码,

	private Double outScrewTemperature1;//螺杆出气温度1
	private Double outScrewTemperature2;//螺杆出气温度2


	public Double getBearingTemperature() {
		return bearingTemperature;
	}

	public void setBearingTemperature(Double bearingTemperature) {
		this.bearingTemperature = bearingTemperature;
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
