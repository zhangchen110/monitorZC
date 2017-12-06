package com.flyusoft.apps.jointoil.dao;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.common.dao.BaseDao;

/**
 * IndexDao接口
 * 
 * @author Yanglongquan 2011-9-16 yanglongquan@flyu.com
 * 
 */
public interface IndexDao extends BaseDao<Index, String> {
	/**
	 * 删除字段appid等于 XXX的所有指标
	 * @param appId
	 */
	public void deleteAllIndex(String appId);
	/**
	 * 获取所有指标并且指标编码与指标名字不重复的
	 * @return
	 */
	public List<Index> getAllIndex();
	/**
	 * 获取字段appid等于XXX的指标集合
	 * @param appId
	 * @return
	 */
	public List<String> getAllIndexId(String appId);
	
	/**
	 * 删除指定id集合的指标
	 * @param _ids
	 * @return
	 */
	public int delete(List<String> _ids);
	/**
	 * 查询WELL  AND INDEX 表中关联信息
	 * @param _ids
	 * @return
	 */
	public List<Index> getIndexWell(String _no);
}
