package com.flyusoft.apps.jointoil.dao;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.common.dao.BaseDao;

public interface MachineRoomDao extends BaseDao<MachineRoom, String>{
	/** 
	 * 批量删除
	 * @return 删除结果 -1为删除出错,大于0为删除成功
	 */
	public int delete(List<String> ids);
	
	public List<MachineRoom> searchAllMachineRoomAndIndex() ;
}
