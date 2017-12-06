package com.flyusoft.apps.jointoil.service;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;

/**
 * 
 * @author Yanglongquan
 * 2011-9-30
 * yanglongquan@flyu.com
 *
 */
public interface CompressorService {
	/**
	 * 保存与修改压缩机对象
	 */
	public void saveCompressor(Compressor _compressor);

	/**
	 * 删除指定id集合的压缩机
	 * @param _ids
	 */
	public void deleteCompressor(List<String> _ids);

	/**
	 * 获取压缩机对象
	 * @param _id
	 * @return
	 */
	public Compressor getCompressor(String _id);

	/**
	 * 获取所有压缩机对象
	 * @return
	 */
	public List<Compressor> getAllCompressors();

	/**
	 * 通过分页条件及查询条件   获得结果集
	 * @param _page
	 * @param _filters
	 * @return
	 */
	public Page<Compressor> searchCompressor(final Page<Compressor> _page, final List<PropertyFilter> _filters);

	/**
	 * 通过机房Id获取该机房下得压缩机对象
	 * @param roomId
	 * @return
	 * */
	public List<Compressor> getCompressorsByRoomId(String roomId);

	public List<Compressor> searchAllCompressorAndIndex();
}
