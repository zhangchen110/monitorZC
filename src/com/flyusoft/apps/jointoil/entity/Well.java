package com.flyusoft.apps.jointoil.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.flyusoft.common.entity.IdEntity;
import com.google.common.collect.Lists;

@Entity
@Table(name = "FLY_WELL")
public class Well extends IdEntity {

	private String wellNo;
	private String wellName;
	private List<Index> indexList = Lists.newArrayList();
	//------------------------------
	//以下数据库没有
	private List<String> xmlList;//显示柱形xml集合
	private List<String> curveXmlList;//显示曲线xml集合
	private String insString;//显示瞬时流量
	private String accString;//显示累计流量
	private String monitorTime;
	private String status;
	private String preValue;
	public String getWellNo() {
		return wellNo;
	}

	public void setWellNo(String wellNo) {
		this.wellNo = wellNo;
	}

	public String getWellName() {
		return wellName;
	}

	public void setWellName(String wellName) {
		this.wellName = wellName;
	}

	@OneToMany(mappedBy = "well", cascade = { CascadeType.REMOVE ,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("orderBy")
	public List<Index> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<Index> indexList) {
		this.indexList = indexList;
	}

	@Transient
	public List<String> getXmlList() {
		return xmlList;
	}

	public void setXmlList(List<String> xmlList) {
		this.xmlList = xmlList;
	}
	@Transient
	public List<String> getCurveXmlList() {
		return curveXmlList;
	}

	public void setCurveXmlList(List<String> curveXmlList) {
		this.curveXmlList = curveXmlList;
	}
	@Transient
	public String getInsString() {
		return insString;
	}

	public void setInsString(String insString) {
		this.insString = insString;
	}
	@Transient
	public String getAccString() {
		return accString;
	}

	public void setAccString(String accString) {
		this.accString = accString;
	}
	@Transient
	public String getMonitorTime() {
		return monitorTime;
	}

	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}
	@Transient
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Transient
	public String getPreValue() {
		return preValue;
	}

	public void setPreValue(String preValue) {
		this.preValue = preValue;
	}
	
	
}
