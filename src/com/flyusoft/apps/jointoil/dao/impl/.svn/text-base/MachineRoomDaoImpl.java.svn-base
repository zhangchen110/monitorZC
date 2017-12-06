package com.flyusoft.apps.jointoil.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.flyusoft.apps.jointoil.dao.MachineRoomDao;
import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;

@Repository
public class MachineRoomDaoImpl extends BaseHibernateDaoImpl<MachineRoom, String> implements MachineRoomDao {

	//批量删除HQL语句
	private static final String BATCH_DELETE_EMPLOYMENTPLAN = "delete MachineRoom m where m.id in (:ids)";

	private static final String QUERY_ALL_MACHINEROOM_AND_INDEX = "from MachineRoom c left join fetch c.indexs order by c.roomNo ";

	/** 
	 * 批量删除
	 * @return 删除结果 -1为删除出错,大于0为删除成功
	 */
	@Override
	public int delete(List<String> ids) {
		Query query = getSession().createQuery(BATCH_DELETE_EMPLOYMENTPLAN);
		if (ids != null && ids.size() > 0) {
			return query.setParameterList("ids", ids).executeUpdate();
		} else {
			return -1;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MachineRoom> searchAllMachineRoomAndIndex() {
		return distinct(createQuery(QUERY_ALL_MACHINEROOM_AND_INDEX)).list();
	}
}
