package com.flyusoft.apps.jointoil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.IndexDao;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.service.IndexService;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexDao indexDao;

	@Override
	@Transactional(readOnly = true)
	public List<Index> getAllIndex() {
		return indexDao.getAllIndex();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<String> getAllIndexId(String appId) {
		return indexDao.getAllIndexId(appId);
	}
	
	@Override
	public void delete(List<String> _ids) {
		int tmp=indexDao.delete(_ids);
		if(tmp==-1)
		{
			System.out.println("删除Index_Ids集合失败");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Index getIndex(String _id) {
		return indexDao.get(_id);
	}

	@Override
	public List<Index> getIndexWell(String _no) {
		return indexDao.getIndexWell(_no) ;
	}

}
