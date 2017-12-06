package com.flyusoft.apps.jointoil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyusoft.apps.jointoil.dao.CompressorDao;
import com.flyusoft.apps.jointoil.dao.MachineRoomDao;
import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.service.MachineRoomService;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.google.common.collect.Lists;

@Service
@Transactional
public class MachineRoomServiceImpl implements MachineRoomService {
	@Autowired
	private MachineRoomDao machineRoomDao;
	@Autowired
	private CompressorDao compressorDao;

	@Override
	public void saveMachineRoom(MachineRoom _machineRoom) {
		machineRoomDao.save(_machineRoom);
	}

	@Override
	public void deleteMachineRoom(List<String> _ids) {
		int tmp = machineRoomDao.delete(_ids);
		if (tmp == -1) {
			System.out.println("删除IDS集合失败");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public MachineRoom getMachineRoom(String _id) {
		return machineRoomDao.get(_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<MachineRoom> searchMachineRoom(Page<MachineRoom> _page, List<PropertyFilter> _filters) {
		return machineRoomDao.findPage(_page, _filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MachineRoom> findAllMachineRoom() {
		return machineRoomDao.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<MachineRoom> searchAllMachineRoomAndCompressorAndIndex() {
		List<MachineRoom> machineRoomList = machineRoomDao.searchAllMachineRoomAndIndex();
		List<Compressor> compressorList = compressorDao.searchAllCompressorAndIndex();
		for (MachineRoom machineRoom : machineRoomList) {
			List<Compressor> list = Lists.newArrayList();
			for (Compressor compressor : compressorList) {
				if (compressor.getMachineRoom().equals(machineRoom)) {
					list.add(compressor);
				}
			}
			machineRoom.setCompressors(list);
		}
		return machineRoomList;
	}
}
