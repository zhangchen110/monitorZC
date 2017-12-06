package com.flyusoft.apps.jointoil.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.flyusoft.apps.jointoil.dao.IndexDao;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.common.dao.impl.BaseHibernateDaoImpl;
import com.google.common.collect.Lists;

/**
 * IndexDao实现类
 * 
 * @author Yanglongquan 2011-9-16 yanglongquan@flyu.com
 * 
 */
@Repository
public class IndexDaoImpl extends BaseHibernateDaoImpl<Index, String> implements
		IndexDao {
	//批量删除HQL语句
	private static final String BATCH_DELETE_INDEXS = "delete Index i where i.id in (:ids)";
	
	private static final String QUERY_INDEX_All = "select distinct i.index_code,i.index_name from monitor_index i";

	private static final String BATCH_DELETE_INDEX = "delete i from monitor_index i where i.app_id=?";

	private static final String QUERY_ALL_INDEX = "select i.id from monitor_index i where i.app_id = ?";
	
	private static final String QUERY_ALL_INDEX_WELL = "select m.* from monitor_index m , fly_well  f where   f.id=m.app_id and f.well_no = ?";

	@SuppressWarnings("unchecked")
	@Override
	public List<Index> getAllIndex() {
		List<Object[]> list = createSQLQuery(QUERY_INDEX_All).list();
		List<Index> indexList = Lists.newArrayList();
		for (Object[] obj : list) {
			Index index = new Index();
			index.setIndexCode((String) obj[0]);
			index.setIndexName((String) obj[1]);
			indexList.add(index);
		}
		return indexList;
	}

	@Override
	public void deleteAllIndex(String appId) {
		Query query = createSQLQuery(BATCH_DELETE_INDEX, appId);
		if (appId != null && !"".equals(appId)) {
			query.executeUpdate();
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllIndexId(String appId) {
		return createSQLQuery(QUERY_ALL_INDEX, appId).list();
	}

	@Override
	public int delete(List<String> ids) {
		Query query = getSession().createQuery(BATCH_DELETE_INDEXS);
		if (ids != null && ids.size() > 0) {
			return query.setParameterList("ids", ids).executeUpdate();
		} else {
			return -1;
		}
	}

	@Override
	public List<Index> getIndexWell(String _no) {
		return  createSQLQuery(QUERY_ALL_INDEX_WELL, _no).addEntity(Index.class).list();
	}

}
