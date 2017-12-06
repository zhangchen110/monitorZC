package com.flyusoft.apps.jointoil.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.flyusoft.common.entity.IdEntity;

@Entity
@Table(name = "MONITOR_INDEX")
public class Index extends IdEntity {

	private String indexName;//指标名字
	private Double max;//最大值
	private Double min;//最小值
	private Double threshold;//阀值  
	private String unit;//单位
	private String indexCode;//指标编码
	private Integer orderBy; //排序
	private Well well;//对应的井
	
	private Integer status;//判断是否报警最高上、下限  大小值0为有  1为没有
	private Compressor compressor;//对应的压缩机
	private Double maxLimit;//最大限制
	private Double minLimit;//最小限制
	
	private MachineRoom room;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_id")
	public Well getWell() {
		return well;
	}

	public void setWell(Well well) {
		this.well = well;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compressor_id")
	public Compressor getCompressor() {
		return compressor;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "machine_room_id")
	public MachineRoom getRoom() {
		return room;
	}

	public void setRoom(MachineRoom room) {
		this.room = room;
	}

	public void setCompressor(Compressor compressor) {
		this.compressor = compressor;
	}

	public Double getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Double maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Double getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(Double minLimit) {
		this.minLimit = minLimit;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


}
