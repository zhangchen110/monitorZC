package com.flyusoft.apps.jointoil.dao;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.common.dao.BaseDao;

public interface WellDao extends BaseDao<Well, String> {
	/**
	 * 查询含有4项指标的所有井
	 * @return
	 */
	public List<Well> searchWellByMonitor();

	/**
	 * 删除指定id集合的井对象
	 * @param ids
	 * @return
	 */
	public int deleteSql(List<String> ids);

	public List<Well> searchAllWellAndIndex();
}
