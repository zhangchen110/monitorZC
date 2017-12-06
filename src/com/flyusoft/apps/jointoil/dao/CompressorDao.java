package com.flyusoft.apps.jointoil.dao;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.common.dao.BaseDao;

public interface CompressorDao extends BaseDao<Compressor, String> {
	/** 
	 * 批量删除
	 * @return 删除结果 -1为删除出错,大于0为删除成功
	 */
	public int delete(List<String> ids);

	public List<Compressor> searchcompreCompressorByRoomId(String Roomid);

	public List<Compressor> searchAllCompressorAndIndex();
}
