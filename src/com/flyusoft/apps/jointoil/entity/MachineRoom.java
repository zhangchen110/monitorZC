package com.flyusoft.apps.jointoil.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.flyusoft.common.entity.IdEntity;
import com.google.common.collect.Lists;

@Entity
@Table(name="FLY_MACHINE_ROOM")
public class MachineRoom  extends IdEntity{
	
	private String roomName;//机房名字
	private String roomNo;//机房编号
	private List<Compressor> compressors=Lists.newArrayList();
	private List<Index> indexs=Lists.newArrayList();
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	@OneToMany(mappedBy = "machineRoom", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	public List<Compressor> getCompressors() {
		return compressors;
	}
	@OneToMany(mappedBy = "room", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	public List<Index> getIndexs() {
		return indexs;
	}

	public void setIndexs(List<Index> indexs) {
		this.indexs = indexs;
	}

	public void setCompressors(List<Compressor> compressors) {
		this.compressors = compressors;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
	
	
}
