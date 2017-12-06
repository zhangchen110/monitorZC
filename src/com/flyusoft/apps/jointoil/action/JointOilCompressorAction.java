package com.flyusoft.apps.jointoil.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import com.flyusoft.apps.jointoil.entity.CompressorMD;
import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.CompressorService;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.apps.jointoil.util.GainCompressorData;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.utils.XMLConfigReader;
import com.flyusoft.common.utils.reflection.ReflectionUtils;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class JointOilCompressorAction extends ActionSupport {

	private static final long serialVersionUID = 2849143461171796370L;
	private List<Compressor> compressorList;
	@Autowired
	private CompressorService compressorService;
	@Autowired
	private GainCompressorData gainCompressorData;
	@Autowired
	private MonitorDataService monitorDataService;
	private List<Well> wellList;
	private JointOilInitentity jointOilInitentity = JointOilInitentity
			.getInstance();

	@Override
	public String execute() throws Exception {
		/** 压缩机 **/
		compressorList = jointOilInitentity.getAllCompressor();
		/** 油井 **/
		wellList = jointOilInitentity.getWellList();
		return SUCCESS;
	}

	public String realTime() throws Exception {

		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");
		/** 油井 **/
		List<Well> wellList = jointOilInitentity.getWellList();
		List<MonitorData> allLastMonitorDatas = monitorDataService
				.searchAllWellLastTimeMonitorData(wellList.size());// 获取所有井的最后一条数据
		String str = "";
		for (Well well : wellList) {
			str += well.getWellNo();
			str += "_" + well.getStatus();
			str += ",";
		}
		str = str.substring(0, str.length() - 1);
		str += ";";

		/** 压缩机 **/
		compressorList = jointOilInitentity.getAllCompressor();
		for (Compressor compressor : compressorList) {
			str += compressor.getCompressorCode() + "_";
			str += compressor.getState() + ",";

		}
		Struts2Utils.renderText(str);
		return null;
	}

	public List<Compressor> getCompressorList() {
		return compressorList;
	}

	/**
	 * 获取最后一个对象
	 * 
	 * @param _wellNo井号
	 * @param _allLastMonitorDatas所有井的最后一个实时数据
	 * @return
	 */
	private MonitorData getLastTimeMonitorData(String _wellNo,
			List<MonitorData> _allLastMonitorDatas) {
		MonitorData monitorData = monitorDataService.getLastTimeMonitorData(
				_wellNo, _allLastMonitorDatas);// 先从集合中读取
		if (monitorData == null) {
			monitorData = monitorDataService
					.searchMonitorDataByLastMonitorTime(_wellNo);
		}
		return monitorData;
	}

	// 判断
	private boolean isAlarming(Double value, Index index) {
		if (index.getStatus().intValue() == 0) {
			return (value <= index.getMinLimit() || value >= index
					.getMaxLimit()) ? true : false;
		} else {
			return false;
		}
	}

	public List<Well> getWellList() {
		return wellList;
	}

}
