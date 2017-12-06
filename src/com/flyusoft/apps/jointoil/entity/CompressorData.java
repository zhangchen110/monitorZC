package com.flyusoft.apps.jointoil.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.flyusoft.common.entity.IdEntity;
@Entity
@Table(name = "FLY_COMPRESSOR_DATA")
public class CompressorData    {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")   
	private String id;
	
	 private String adconverterNum;
	 private Date   monitorTime;
	 private Double hole1;
	 private Double hole2;
	 private Double hole3;
	 private Double hole4;
	 private Double hole5;
	 private Double hole6;
	 private Double hole7;
	 private Double hole8;
	 private Integer round;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdconverterNum() {
		return adconverterNum;
	}
	public void setAdconverterNum(String adconverterNum) {
		this.adconverterNum = adconverterNum;
	}
	public Date getMonitorTime() {
		return monitorTime;
	}
	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}
	public Double getHole1() {
		return hole1;
	}
	public void setHole1(Double hole1) {
		this.hole1 = hole1;
	}
	public Double getHole2() {
		return hole2;
	}
	public void setHole2(Double hole2) {
		this.hole2 = hole2;
	}
 
	public Double getHole3() {
		return hole3;
	}
	public void setHole3(Double hole3) {
		this.hole3 = hole3;
	}
	public Double getHole4() {
		return hole4;
	}
	public void setHole4(Double hole4) {
		this.hole4 = hole4;
	}
	public Double getHole5() {
		return hole5;
	}
	public void setHole5(Double hole5) {
		this.hole5 = hole5;
	}
	public Double getHole6() {
		return hole6;
	}
	public void setHole6(Double hole6) {
		this.hole6 = hole6;
	}
	public Double getHole7() {
		return hole7;
	}
	public void setHole7(Double hole7) {
		this.hole7 = hole7;
	}
	public Double getHole8() {
		return hole8;
	}
	public void setHole8(Double hole8) {
		this.hole8 = hole8;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	} 
	 
}
