package com.flyusoft.apps.jointoil.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.flyusoft.common.entity.IdEntity;

@Entity
@Table(name = "FLY_MONITOR_DATA")
public class MonitorData extends IdEntity {

	private String wellNo;
	private Double temperature;
	private Double pressure;
	private Double instantaneousFlow;
	private Double accumulativeFlow;
	private Date monitorTime;


	
	public MonitorData() {
		super();
	}

	public MonitorData(String wellNo, Double temperature, Double pressure,
			Double instantaneousFlow, Double accumulativeFlow, Date monitorTime) {
		super();
		this.wellNo = wellNo;
		this.temperature = temperature;
		this.pressure = pressure;
		this.instantaneousFlow = instantaneousFlow;
		this.accumulativeFlow = accumulativeFlow;
		this.monitorTime = monitorTime;
	}

	public String getWellNo() {
		return wellNo;

	}

	public void setWellNo(String wellNo) {
		this.wellNo = wellNo;

	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getInstantaneousFlow() {
		return instantaneousFlow;
	}

	public void setInstantaneousFlow(Double instantaneousFlow) {
		this.instantaneousFlow = instantaneousFlow;
	}

	public Double getAccumulativeFlow() {
		return accumulativeFlow;
	}

	public void setAccumulativeFlow(Double accumulativeFlow) {
		this.accumulativeFlow = accumulativeFlow;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getMonitorTime() {
		return monitorTime;
	}

	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}

}
