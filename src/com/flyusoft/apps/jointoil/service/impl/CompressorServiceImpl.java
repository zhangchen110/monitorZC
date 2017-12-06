package com.flyusoft.apps.jointoil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.CompressorDao;
import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.CompressorService;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

@Service
@Transactional
public class CompressorServiceImpl implements CompressorService {
	@Autowired
	private CompressorDao compressorDao;

	@Override
	public void saveCompressor(Compressor _compressor) {
		compressorDao.save(_compressor);
	}

	@Override
	public void deleteCompressor(List<String> _ids) {
		int tmp = compressorDao.delete(_ids);
		if (tmp == -1) {
			System.out.println("删除IDS集合失败");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Compressor getCompressor(String _id) {
		return compressorDao.get(_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Compressor> searchCompressor(Page<Compressor> _page, List<PropertyFilter> _filters) {
		return compressorDao.findPage(_page, _filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compressor> getAllCompressors() {
		return compressorDao.getAll("compressorCode", true);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compressor> getCompressorsByRoomId(String roomId) {
		return compressorDao.searchcompreCompressorByRoomId(roomId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compressor> searchAllCompressorAndIndex() {
		return compressorDao.searchAllCompressorAndIndex();
	}

}
