package com.flyusoft.apps.jointoil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.IndexDao;
import com.flyusoft.apps.jointoil.dao.WellDao;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.WellService;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

@Service
@Transactional
public class WellServiceImpl implements WellService {

	@Autowired
	private WellDao wellDao;
	@Autowired
	private IndexDao indexDao;

	@Override
	@Transactional(readOnly = true)
	public List<Well> searchWellByMonitor() {
		return wellDao.searchWellByMonitor();
	}

	@Override
	public void saveWell(Well well) {
		wellDao.save(well);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Well> getAllWell() {
		return wellDao.getAll("wellNo", true);
	}

	/**
	 * 获取井
	 */
	@Override
	@Transactional(readOnly = true)
	public Well getWell(String id) {
		return wellDao.get(id);
	}

	@Override
	public void deleteWell(List<String> ids) {
		if (ids != null) {
			for (String id : ids) {
				wellDao.delete(id);
			}
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Page<Well> searchWell(Page<Well> page, List<PropertyFilter> filters) {
		return wellDao.findPage(page, filters);
	}

	@Override
	public void saveIndex(Index index) {
		indexDao.save(index);

	}

	@Override
	public void deleteAllIndex(String appId) {
		indexDao.deleteAllIndex(appId);

	}

	@Override
	public void deleteIndex(List<String> ids) {
		if (ids != null) {
			for (String id : ids) {
				indexDao.delete(id);
			}
		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<Well> searchAllWellAndIndex() {
		return wellDao.searchAllWellAndIndex();
	}

}
