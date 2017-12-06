package com.flyusoft.apps.jointoil.dao;

import java.util.Date;

import com.flyusoft.common.dao.BaseDao;

/**
 * 每月删除所有记录
 * @author Administrator
 *
 */
public interface DeleteMsgByMonthDao extends BaseDao{
	public void delteMsg(Date _dTime);
}
