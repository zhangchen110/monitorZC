package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.service.CompressorService;
import com.flyusoft.apps.jointoil.service.MachineRoomService;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.action.CrudActionSupport;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.google.common.collect.Lists;

@Controller
@Scope("prototype")
public class CompressorAction extends CrudActionSupport<Compressor> {

	private static final long serialVersionUID = -1054713032698360047L;

	private Compressor compressor;
	private String id;
	private List<String> ids;
	private Page<Compressor> page = new Page<Compressor>(15);
	private List<Compressor> compressorList=Lists.newArrayList();
	@Autowired
	private CompressorService compressorService;
	@Autowired
	private MachineRoomService machineRoomService;
	
	private List<MachineRoom> machineRoomList=Lists.newArrayList();
	
	private String roomId;
	
	private JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();

	@Override
	public Compressor getModel() {
		return compressor;
	}

	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter
				.buildFromHttpRequest(Struts2Utils.getRequest());
		// 设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = compressorService.searchCompressor(page, filters);
		return SUCCESS;
	}
	public String grapMachineRoom(){
		compressorList=compressorService.getAllCompressors();
		return "grapmachine";
	}

	@Override
	public String input() throws Exception {
		machineRoomList=machineRoomService.findAllMachineRoom();
		return INPUT;
	}

	@Override
	public String save() throws Exception {
		try {
			if(roomId!=null&&!roomId.equals(""))
			{
				compressor.setMachineRoom(machineRoomService.getMachineRoom(roomId));
			}
			compressorService.saveCompressor(compressor);
			jointOilInitentity.setMachineRoomList(machineRoomService.searchAllMachineRoomAndCompressorAndIndex());
			addActionMessage("保存成功");
		} catch (ConstraintViolationException e) {
			addActionMessage("保存失败");
		}

		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			compressorService.deleteCompressor(ids);
			addActionMessage("删除成功");
		} catch (Exception e) {
			addActionMessage("删除失败");
		}

		return RELOAD;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null && !id.equals("")) {
			compressor = compressorService.getCompressor(id);
			if(compressor.getMachineRoom()!=null){
				roomId=compressor.getMachineRoom().getId();
			}
		} else {
			compressor = new Compressor();
		}

	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Page<Compressor> getPage() {
		return page;
	}

	public List<MachineRoom> getMachineRoomList() {
		return machineRoomList;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public List<Compressor> getCompressorList() {
		return compressorList;
	}
	
	
}
