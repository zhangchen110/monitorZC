package com.flyusoft.apps.jointoil.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.DeleteMsgByMonthDao;
import com.flyusoft.apps.jointoil.service.DeleteMsgByMonthService;

@Service
@Transactional
public class DeleteMsgByMonthServiceImpl implements DeleteMsgByMonthService{
	@Autowired
	private DeleteMsgByMonthDao dao;
	
	@Override
	public void deleteAllMsg(Date _dTime) {
		dao.delteMsg(_dTime);
	}

}
