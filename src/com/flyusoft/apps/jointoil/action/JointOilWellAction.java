package com.flyusoft.apps.jointoil.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;

import com.flyusoft.apps.jointoil.entity.Index;
import com.flyusoft.apps.jointoil.entity.MonitorData;
import com.flyusoft.apps.jointoil.entity.Well;
import com.flyusoft.apps.jointoil.service.MonitorDataService;
import com.flyusoft.apps.jointoil.service.WellService;
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
public class JointOilWellAction extends ActionSupport {

	private static final long serialVersionUID = 7822883152813737284L;

	public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private FusionWidgetsManager fusionWidgetsManager;
	@Autowired
	private WellService wellService;
	@Autowired
	private MonitorDataService monitorDataService;

	private List<Well> wellList;

	private String timeInterval;

	private Well well;
	private JointOilInitentity jointOilInitentity=JointOilInitentity.getInstance();
	
	private String alarmString="";
	
	private AlarmUtil alarmUtil=new AlarmUtil();
	
	@Override
	public String execute() throws Exception {
		
		wellList = jointOilInitentity.getWellList();
		List<MonitorData> allLastMonitorDatas=monitorDataService.searchAllWellLastTimeMonitorData(wellList.size());//获取所有井的最后一条数据
		List<MonitorData> allTimeIntervalMonitorDatas=monitorDataService.searchAllWellLastTimeMonitorData(5);// 取5分钟以前的数据
		for (Well well : wellList) {
			alarmString+=well.getWellNo();
			List<Index> indexList = well.getIndexList();
			List<String> xmlList = Lists.newArrayList();
			List<String> curveXmlList = Lists.newArrayList();
			MonitorData monitorData = getLastTimeMonitorData(well.getWellNo(),allLastMonitorDatas);//获取最后一条数据
			List<MonitorData> monitorDatas = getTimeIntervalMonitorData(well.getWellNo(), allTimeIntervalMonitorDatas, 5);// 取5分钟以前的数据
			if(monitorData!=null){
			for (Index index : indexList) {
				List<FWColumnData> fwcdList = getFWColumnDataList(monitorDatas, index.getIndexCode());
				if (index.getIndexCode().equals("TEM")) {
					boolean tmp=alarmUtil.isAlarming(monitorData.getTemperature(), index);
					if(tmp)alarmString+="_tem";
					Document doc = fusionWidgetsManager.generateAllWellThermometerXmlData(index.getMax().toString(), index
							.getMin().toString(), index.getMaxLimit().toString(), index.getMinLimit().toString(),
							monitorData.getTemperature().toString(), index.getUnit(), "125", "170");
					xmlList.add(fusionWidgetsManager.toDocString(doc));
					Document curveDocument = fusionWidgetsManager.generateCurveNotLabelXmlData(index.getIndexName(),
							index.getUnit(), fwcdList);
					curveXmlList.add(fusionWidgetsManager.toDocString(curveDocument));
				} else if (index.getIndexCode().equals("PRE")) {
					boolean tmp=alarmUtil.isAlarming(monitorData.getPressure(), index);
					if(tmp)alarmString+="_pre";
					Document doc = fusionWidgetsManager.generateAllWellDialXmlData(index.getMax().toString(), index
							.getMin().toString(), index.getMaxLimit().toString(), index.getMinLimit().toString(),
							monitorData.getPressure().toString(), index.getUnit(), "125", "175");
					xmlList.add(fusionWidgetsManager.toDocString(doc));
					Document curveDocument = fusionWidgetsManager.generateCurveNotLabelXmlData(index.getIndexName(),
							index.getUnit(), fwcdList);
					curveXmlList.add(fusionWidgetsManager.toDocString(curveDocument));
				}else if(index.getIndexCode().equals("SJLL")){
					boolean tmp=alarmUtil.isAlarming(monitorData.getInstantaneousFlow(), index);
					if(tmp)alarmString+="_sjll";
					well.setInsString(monitorData.getInstantaneousFlow() + "米/时");//加入瞬时流量
				}else{
				}
				
			}
			well.setAccString(monitorData.getAccumulativeFlow() + "立方米");//加入累计流量
			well.setMonitorTime(df.format(monitorData.getMonitorTime()));//加入当前监测时间
			well.setXmlList(xmlList);
			well.setCurveXmlList(curveXmlList);
			well.setPreValue(monitorData.getPressure()+"");
			alarmString+=";";
			}else{
				addActionMessage(well.getWellNo()+"无数据显示");
			}
		}
		return SUCCESS;
	}


	public String realTime() throws Exception {
		XMLConfigReader reader = XMLConfigReader.getInstance("compressorMethod.xml");
		List<Well> wellList = jointOilInitentity.getWellList();
		List<MonitorData> allLastMonitorDatas=monitorDataService.searchAllWellLastTimeMonitorData(wellList.size());//获取所有井的最后一条数据
		String str = "";
		for (Well well : wellList) {
			String alarm="no";
			MonitorData monitorData = getLastTimeMonitorData(well.getWellNo(),allLastMonitorDatas);//获取最后一条数据
			List<Index> indexs=well.getIndexList();
			if(monitorData!=null){
				for (Index index : indexs) {
					if(index.getStatus()==0){
						String fieldName = reader.getTextFromPath("//method", "name",index.getIndexCode());
						Object value=ReflectionUtils.getFieldValue(monitorData, fieldName);
						boolean tmp=alarmUtil.isAlarming((Double)value, index);
						if(tmp)alarm+="_"+index.getIndexCode();
					}
				}
				str += monitorData.getWellNo() + "," + monitorData.getTemperature() + "," + monitorData.getPressure() + ","
						+ monitorData.getInstantaneousFlow()+"米/小时" + "," + monitorData.getAccumulativeFlow()+"米/立方米" +","+df.format(monitorData.getMonitorTime())+","+alarm+ ";";
			}else{
				str="no,";
			}
		}
		Struts2Utils.renderText(str.substring(0, str.length() - 1));
		return null;
	}

	/**
	 * 生成图形需要List<FWColumnData>
	 * @param _monitorDatas
	 * @param _indexCode
	 * @return
	 */
	public List<FWColumnData> getFWColumnDataList(List<MonitorData> _monitorDatas, String _indexCode) {
		List<FWColumnData> fwcdList = Lists.newArrayList();
		for (MonitorData md : _monitorDatas) {
			String formatString = df.format(md.getMonitorTime());
			if (_indexCode != null) {
				if (_indexCode.equals("TEM")) {
					FWColumnData fwcd = new FWColumnData(formatString, md.getTemperature().toString());
					fwcdList.add(fwcd);
				}
				if (_indexCode.equals("PRE")) {
					FWColumnData fwcd = new FWColumnData(formatString, md.getPressure().toString());
					fwcdList.add(fwcd);
				}
				if (_indexCode.equals("SJLL")) {
					FWColumnData fwcd = new FWColumnData(formatString, md.getInstantaneousFlow().toString());
					fwcdList.add(fwcd);
				}
				if (_indexCode.equals("LJLL")) {
					FWColumnData fwcd = new FWColumnData(formatString, md.getAccumulativeFlow().toString());
					fwcdList.add(fwcd);
				}
			}
		}
		return fwcdList;
	}
	/**
	 * 获取最后一个对象
	 * @param _wellNo井号
	 * @param _allLastMonitorDatas所有井的最后一个实时数据
	 * @return
	 */
	private MonitorData getLastTimeMonitorData(String _wellNo,List<MonitorData> _allLastMonitorDatas){
		MonitorData monitorData = monitorDataService.getLastTimeMonitorData(_wellNo, _allLastMonitorDatas);//先从集合中读取
		if(monitorData==null){
			monitorData= monitorDataService.searchMonitorDataByLastMonitorTime(_wellNo);
		}
		return monitorData;
	}
	/**
	 * 获取某井号最近几分钟的数据对象
	 * @param _wellNo井号
	 * @param _allLastMonitorDatas
	 * @param _timeInterval时间间隔
	 * @return
	 */
	private List<MonitorData> getTimeIntervalMonitorData(String _wellNo,List<MonitorData> _allLastMonitorDatas,int _timeInterval){
		List<MonitorData> monitorDatas = monitorDataService.getAllWellMonitorDataByTimeInterval(_wellNo, _timeInterval, _allLastMonitorDatas);//先从集合中读取
		if(monitorDatas==null){
			//monitorDatas= monitorDataService.getMonitorDataByWellIdAndTimeInterval(_wellNo, _timeInterval);
			monitorDatas= new ArrayList<MonitorData>();
		}
		return monitorDatas;
	}
	public List<Well> getWellList() {
		return wellList;
	}

	public Well getWell() {
		return well;
	}

	public String getTimeInterval() {
		return timeInterval;
	}


	public String getAlarmString() {
		return alarmString;
	}
	
	
}
