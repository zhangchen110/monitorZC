package com.flyusoft.apps.jointoil.service;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Index;
/**
 * 指标service接口
 * @author Yanglongquan
 * 2011-9-30
 * yanglongquan@flyu.com
 *
 */
public interface IndexService {
	/**
	 * 查找所有指标
	 * @return
	 */
	public List<Index> getAllIndex();
	/**
	 * 通过appid 去查找指标集合
	 * @param appId
	 * @return
	 */
	public List<String> getAllIndexId(String appId);
	/**
	 * 删除id存在于集合指定的指标
	 * @param _ids
	 */
	public void delete(List<String> _ids);
	/**
	 * 获取指标对象
	 * @param _id
	 * @return
	 */
	public Index getIndex(String _id);
	/**
	 * 通过wellno 查询 想关联指标集合。  
	 */
	public List<Index> getIndexWell(String _no);
}
