package com.flyusoft.apps.jointoil.service;

import java.util.List;

import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
/**
 * 井service接口
 * @author Yanglongquan
 * 2011-9-30
 * yanglongquan@flyu.com
 *
 */

public interface WellService {
	/**
	 * 查询含有4项指标的所有井
	 * @return
	 */
	public List<Well> searchWellByMonitor();
	/**
	 * 通过井id获取井对象
	 * @param id
	 * @return
	 */
	public Well getWell(String id);
	/**
	 * 修改和保存井对象
	 * @param well
	 */
	public void saveWell(Well well);
	/**
	 * 删除指定id集合的井对象
	 * @param ids
	 */
	public void deleteWell(List<String> ids);
	/**
	 * 通过分页与查询条件 来获取结果集
	 * @param page
	 * @param filters
	 * @return
	 */
	public Page<Well> searchWell(final Page<Well> page,
			final List<PropertyFilter> filters);
	/**
	 * 保存指标
	 * @param index
	 */
	public void saveIndex(Index index);
	/**
	 * 删除指定id集合的指标对象
	 * @param ids
	 */
	public void deleteIndex(List<String> ids);
	/**
	 * 删除等于appid的指标对象
	 * @param appId
	 */
	public void deleteAllIndex(String appId);
	/**
	 * 查询所有井 ，安装井号升序排序
	 * @return
	 */
	public List<Well> getAllWell();
	
	public List<Well> searchAllWellAndIndex();
}
