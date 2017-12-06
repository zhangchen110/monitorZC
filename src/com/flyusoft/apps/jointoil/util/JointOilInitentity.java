package com.flyusoft.apps.jointoil.util;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.Well;
import com.google.common.collect.Lists;

public class JointOilInitentity {

	private static JointOilInitentity jointOilInitentity = null;

	private List<Well> wellList = Lists.newArrayList();
	private List<MachineRoom> machineRoomList = Lists.newArrayList();

	private JointOilInitentity() {

	}

	public static JointOilInitentity getInstance() {
		if (jointOilInitentity == null)
			jointOilInitentity = new JointOilInitentity();
		return jointOilInitentity;
	}

	public List<Well> getWellList() {
		return wellList;
	}

	public void setWellList(List<Well> wellList) {
		this.wellList = wellList;
	}

	public List<MachineRoom> getMachineRoomList() {
		return machineRoomList;
	}

	public void setMachineRoomList(List<MachineRoom> machineRoomList) {
		this.machineRoomList = machineRoomList;
	}

	/**
	 * 通过井id获取单井对象
	 * @param wellId
	 * @return
	 */
	public Well getWellByWellId(String wellId) {
		for (Well well : wellList) {
			if (well.getId().equals(wellId))
				return well;
		}
		return null;
	}

	/**
	 * 通过井wellNo获取单井对象
	 * @param _wellNo
	 * @return
	 */
	public Well getWellByWellNo(String _wellNo) {
		for (Well well : wellList) {
			if (well.getWellNo().equals(_wellNo))
				return well;
		}
		return null;
	}

	/**
	 * 通过机房id获取单机房对象
	 * @param machineRoomId
	 * @return
	 */
	public MachineRoom getMachineRoomByMachineRoomId(String machineRoomId) {
		for (MachineRoom machineRoom : machineRoomList) {
			if (machineRoom.getId().equals(machineRoomId))
				return machineRoom;
		}
		return null;
	}
	/**
	 * 通过机房No获取单机房对象
	 * @param machineRoomId
	 * @return
	 */
	public MachineRoom getMachineRoomByMachineRoomNo(String machineRoomNo) {
		for (MachineRoom machineRoom : machineRoomList) {
			if (machineRoom.getRoomNo().equals(machineRoomNo))
				return machineRoom;
		}
		return null;
	}

	/**
	 * 通过机房id与压缩机id获取压缩机
	 * @param machineRoomId
	 * @param compressorId
	 * @return
	 */
	public Compressor getCompressorByMachineRoomIdAndCompressorId(String machineRoomId, String compressorId) {
		for (MachineRoom machineRoom : machineRoomList) {
			if (machineRoom.getId().equals(machineRoomId)) {
				List<Compressor> compressorList = machineRoom.getCompressors();
				for (Compressor compressor : compressorList) {
					if (compressor.getId().equals(compressorId))
						return compressor;
				}
			}
		}
		return null;
	}

	/**
	 * 通过压缩机id获取压缩机
	 * @param compressorId
	 * @return
	 */
	public Compressor getCompressorByCompressorId(String compressorId) {
		for (MachineRoom machineRoom : machineRoomList) {
			List<Compressor> compressorList = machineRoom.getCompressors();
			for (Compressor compressor : compressorList) {
				if (compressor.getId().equals(compressorId))
					return compressor;
			}
		}
		return null;
	}
	/**
	 * 通过压缩机compressorCode获取压缩机
	 * @param compressorCode
	 * @return
	 */
	public Compressor getCompressorByCompressorCode(String compressorCode) {
		for (MachineRoom machineRoom : machineRoomList) {
			List<Compressor> compressorList = machineRoom.getCompressors();
			for (Compressor compressor : compressorList) {
				if (compressor.getCompressorCode().equals(compressorCode)){
					return compressor;
				}
			}
		}
		return null;
	}
	/**
	 * 获取所有压缩机
	 * @return
	 */
	public List<Compressor> getAllCompressor(){
		List<Compressor> compressors=Lists.newArrayList();
		for (MachineRoom machineRoom : machineRoomList) {
			List<Compressor> compressorList = machineRoom.getCompressors();
			for (Compressor compressor : compressorList) {
				compressors.add(compressor);
				}
		}
		return compressors;
	}
}
