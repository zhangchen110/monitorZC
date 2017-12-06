package com.flyusoft.apps.jointoil.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.flyusoft.common.entity.IdEntity;
import com.google.common.collect.Lists;

/**
 * 压缩机实体
 * 
 * @author Yanglongquan 2011-9-27 yanglongquan@flyu.com
 * 
 */
@Entity
@Table(name = "FLY_COMPRESSOR")
public class Compressor extends IdEntity {

	private String compressorName;// 压缩机名字

	private String compressorNo;// 压缩机型号
	private String compressorCode;// 压缩机编号
	private List<Index> comIndexs = Lists.newArrayList();// 所有压缩机指标

	private MachineRoom machineRoom;// 对应的机房
	private String comTop;// 相对高度
	private String comLeft;// 左边距

	private String state;// 压缩机状态       0-停止 1-运行 2-报警
	private String runningTime;// 运行了多久
	private Date   runningStartTime;// 起始时间

	private List<String> tmpXmlList;// 温度xml集合
	private List<String> preXmlList;// 压力xml集合

	private List<String> indexLValueList;//螺杆机集合
	private List<String> indexYValueList;//压缩机集合
	private int identify;

	public String getComLeft() {
		return comLeft;
	}

	public void setComLeft(String comLeft) {
		this.comLeft = comLeft;
	}

	public String getComTop() {
		return comTop;
	}

	public void setComTop(String comTop) {
		this.comTop = comTop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "machine_room_id")
	public MachineRoom getMachineRoom() {
		return machineRoom;
	}

	public void setMachineRoom(MachineRoom machineRoom) {
		this.machineRoom = machineRoom;
	}

	public String getCompressorName() {
		return compressorName;
	}

	public void setCompressorName(String compressorName) {
		this.compressorName = compressorName;
	}

	public String getCompressorNo() {
		return compressorNo;
	}

	public void setCompressorNo(String compressorNo) {
		this.compressorNo = compressorNo;
	}

	@OneToMany(mappedBy = "compressor", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("orderBy")
	public List<Index> getComIndexs() {
		return comIndexs;
	}

	public void setComIndexs(List<Index> comIndexs) {
		this.comIndexs = comIndexs;
	}

	public String getCompressorCode() {
		return compressorCode;
	}

	public void setCompressorCode(String compressorCode) {
		this.compressorCode = compressorCode;
	}

	@Transient
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Transient
	public List<String> getTmpXmlList() {
		return tmpXmlList;
	}

	public void setTmpXmlList(List<String> tmpXmlList) {
		this.tmpXmlList = tmpXmlList;
	}

	@Transient
	public List<String> getPreXmlList() {
		return preXmlList;
	}

	public void setPreXmlList(List<String> preXmlList) {
		this.preXmlList = preXmlList;
	}

	@Transient
	public List<String> getIndexLValueList() {
		return indexLValueList;
	}

	public void setIndexLValueList(List<String> indexLValueList) {
		this.indexLValueList = indexLValueList;
	}
	@Transient
	public List<String> getIndexYValueList() {
		return indexYValueList;
	}

	public void setIndexYValueList(List<String> indexYValueList) {
		this.indexYValueList = indexYValueList;
	}

	@Transient
	public int getIdentify() {
		return identify;
	}

	public void setIdentify(int identify) {
		this.identify = identify;
	}
	@Transient
	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	@Transient
	public Date getRunningStartTime() {
		return runningStartTime;
	}

	public void setRunningStartTime(Date runningStartTime) {
		this.runningStartTime = runningStartTime;
	}
	
}
