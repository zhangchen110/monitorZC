package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.IndexService;
import com.flyusoft.apps.jointoil.service.WellService;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.action.CrudActionSupport;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.google.common.collect.Lists;

@Controller
@Scope("prototype")
public class WellAction extends CrudActionSupport<Well> {

	private static final long serialVersionUID = 1829968134573595197L;

	private String id;
	private List<String> ids;
	private Page<Well> page = new Page<Well>(5);

	@Autowired
	private WellService wellService;
	@Autowired
	private IndexService indexService;

	private Well well;

	private List<String> indexIds;
	private List<String> indexNames;
	private List<Double> maxs;
	private List<Double> mins;
	private List<Double> minLimitList;
	private List<Double> maxLimitList;
	private List<String> units;
	private List<String> indexCodes;
	private List<Integer> statusList;
	private JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();
	
	@Override
	public Well getModel() {
		return well;
	}

	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		// 设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = wellService.searchWell(page, filters);
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	public String save() throws Exception {
		wellService.saveWell(well);
		boolean isNull = indexIds != null && indexNames != null && maxs != null && mins != null && minLimitList != null
				&& maxLimitList != null && statusList != null && units != null && indexCodes != null;
		if (isNull) {
			List<String> deleteIdList = Lists.newArrayList();// 需要删除的指标id集合
			List<String> indexIdList = indexService.getAllIndexId(well.getId());
			for (String indexId : indexIdList) {
				if (!indexIds.contains(indexId)) {
					deleteIdList.add(indexId);
				}
			}
			if (deleteIdList.size() > 0) {
				wellService.deleteIndex(deleteIdList);// 删除所有前台为包含的指标ID
			}
			if (indexNames.size() > 0) {
				for (int i = 0; i < indexNames.size(); i++) {
					Index index = null;
					if (indexIds.get(i) != null && !"".equals(indexIds.get(i))) {
						index = indexService.getIndex(indexIds.get(i));
					} else {
						index = new Index();
					}
					index.setIndexName(indexNames.get(i));
					index.setIndexCode(indexCodes.get(i));
					index.setUnit(units.get(i));
					index.setStatus(statusList.get(i));
					if (statusList.get(i) == 0) {//判断如果有警报指标 加入限制
						index.setMax(maxs.get(i));
						index.setMin(mins.get(i));
						index.setMaxLimit(maxLimitList.get(i));
						index.setMinLimit(minLimitList.get(i));
					} else {//如果没有则写了也放入null值
						index.setMax(null);
						index.setMin(null);
						index.setMaxLimit(null);
						index.setMinLimit(null);
					}
					index.setWell(well);
					wellService.saveIndex(index);
				}

			}
		}
		wellService.saveWell(well);
		jointOilInitentity.setWellList(wellService.searchAllWellAndIndex());
		addActionMessage("保存成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			wellService.deleteWell(ids);
			addActionMessage("删除成功");
		} catch (Exception e) {
			addActionMessage("删除失败");
		}
		return RELOAD;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null && !"".equals(id)) {
			well = wellService.getWell(id);
		} else {
			well = new Well();
		}

	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Page<Well> getPage() {
		return page;
	}

	public void setIndexNames(List<String> indexNames) {
		this.indexNames = indexNames;
	}

	public void setMaxs(List<Double> maxs) {
		this.maxs = maxs;
	}

	public void setMins(List<Double> mins) {
		this.mins = mins;
	}

	public void setUnits(List<String> units) {
		this.units = units;
	}

	public void setIndexCodes(List<String> indexCodes) {
		this.indexCodes = indexCodes;
	}

	public void setIndexIds(List<String> indexIds) {
		this.indexIds = indexIds;
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

}
