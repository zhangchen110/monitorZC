package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AppAction extends ActionSupport {

	private static final long serialVersionUID = -1340416531719494300L;
	
	private List<Well> wellList;
	
	private List<MachineRoom> machineRoomList;
	
	public String execute() {
		JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();
		wellList=jointOilInitentity.getWellList();
		machineRoomList=jointOilInitentity.getMachineRoomList();
		return "success";
	}
	public List<Well> getWellList() {
		return wellList;
	}
	public List<MachineRoom> getMachineRoomList() {
		return machineRoomList;
	}
	
}
