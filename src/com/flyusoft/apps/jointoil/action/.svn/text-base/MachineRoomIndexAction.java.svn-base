package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MachineRoom;
import com.flyusoft.apps.jointoil.service.CompressorService;
import com.flyusoft.apps.jointoil.service.IndexService;
import com.flyusoft.apps.jointoil.service.MachineRoomService;
import com.flyusoft.apps.jointoil.service.WellService;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.action.CrudActionSupport;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.google.common.collect.Lists;

@Controller
@Scope("prototype")
public class MachineRoomIndexAction extends CrudActionSupport<Index>{
	
	private JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();
	private static final long serialVersionUID = 1829968134573595197L;

	private Index index;

	private String machineRoomId;
	@Autowired
	private MachineRoomService machineRoomService;
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private WellService wellService;
	
	private MachineRoom machineRoom;

	private List<Index> indexList;

	private List<String> indexIdList;
	private List<String> indexNameList;
	private List<String> indexCodeList;
	private List<String> unitList;
	private List<Integer> statusList;
	private List<Double> maxList;
	private List<Double> minList;
	private List<Double> minLimitList;
	private List<Double> maxLimitList;
	private List<Integer> orderByList;
	
	@Override
	public Index getModel() {
		return index;
	}

	@Override
	public String list() throws Exception {
		machineRoomId = Struts2Utils.getParameter("roomId");
		machineRoom = machineRoomService.getMachineRoom(machineRoomId);
		if (machineRoom != null) {
			indexList = machineRoom.getIndexs();
		}
		return SUCCESS;
	}

	@Override
	public String save() throws Exception {
		MachineRoom machineRoom = machineRoomService.getMachineRoom(machineRoomId);
		List<Index> newIndexList = Lists.newArrayList();
		List<String> deleteIdList = Lists.newArrayList();// 需要删除的指标id集合
		boolean isNull = indexIdList != null && indexNameList != null&& orderByList != null
				&& indexCodeList != null;
				
		if (isNull) {
			List<Index> oldIndexs = machineRoom.getIndexs();// 查找以前所有的指标
			if (oldIndexs != null) {
				for (Index oldIndex : oldIndexs) {
					boolean isHave = indexIdList.contains(oldIndex.getId());
					if (!isHave) {
						deleteIdList.add(oldIndex.getId());
					}
				}
			}
			if (deleteIdList.size() > 0) {
				indexService.delete(deleteIdList);// 删除所有前台不包含的指标ID
			}
			for (int i = 0; i < indexNameList.size(); i++) {
				Index tmpindex = null;
				if (indexIdList.get(i) != null
						&& !"".equals(indexIdList.get(i))) {
					tmpindex = indexService.getIndex(indexIdList.get(i));
				} else {
					tmpindex = new Index();
				}
				tmpindex.setIndexName(indexNameList.get(i));
				tmpindex.setIndexCode(indexCodeList.get(i));
				tmpindex.setUnit(unitList.get(i));
				tmpindex.setStatus(statusList.get(i));
				tmpindex.setOrderBy(orderByList.get(i));
				if(statusList.get(i)==0){
					tmpindex.setMax(maxList.get(i));
					tmpindex.setMin(minList.get(i));
					tmpindex.setMaxLimit(maxLimitList.get(i));
					tmpindex.setMinLimit(minLimitList.get(i));
				}else{
					tmpindex.setMax(null);
					tmpindex.setMin(null);
					tmpindex.setMaxLimit(null);
					tmpindex.setMinLimit(null);
				}
				tmpindex.setRoom(machineRoom);
				wellService.saveIndex(tmpindex);
				newIndexList.add(tmpindex);
			}
		}
		//machineRoom.setIndexs(newIndexList);
		
		//machineRoomService.saveMachineRoom(machineRoom);
		addActionMessage("保存成功");
		jointOilInitentity.setMachineRoomList(machineRoomService.searchAllMachineRoomAndCompressorAndIndex());
		return RELOAD;
	}
	@Override
	public String input() throws Exception {
		return INPUT;
	}


	@Override
	public String delete() throws Exception {
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
	}

	public String getMachineRoomId() {
		return machineRoomId;
	}

	public void setMachineRoomId(String machineRoomId) {
		this.machineRoomId = machineRoomId;
	}

	public List<Index> getIndexList() {
		return indexList;
	}

	public void setIndexIdList(List<String> indexIdList) {
		this.indexIdList = indexIdList;
	}

	public void setIndexNameList(List<String> indexNameList) {
		this.indexNameList = indexNameList;
	}

	public void setIndexCodeList(List<String> indexCodeList) {
		this.indexCodeList = indexCodeList;
	}

	public void setUnitList(List<String> unitList) {
		this.unitList = unitList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	public void setMaxList(List<Double> maxList) {
		this.maxList = maxList;
	}

	public void setMinList(List<Double> minList) {
		this.minList = minList;
	}

	public void setMinLimitList(List<Double> minLimitList) {
		this.minLimitList = minLimitList;
	}

	public void setMaxLimitList(List<Double> maxLimitList) {
		this.maxLimitList = maxLimitList;
	}

	public void setOrderByList(List<Integer> orderByList) {
		this.orderByList = orderByList;
	}
	
	
}
