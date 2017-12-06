package com.flyusoft.apps.jointoil.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;

import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.IndexService;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.apps.jointoil.util.AlarmUtil;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.utils.XMLConfigReader;
import com.flyusoft.common.utils.reflection.ReflectionUtils;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.flyusoft.components.fusionWidgets.FWColumnData;
import com.flyusoft.components.fusionWidgets.FusionWidgetsManager;
import com.google.common.collect.Lists;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class WellRealTimeMonitorAction extends ActionSupport {

	private static final long serialVersionUID = 6346803849662700056L;

	@Autowired
	private MonitorDataService monitorDataService;
	@Autowired
	private IndexService indexService;// 指标表service
	@Autowired
	private FusionWidgetsManager fusionWidgetsManager;

	private MonitorData monitorData = new MonitorData();

	private Index indexACC = new Index();
	// private Index index;

	public String wellNo;// 默认进入时传递的井号

	public String prexml;

	public String precurveXml;

	public String temxml;

	public String temcurveXml;

	public String datetime;

	public String insxml;// 瞬时流量 仪表盘

	public String inscurveXml;// 瞬时流量曲线图

	public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 查询当前时间信息

	private JointOilInitentity jointOilInitentity = JointOilInitentity
			.getInstance();

	private AlarmUtil alarmUtil = new AlarmUtil();

	private String alarmString = "";

	// http://localhost:8080/flyusofts/wellreal_excute.do?wellNo=36172
	public String excute() throws Exception {// 调用的时候 传值 wellNo
		String wellNo = Struts2Utils.getParameter("wellNo");// wellID

		List<Index> indexList = jointOilInitentity.getWellByWellNo(wellNo)
				.getIndexList();// 查询出来一个井指标表的对象集合
		// 图用的都是一个集合
		monitorData = monitorDataService
				.searchMonitorDataByLastMonitorTime(wellNo);//
		if (monitorData == null) {
			datetime = df.format(new Date());
		} else {
			datetime = df.format(monitorData.getMonitorTime());
		}

		List<MonitorData> curvemonitorDatasList = monitorDataService
				.getMonitorDataByWellIdAndTimeInterval(wellNo, 5);// 取5分钟以前的数据//升序排列第一条时间为最小
		if(monitorData == null){
			addActionMessage("无显示数据");
			return "SUCCESS";
		}
		if(curvemonitorDatasList == null){
			addActionMessage("无显示数据");
			return "SUCCESS";
		}
		for (int i = 0; i < indexList.size(); i++) {
			Index index = indexList.get(i);
			List<FWColumnData> fwcdList = getFWColumnDataList(
					curvemonitorDatasList, index.getIndexCode());
			if (index.getIndexCode().equals("PRE")) {
				boolean tmp=alarmUtil.isAlarming(monitorData.getPressure(), index);
				if(tmp)alarmString+="pre,";
				Document docpre = fusionWidgetsManager.generateSingleWellDialXmlData(
						// 压力仪表盘
						index.getMax().toString(),
						index.getMin().toString(),//最小值
						index.getMaxLimit().toString(), 
						index.getMinLimit().toString(),
						monitorData.getPressure().toString(),
						index.getUnit(),
						"150","300"
				);
				Document curveDocumentpre = fusionWidgetsManager.generateSingleWellCurveXmlData(// 压力曲线
						index.getIndexName(), index.getUnit(), fwcdList);
				prexml = fusionWidgetsManager.toDocString(docpre);
				precurveXml = fusionWidgetsManager.toDocString(curveDocumentpre);
			}
			if (index.getIndexCode().equals("TEM")) {
				boolean tmp=alarmUtil.isAlarming(monitorData.getTemperature(), index);
				
				if(tmp)alarmString+="tem,";
				// 温度计 自己写xml
				Document doctem = fusionWidgetsManager.generateSingleWellThermometerXmlData(
						index.getMax().toString(),
						index.getMin().toString(),//最小值
						index.getMaxLimit().toString(), 
						index.getMinLimit().toString(), 
						monitorData.getTemperature().toString(),// 当前的温度记录数
						index.getUnit(),
						"150","300"
				);
				Document curveDocumenttem = fusionWidgetsManager.generateSingleWellCurveXmlData(// 温度曲线
						index.getIndexName(), index.getUnit(), fwcdList);
				
				temxml = fusionWidgetsManager.toDocString(doctem);
				temcurveXml = fusionWidgetsManager.toDocString(curveDocumenttem);
			}
			if (index.getIndexCode().equals("SJLL")) {
				boolean tmp = alarmUtil.isAlarming(
						monitorData.getInstantaneousFlow(), index);
				if (tmp)
					alarmString += "ins,";
				Document docins = fusionWidgetsManager.generateSingleWellDialXmlData(
				// 瞬时力量柱状
						index.getMax().toString(), index.getMin().toString(),// 最小值
						index.getMaxLimit().toString(), index.getMinLimit()
								.toString(), monitorData.getInstantaneousFlow()
								.toString(), index.getUnit(), "150", "300");

				Document curveDocumentins = fusionWidgetsManager
						.generateSingleWellCurveXmlData(// 瞬时流量曲线
								index.getIndexName(), index.getUnit(), fwcdList);

				insxml = fusionWidgetsManager.toDocString(docins);
				inscurveXml = fusionWidgetsManager
						.toDocString(curveDocumentins);
			}
			if (index.getIndexCode().equals("LJLL")) {
				indexACC = index;
			}
		}
		return "SUCCESS";
	}

	/**
	 * AJAX调用
	 * 
	 * @return
	 * @throws Exception
	 */
	public String realTimeCurve() throws Exception {
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");
		String wellNo = Struts2Utils.getParameter("wellNo");// wellID
		Well well = jointOilInitentity.getWellByWellNo(wellNo);
		List<Index> indexList = new ArrayList<Index>();
		if (well != null) {
			indexList = well.getIndexList();
		}
		MonitorData mdData = null;
		String str = "";
		String alarm = "no";
		if (wellNo != null) {
			mdData = monitorDataService
					.searchMonitorDataByLastMonitorTime(wellNo);
		}
		if(mdData==null){//无数据不执行 //jsp中ajax方法判断
			Struts2Utils.renderText("isnull");
			return null;
		}
		for (Index index : indexList) {// 判断报警
			if (index.getStatus() == 0) {
				String fieldName = reader.getTextFromPath("//method", "name",
						index.getIndexCode());
				Object value = ReflectionUtils.getFieldValue(mdData, fieldName);
				boolean tmp = alarmUtil.isAlarming((Double) value, index);
				if (tmp)
					alarm += "_" + index.getIndexCode();
			}
		}
		str = mdData.getWellNo() + "," + mdData.getTemperature().toString()
				+ "," + mdData.getPressure().toString() + ","
				+ mdData.getInstantaneousFlow().toString() + ","
				+ mdData.getAccumulativeFlow() + "," + "" + ","
				+ df.format(mdData.getMonitorTime()) + "," + alarm;// 不显示时间
		Struts2Utils.renderText(str);
		return null;
	}

	/**
	 * 生成图形需要List<FWColumnData>
	 * 
	 * @param _monitorDatas
	 * @param _indexCode
	 * @return
	 */
	public List<FWColumnData> getFWColumnDataList(
			List<MonitorData> _monitorDatas, String _indexCode) {
		List<FWColumnData> fwcdList = Lists.newArrayList();
		for (MonitorData md : _monitorDatas) {
			String formatString = df.format(md.getMonitorTime());
			formatString = "";
			if (_indexCode != null) {
				if (_indexCode.equals("TEM")) {
					FWColumnData fwcd = new FWColumnData(formatString, md
							.getTemperature().toString());
					fwcdList.add(fwcd);
				}
				if (_indexCode.equals("PRE")) {
					FWColumnData fwcd = new FWColumnData(formatString, md
							.getPressure().toString());
					fwcdList.add(fwcd);
				}
				if (_indexCode.equals("SJLL")) {
					FWColumnData fwcd = new FWColumnData(formatString, md
							.getInstantaneousFlow().toString());
					fwcdList.add(fwcd);
				}
				if (_indexCode.equals("LJLL")) {
					FWColumnData fwcd = new FWColumnData(formatString, md
							.getAccumulativeFlow().toString());
					fwcdList.add(fwcd);
				}
			}
		}
		return fwcdList;
	}

	public String getWellNo() {
		return wellNo;
	}

	public void setWellNo(String wellNo) {
		this.wellNo = wellNo;
	}

	public String getPrexml() {
		return prexml;
	}

	public void setPrexml(String prexml) {
		this.prexml = prexml;
	}

	public String getPrecurveXml() {
		return precurveXml;
	}

	public void setPrecurveXml(String precurveXml) {
		this.precurveXml = precurveXml;
	}

	public String getTemxml() {
		return temxml;
	}

	public void setTemxml(String temxml) {
		this.temxml = temxml;
	}

	public String getTemcurveXml() {
		return temcurveXml;
	}

	public void setTemcurveXml(String temcurveXml) {
		this.temcurveXml = temcurveXml;
	}

	public String getInsxml() {
		return insxml;
	}

	public void setInsxml(String insxml) {
		this.insxml = insxml;
	}

	public String getInscurveXml() {
		return inscurveXml;
	}

	public void setInscurveXml(String inscurveXml) {
		this.inscurveXml = inscurveXml;
	}

	public MonitorData getMonitorData() {
		return monitorData;
	}

	public Index getIndexACC() {
		return indexACC;
	}

	public void setIndexACC(Index indexACC) {
		this.indexACC = indexACC;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getAlarmString() {
		return alarmString;
	}

}
