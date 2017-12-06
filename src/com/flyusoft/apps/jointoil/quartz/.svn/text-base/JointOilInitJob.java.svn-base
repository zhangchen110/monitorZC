package com.flyusoft.apps.jointoil.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.MachineRoomService;
import com.flyusoft.apps.jointoil.service.WellService;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;

public class JointOilInitJob {

	@Autowired
	private WellService wellService;
	@Autowired
	private MachineRoomService machineRoomService;
	 

	public void execute() {
		List<Well> wellList = wellService.searchAllWellAndIndex();
		List<MachineRoom> machineRoomList = machineRoomService
				.searchAllMachineRoomAndCompressorAndIndex();
		JointOilInitentity jointOilInitentity = JointOilInitentity
				.getInstance();
		jointOilInitentity.setWellList(wellList);
		jointOilInitentity.setMachineRoomList(machineRoomList);
		for (Well well : wellList) {
			well.getIndexList();
		}
	}
}
