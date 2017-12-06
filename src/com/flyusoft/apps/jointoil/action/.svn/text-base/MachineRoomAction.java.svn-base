package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.service.MachineRoomService;
import com.flyusoft.common.action.CrudActionSupport;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;

@Controller
@Scope("prototype")
public class MachineRoomAction extends CrudActionSupport<MachineRoom> {

	private static final long serialVersionUID = -1054713032698360047L;

	private MachineRoom machineRoom;
	private String id;
	private List<String> ids;
	private Page<MachineRoom> page = new Page<MachineRoom>(10);
	@Autowired
	private MachineRoomService machineRoomService;

	@Override
	public MachineRoom getModel() {
		return machineRoom;
	}

	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		// 设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = machineRoomService.searchMachineRoom(page, filters);
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	public String save() throws Exception {
		try {
			machineRoomService.saveMachineRoom(machineRoom);
			addActionMessage("保存成功");
		} catch (ConstraintViolationException e) {
			addActionMessage("保存失败");
		}

		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			machineRoomService.deleteMachineRoom(ids);
			addActionMessage("删除成功");
		} catch (Exception e) {
			addActionMessage("删除失败");
		}

		return RELOAD;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null && !id.equals("")) {
			machineRoom = machineRoomService.getMachineRoom(id);
		} else {
			machineRoom = new MachineRoom();
		}

	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Page<MachineRoom> getPage() {
		return page;
	}

}
