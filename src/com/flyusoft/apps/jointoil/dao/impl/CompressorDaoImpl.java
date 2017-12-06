package com.flyusoft.apps.jointoil.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.CompressorDao;
import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;

@Repository
public class CompressorDaoImpl extends BaseHibernateDaoImpl<Compressor, String>
		implements CompressorDao {

	// 批量删除HQL语句
	private static final String BATCH_DELETE_EMPLOYMENTPLAN = "delete Compressor c where c.id in (:ids)";
	private static final String BATCH_SELECT_BYROOMID = "from Compressor c where c.machineRoom.id = ?";
	private static final String QUERY_ALL_COMPRESSOR_AND_INDEX = "from Compressor c left join fetch c.comIndexs order by c.compressorCode ";

	/**
	 * 批量删除
	 * 
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
	public List<Compressor> searchcompreCompressorByRoomId(String Roomid) {
		return find(BATCH_SELECT_BYROOMID, Roomid);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Compressor> searchAllCompressorAndIndex() {
		return distinct(createQuery(QUERY_ALL_COMPRESSOR_AND_INDEX)).list();
	}

}
