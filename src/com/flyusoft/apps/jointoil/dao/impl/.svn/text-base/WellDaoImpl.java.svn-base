package com.flyusoft.apps.jointoil.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.WellDao;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;

@Repository
public class WellDaoImpl extends BaseHibernateDaoImpl<Well, String> implements WellDao {

	private static final String QUERY_WELL_BY_MONITOR = "from Well w where size(w.indexList) = 4";
	private static final String BATCH_DELETE_WELL = "delete Well t where t.id in (:ids)";
	private static final String QUERY_ALL_WELL_AND_INDEX = "from Well well left join fetch well.indexList order by well.wellNo";

	@Override
	public List<Well> searchWellByMonitor() {
		return find(QUERY_WELL_BY_MONITOR);
	}

	@Override
	public int deleteSql(List<String> ids) {
		Query query = getSession().createQuery(BATCH_DELETE_WELL);
		if (ids != null && ids.size() > 0) {
			return query.setParameterList("ids", ids).executeUpdate();
		} else {
			return -1;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Well> searchAllWellAndIndex() {
		return distinct(createQuery(QUERY_ALL_WELL_AND_INDEX)).list();
	}

}
