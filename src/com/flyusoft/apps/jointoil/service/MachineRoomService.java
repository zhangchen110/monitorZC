package com.flyusoft.apps.jointoil.service;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

/**
 * 机房业务
 * @author Yanglongquan
 * 2011-9-27
 * yanglongquan@flyu.com
 *
 */
public interface MachineRoomService {
	/**
	 * 保存与修改一个机房对象
	 * @param _machineRoom
	 */
	public void saveMachineRoom(MachineRoom _machineRoom);
	/**
	 * 删除一个机房对象
	 * @param _ids
	 */
	public void deleteMachineRoom(List<String> _ids);
	/**
	 * 获取一个机房对象
	 * @param _id
	 * @return
	 */
	public MachineRoom getMachineRoom(String _id);
	/**
	 * 通过分页条件查找机房
	 * @param _page
	 * @param _filters
	 * @return
	 */
	public Page<MachineRoom> searchMachineRoom(final Page<MachineRoom> _page,
			final List<PropertyFilter> _filters);
	/**
	 * 查找所有机房
	 * @return
	 */
	public List<MachineRoom> findAllMachineRoom();
	
	public List<MachineRoom> searchAllMachineRoomAndCompressorAndIndex();
}
