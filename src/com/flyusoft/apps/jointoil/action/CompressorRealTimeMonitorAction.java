package com.flyusoft.apps.jointoil.action;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import com.flyusoft.apps.jointoil.entity.Index;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.apps.jointoil.entity.Compressor;
import org.springframework.beans.factory.annotation.Autowired;
import com.flyusoft.apps.jointoil.entity.CompressorMD;
import com.flyusoft.apps.jointoil.entity.CompressorMonitorData;
import com.flyusoft.apps.jointoil.util.AlarmUtil;
import com.flyusoft.apps.jointoil.util.GainCompressorData;
import com.flyusoft.apps.jointoil.util.JointOilInitentity;
import com.flyusoft.common.utils.XMLConfigReader;
import com.flyusoft.common.utils.reflection.ReflectionUtils;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.flyusoft.components.fusionWidgets.FWColumnData;
import com.flyusoft.components.fusionWidgets.FusionWidgetsManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class CompressorRealTimeMonitorAction extends ActionSupport {

	private static final long serialVersionUID = -7858384406873586771L;

	private Compressor compressor;
	@Autowired
	private GainCompressorData gainCompressorData;

	private List<Index> comIndexs = Lists.newArrayList();
	@Autowired
	private FusionWidgetsManager funsionWidgetsManager;

	private CompressorMonitorData compressorMonitorData;// 返回页面的对象

	private JointOilInitentity jointOilInitentity = JointOilInitentity
			.getInstance();

	private Map<String, String> xmlMap = Maps.newHashMap();// xmlMap

	private String alarmString = "";// 报警信息

	private AlarmUtil alarmUtil = new AlarmUtil();

	public String execute() throws Exception {
		compressorMonitorData = new CompressorMonitorData();
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");
		String comCode = Struts2Utils.getParameter("comCode");
		if (comCode != null && !"".equals(comCode)) {
			compressor = jointOilInitentity
					.getCompressorByCompressorCode(comCode);// 获取压缩机对象
			if (compressor != null) {
				String compressorCode = compressor.getCompressorCode();// 获取压缩机标识编码
				CompressorMD compressorMD = gainCompressorData
						.getCompressorMD(compressorCode);// 对象
				List<? extends CompressorMD> compressorMDList = gainCompressorData
						.getCompressorMDList(compressorCode, 3);
				List<Index> indexs = compressor.getComIndexs();// 获取所有指标
				if (compressorMD != null) {
					for (Index index : indexs) {
						String indexCode = index.getIndexCode();
						List<FWColumnData> fwcdList = getFwColumnDatas(
								compressorMDList, indexCode);// 获取数据曲线值集合
						String fieldName = reader.getTextFromPath("//method",
								"name", indexCode);// 获取参数名字
						String identifyCode = indexCode.substring(
								indexCode.length() - 2, indexCode.length());// 获取最后2个识别码例如
																			// :HSWD
																			// 取WD
						Object value = ReflectionUtils.getFieldValue(
								compressorMD, fieldName);
						if (value != null && index.getStatus() == 0) {// 判断是否报警
							boolean isalarm = alarmUtil.isAlarming(
									(Double) value, index);
							if (isalarm) {
								alarmString += index.getIndexCode() + ",";
							}
						}
						if (identifyCode.equals("WD")) {// 判断等于温度
							Double valueDou = (Double) value;
							Document temDoc = funsionWidgetsManager
									.generateThermometerXmlData(index.getMax()
											+ "", index.getMin() + "",
											index.getMaxLimit() + "",
											index.getMinLimit() + "", valueDou
													+ "", "℃", "300", "133");
							Document temCurveDoc = funsionWidgetsManager
									.generateCurveXmlData(index.getIndexName(),
											index.getUnit(), fwcdList);
							String temXml = funsionWidgetsManager
									.toDocString(temDoc);
							String temCurveXml = funsionWidgetsManager
									.toDocString(temCurveDoc);
							xmlMap.put(indexCode + "TEM", temXml);
							xmlMap.put(indexCode + "TEMC", temCurveXml);
						} else if (identifyCode.equals("YL")) {
							Double valueDou = (Double) value;
							Document preDoc = funsionWidgetsManager
									.generateDialXmlData(index.getMax() + "",
											index.getMin() + "",
											index.getMaxLimit() + "",
											index.getMinLimit() + "", valueDou
													+ "", "MPa", "300", "150");
							Document preCurveDoc = funsionWidgetsManager
									.generateCurveXmlData(index.getIndexName(),
											index.getUnit(), fwcdList);
							String preXml = funsionWidgetsManager
									.toDocString(preDoc);
							String preCurveXml = funsionWidgetsManager
									.toDocString(preCurveDoc);
							xmlMap.put(indexCode + "PRE", preXml);
							xmlMap.put(indexCode + "PREC", preCurveXml);
						}
						ReflectionUtils.setFieldValue(compressorMonitorData,
								fieldName, value);// 设置值
					}
					compressorMonitorData.setTime(compressorMD.getTime());
					compressorMonitorData.setCompressorCode(compressorCode);
					compressorMonitorData
							.setRunningState(compressor.getState());
					compressorMonitorData.setRunningTime(compressor
							.getRunningTime());
				} else {
					addActionMessage("无数据显示");
				}
			} else {
				throw new Exception("无法查找到压缩机,为NULL");
			}
		} else {
			throw new Exception("压缩机ID为空");
		}
		return SUCCESS;
	}

	public String realTime() throws Exception {
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");// 解析xml
		// String comId=Struts2Utils.getParameter("comId");
		String comCode = Struts2Utils.getParameter("comCode");
		StringBuilder sb = new StringBuilder();// 返回的字符串
		Compressor compressor = jointOilInitentity
				.getCompressorByCompressorCode(comCode);// 获取压缩机对象
		if (compressor != null) {
			String compressorCode = compressor.getCompressorCode();
			CompressorMD compressorMD = gainCompressorData
					.getCompressorMD(compressorCode);// 对象
			sb.append("compressorCode," + compressorCode);// 插入压缩机编码
			sb.append(";time," + compressorMD.getTime());// 放入时间
			sb.append(";YXSJ," + compressor.getRunningTime() + ",0");// 运行时间
			sb.append(";YXZT," + compressor.getState() + ","
					+ compressor.getState());// 运行状态
			if (compressorMD != null) {
				List<Index> indexs = compressor.getComIndexs();// 获取所有指标
				for (Index index : indexs) {
					int alarm = 0;
					String indexCode = index.getIndexCode();
					String fieldName = reader.getTextFromPath("//method",
							"name", indexCode);// 获取属性
					Object value = ReflectionUtils.getFieldValue(compressorMD,
							fieldName);// 获取值
					if (value != null && index.getStatus() == 0) {// 判断是否报警
						boolean isalarm = alarmUtil.isAlarming((Double) value,
								index);
						if (isalarm) {
							alarm = 1;// 1则报警
						}
					}
					sb.append(";" + indexCode + "," + value + "," + alarm);
				}
			}
		}
		Struts2Utils.renderText(sb.toString());
		return null;
	}

	/**
	 * 获取数据
	 * 
	 * @param _compressorMDList
	 * @param _indexCode
	 * @return
	 * @throws Exception
	 */
	public List<FWColumnData> getFwColumnDatas(
			List<? extends CompressorMD> _compressorMDList, String _indexCode)
			throws Exception {
		List<FWColumnData> fwcds = Lists.newArrayList();
		// SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		XMLConfigReader reader = XMLConfigReader
				.getInstance("compressorMethod.xml");
		String fieldName = reader.getTextFromPath("//method", "name",
				_indexCode);// 获取参数名字
		for (int i = 0; i < _compressorMDList.size(); i++) {
			CompressorMD cmd = _compressorMDList.get(i);
			Object value = ReflectionUtils.getFieldValue(cmd, fieldName);
			// FWColumnData fwcd=new
			// FWColumnData(df.format(cmd.getTime()),value.toString());
			if (value != null) {
				FWColumnData fwcd = new FWColumnData("", value.toString());
				fwcds.add(fwcd);
			}
		}
		return fwcds;
	}

	public Compressor getCompressor() {
		return compressor;
	}

	public List<Index> getComIndexs() {
		return comIndexs;
	}

	public CompressorMonitorData getCompressorMonitorData() {
		return compressorMonitorData;
	}

	public Map<String, String> getXmlMap() {
		return xmlMap;
	}

	public String getAlarmString() {
		return alarmString;
	}
}
