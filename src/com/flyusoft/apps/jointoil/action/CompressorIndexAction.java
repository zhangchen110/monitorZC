package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.service.CompressorService;
import com.flyusoft.apps.jointoil.service.IndexService;
import com.flyusoft.apps.jointoil.service.MachineRoomService;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.action.CrudActionSupport;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.google.common.collect.Lists;

@Controller
@Scope("prototype")
public class CompressorIndexAction extends CrudActionSupport<Index> {

	private static final long serialVersionUID = 1829968134573595197L;

	private Index index;

	private String compressorId;
	@Autowired
	private CompressorService compressorService;
	@Autowired
	private MachineRoomService machineRoomService;
	@Autowired
	private IndexService indexService;
	private Compressor compressor;

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
	private JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();

	@Override
	public Index getModel() {
		return index;
	}

	@Override
	public String list() throws Exception {
		compressorId = Struts2Utils.getParameter("compressorId");
		compressor = compressorService.getCompressor(compressorId);
		if (compressor != null) {
			indexList = compressor.getComIndexs();
		}
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {

		return INPUT;
	}

	@Override
	public String save() throws Exception {
		compressor = compressorService.getCompressor(compressorId);
		List<Index> newIndexList = Lists.newArrayList();
		List<String> deleteIdList = Lists.newArrayList();// 需要删除的指标id集合
		boolean isNull = indexIdList != null && indexNameList != null&& orderByList != null
				&& indexCodeList != null;
				
		if (isNull) {
			List<Index> oldIndexs = compressor.getComIndexs();// 查找以前所有的指标
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
				tmpindex.setCompressor(compressor);
				newIndexList.add(tmpindex);
			}
		}
		compressor.setComIndexs(newIndexList);
		compressorService.saveCompressor(compressor);
		addActionMessage("保存成功");
		jointOilInitentity.setMachineRoomList(machineRoomService.searchAllMachineRoomAndCompressorAndIndex());
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
	}

	public String getCompressorId() {
		return compressorId;
	}

	public void setCompressorId(String compressorId) {
		this.compressorId = compressorId;
	}

	public List<Index> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<Index> indexList) {
		this.indexList = indexList;
	}

	public void setIndexIdList(List<String> indexIdList) {
		this.indexIdList = indexIdList;
	}

	public void setIndexNameList(List<String> indexNameList) {
		this.indexNameList = indexNameList;
	}

	public void setMaxList(List<Double> maxList) {
		this.maxList = maxList;
	}
	public void setMinList(List<Double> minList) {
		this.minList = minList;
	}

	public void setUnitList(List<String> unitList) {
		this.unitList = unitList;
	}

	public void setIndexCodeList(List<String> indexCodeList) {
		this.indexCodeList = indexCodeList;
	}
	public void setMinLimitList(List<Double> minLimitList) {
		this.minLimitList = minLimitList;
	}

	public void setMaxLimitList(List<Double> maxLimitList) {
		this.maxLimitList = maxLimitList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	public void setOrderByList(List<Integer> orderByList) {
		this.orderByList = orderByList;
	}
	
}
