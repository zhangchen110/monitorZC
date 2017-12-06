package com.flyusoft.components.fusionWidgets;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.flyusoft.common.utils.XmlAdapter;
import com.google.common.collect.Maps;

/**
 * 生成xml图形类中内容
 * 
 * @author Yanglongquan 2011-9-15 yanglongquan@flyu.com
 * 
 */
@Component
public class FusionWidgetsManager {

	public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 生成曲线图形 <chart caption='parentTitle' subCaption='nodeTitle'
	 * numberPrefix='tem' setAdaptiveYMin='1' xAxisName='Time'
	 * showRealTimeValue='1' realTimeValuePadding='50' labelDisplay='Rotate'
	 * slantLabels='1' > <categories> <category label='Jan' /> <category
	 * label='Feb' /> <category label='Mar' /> </categories> <dataset
	 * seriesName='Google' showValues='30'> <set value='27.26'/> <set
	 * value='37.88'/> <set value='38.88'/> </dataset> </chart>
	 * 
	 * @param _name
	 *            标题名字
	 * @param _unit
	 *            单位
	 * @param _fwcdList
	 *            曲线显示的Label 与value
	 */
	public Document generateCurveXmlData(String _name, String _unit, List<FWColumnData> _fwcdList) throws Exception {

		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("palette", "1");// 设置背景样式
		rootMap.put("caption", _name);
		rootMap.put("baseFont", "黑体");
		rootMap.put("subCaption", _unit);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("setAdaptiveYMin", "1");
		rootMap.put("numDivLines", "2");//设置显示信息行数
		//rootMap.put("xAxisName", "Time");
		rootMap.put("showRealTimeValue", "0");
		rootMap.put("basefontSize", "16");
		rootMap.put("realTimeValuePadding", "10");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("labelDisplay", "Rotate");
		rootMap.put("lineThickness", "2");// 设置线的粗细
		rootMap.put("linecolor", "#00FF00");// 设置线的颜色
		rootMap.put("slantLabels", "1");
		rootMap.put("showBorder", "0");//无边框 
		//rootMap.put("bgColor", "false");//设置无背景颜色
		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element categories = XmlAdapter.createElement(root, "categories");

		Element dataset = null;
		Map<String, String> datasetMap = Maps.newHashMap();
		datasetMap.put("seriesName", _name);
		datasetMap.put("showValues", "720");
		dataset = XmlAdapter.createElement(root, "dataset", datasetMap);

//		for (FWColumnData columnData : _fwcdList) {
//			if (columnData != null) {
//				XmlAdapter.createElement(categories, "category",
//
//				"label", columnData.getLabel());
//				XmlAdapter.createElement(dataset, "set", "value",
//
//				columnData.getValue());
//			}
//		}
		for (int i = 0; i < (15 - _fwcdList.size()); i++) {
			XmlAdapter.createElement(categories, "category", "label", "");
			XmlAdapter.createElement(dataset, "set", "value", "");
		}
		for (int j = 0; j < _fwcdList.size(); j++) {
			FWColumnData columnData = _fwcdList.get(j);
			if (columnData != null) {
				XmlAdapter.createElement(categories, "category", "label", _fwcdList.get(j).getLabel());
				XmlAdapter.createElement(dataset, "set", "value", columnData.getValue());
			}
		}
		return doc;
	}
	public Document generateSingleWellCurveXmlData(String _name, String _unit, List<FWColumnData> _fwcdList) throws Exception {

		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("palette", "1");// 设置背景样式
		rootMap.put("caption", _name);
		rootMap.put("baseFont", "黑体");
		rootMap.put("subCaption", _unit);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("setAdaptiveYMin", "1");
		rootMap.put("numDivLines", "2");//设置显示信息行数
		//rootMap.put("xAxisName", "Time");
		rootMap.put("showRealTimeValue", "0");
		rootMap.put("basefontSize", "21");
		rootMap.put("realTimeValuePadding", "10");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("labelDisplay", "Rotate");
		rootMap.put("lineThickness", "2");// 设置线的粗细
		rootMap.put("linecolor", "#00FF00");// 设置线的颜色
		rootMap.put("slantLabels", "1");
		rootMap.put("showBorder", "0");//无边框 
		//rootMap.put("bgColor", "false");//设置无背景颜色
		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element categories = XmlAdapter.createElement(root, "categories");

		Element dataset = null;
		Map<String, String> datasetMap = Maps.newHashMap();
		datasetMap.put("seriesName", _name);
		datasetMap.put("showValues", "720");
		dataset = XmlAdapter.createElement(root, "dataset", datasetMap);

//		for (FWColumnData columnData : _fwcdList) {
//			if (columnData != null) {
//				XmlAdapter.createElement(categories, "category",
//
//				"label", columnData.getLabel());
//				XmlAdapter.createElement(dataset, "set", "value",
//
//				columnData.getValue());
//			}
//		}
		for (int i = 0; i < (15 - _fwcdList.size()); i++) {
			XmlAdapter.createElement(categories, "category", "label", "");
			XmlAdapter.createElement(dataset, "set", "value", "");
		}
		for (int j = 0; j < _fwcdList.size(); j++) {
			FWColumnData columnData = _fwcdList.get(j);
			if (columnData != null) {
				XmlAdapter.createElement(categories, "category", "label", _fwcdList.get(j).getLabel());
				XmlAdapter.createElement(dataset, "set", "value", columnData.getValue());
			}
		}
		return doc;
	}
	/**
	 * 生成只显示15个点的曲线图
	 * 
	 * @param name
	 * @param _unit
	 * @param _fwcdList
	 * @return
	 * @throws Exception
	 */
	public Document generateCurveNotLabelXmlData(String name, String _unit, List<FWColumnData> _fwcdList)
			throws Exception {

		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("numberSuffix", _unit);
		rootMap.put("setAdaptiveYMin", "1");
		rootMap.put("showLabels", "0");
		rootMap.put("showRealTimeValue", "0");
		rootMap.put("showYAxisValues", "0");
		rootMap.put("realTimeValuePadding", "0");
		rootMap.put("baseFontSize", "16");
		rootMap.put("showValues", "0");
		rootMap.put("numDivLines", "2");
		rootMap.put("lineThickness", "1");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("lineColor", "#00FF00");
		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element categories = XmlAdapter.createElement(root, "categories");
		Element dataset = XmlAdapter.createElement(root, "dataset");
		for (int i = 0; i < (15 - _fwcdList.size()); i++) {
			XmlAdapter.createElement(categories, "category", "label", "");
			XmlAdapter.createElement(dataset, "set", "value", "");
		}
		for (int j = 0; j < _fwcdList.size(); j++) {
			FWColumnData columnData = _fwcdList.get(j);
			if (columnData != null) {
				XmlAdapter.createElement(categories, "category", "label", "");
				XmlAdapter.createElement(dataset, "set", "value", columnData.getValue());
			}
		}
		return doc;
	}

	/**
	 * 井仪表盘<chart lowerLimit='0' upperLimit='100' lowerLimitDisplay='Bad'
	 * upperLimitDisplay='Good' palette='1' numberSuffix='%'
	 * chartRightMargin='20' decimals='0'> <colorRange> <color
	 * minValue='0'maxValue='75' code='FF654F' label='Bad'/> <color
	 * minValue='75' maxValue='100' code='8BBA00' label='Good'/> </colorRange>
	 * <pointers> <pointer id='CPU1' value='92' toolText='CPU 1 Usage'/>
	 * </pointers> </chart>
	 * 
	 * @param _max
	 *            最大值
	 * @param _min
	 *            最小值
	 * @param _maxLimit
	 *            最高上限
	 * @param _minLimit
	 *            最低下限
	 * @param _unit
	 *            单位
	 **/
	public Document generateColumnarXmlData(String _min, String _max, String _minLimit, String _maxLimit, String _unit)
			throws Exception {
		Document doc = XmlAdapter.getNewDocument();

		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("lowerLimitDisplay", "min");
		rootMap.put("upperLimitDisplay", "max");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("bgAlpha", "0");
		rootMap.put("showBorder", "0");
		rootMap.put("lowerLimit", _min);
		rootMap.put("upperLimit", _max);
		rootMap.put("showTickMarks", "0");
		rootMap.put("showLimits", "0");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("cylFillColor", "CC0000");
		rootMap.put("baseFontColor", "CC0000");

		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element colorRange = XmlAdapter.createElement(root, "colorRange");

		Map<String, String> color1Map = Maps.newHashMap();
		color1Map.put("minValue", _min);
		color1Map.put("maxValue", _minLimit);
		color1Map.put("code", "CC0000");
		color1Map.put("label", "low");
		XmlAdapter.createElement(colorRange, "color", color1Map);

		Map<String, String> color2Map = Maps.newHashMap();
		color2Map.put("minValue", _minLimit);
		color2Map.put("maxValue", _maxLimit);
		color2Map.put("code", "00FF00");
		color2Map.put("label", "normal");
		XmlAdapter.createElement(colorRange, "color", color2Map);

		Map<String, String> color3Map = Maps.newHashMap();
		color3Map.put("minValue", _maxLimit);
		color3Map.put("maxValue", _max);
		color3Map.put("code", "CC0000");
		color3Map.put("label", "high");
		XmlAdapter.createElement(colorRange, "color", color3Map);

		XmlAdapter.createElement(root, "value", "222");

		return doc;
	}

	public String toDocString(Document doc) throws Exception {

		StringWriter sw = new StringWriter();
		Transformer serializer = TransformerFactory.newInstance().newTransformer();
		serializer.transform(new DOMSource(doc), new StreamResult(sw));

		return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>", "");
	}

	/**
	 * 仪表盘图  <chart bgAlpha="0" bgColor="FFFFFF"
	 * lowerLimit="0" upperLimit="100" numberSuffix="%25" showBorder="0"
	 * basefontColor="FFFFDD" chartTopMargin="25" chartBottomMargin="25"
	 * chartLeftMargin="25" chartRightMargin="25" toolTipBgColor="80A905"
	 * gaugeFillMix="{dark-10},FFFFFF,
	 * 
	 * {dark-10}" gaugeFillRatio="3">
	 * 
	 * <colorRange> <color minValue="0" maxValue="45" code="FF654F"/> <color
	 * minValue="45" maxValue="80" code="F6BD0F"/> <color minValue="80"
	 * maxValue="100" code="8BBA00"/> </colorRange>
	 * 
	 * <dials> <dial value="92" rearExtension="10"/> </dials>
	 * 
	 * <trendpoints> <point value="50" displayValue="Average" fontcolor="FF4400"
	 * useMarker="1"
	 * 
	 * dashed="1" dashLen="2" dashGap="2" valueInside="1"/> </trendpoints>
	 * 
	 * </chart>
	 * 
	 * 
	 * @param _max
	 *            最大值
	 * @param _maxlimit
	 *            最大上限
	 * @param _minlimit
	 *            最小下限
	 * @param _pointer
	 *            当前值，超出最大值不能正常显示（产生异常）
	 * @param _unit
	 *            单位
	 * @return
	 * 
	 */

	public Document generateDialXmlData(String _max, String _min, String _maxlimit, String _minlimit, String _pointer,
			String _unit, String _heigh, String _width) throws Exception {

		Document doc = XmlAdapter.getNewDocument();

		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("bgAlpha", "0");
		rootMap.put("baseFont", "黑体");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("showValue", "1");//显示value值
		rootMap.put("lowerLimit", _min);
		rootMap.put("upperLimit", _max);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("showBorder", "0");
		rootMap.put("baseFontSize", "16");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("basefontColor", "000000");
		rootMap.put("toolTipBgColor", "80A905");

		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element colorRange = XmlAdapter.createElement(root, "colorRange");

		Map<String, String> color1Map = Maps.newHashMap();
		color1Map.put("minValue", _min);
		color1Map.put("maxValue", _minlimit);
		color1Map.put("code", "FF654F");
		XmlAdapter.createElement(colorRange, "color", color1Map);

		Map<String, String> color2Map = Maps.newHashMap();
		color2Map.put("minValue", _minlimit);
		color2Map.put("maxValue", _maxlimit);
		color2Map.put("code", "F6BD0F");
		XmlAdapter.createElement(colorRange, "color", color2Map);

		Map<String, String> color3Map = Maps.newHashMap();
		color3Map.put("minValue", _maxlimit);
		color3Map.put("maxValue", _max);
		color3Map.put("code", "FF654F");
		XmlAdapter.createElement(colorRange, "color", color3Map);

		Element dials = XmlAdapter.createElement(root, "dials");

		Map<String, String> dialsMap = Maps.newHashMap();
		dialsMap.put("value", _pointer);
		dialsMap.put("rearExtension", "10");
		XmlAdapter.createElement(dials, "dial", dialsMap);

		Element trendpoints = XmlAdapter.createElement(root, "trendpoints");

		Map<String, String> pointMap = Maps.newHashMap();
		pointMap.put("displayValue", _unit);
		pointMap.put("fontcolor", "FF4400");
		pointMap.put("useMarker", "1");
		pointMap.put("dashed", "1");
		pointMap.put("dashLen", "2");
		pointMap.put("dashGap", "2");
		pointMap.put("valueInside", "1");
		XmlAdapter.createElement(trendpoints, "point", pointMap);

		Element annotations = XmlAdapter.createElement(root, "annotations");
		Element annotationGroup = XmlAdapter.createElement(annotations, "annotationGroup");

		Map<String, String> annotationGroupMap = Maps.newHashMap();
		annotationGroupMap.put("x", "0");
		annotationGroupMap.put("y", "0");
		annotationGroupMap.put("toX", _width);// 300
		annotationGroupMap.put("toY", _heigh);// 200
		//annotationGroupMap.put("color", "ffffff");
		//annotationGroupMap.put("showBorder", "0");
		annotationGroupMap.put("alpha", "1");
		XmlAdapter.createElement(annotationGroup, "annotation", annotationGroupMap);

		return doc;
	}
	public Document generateAllWellDialXmlData(String _max, String _min, String _maxlimit, String _minlimit, String _pointer,
			String _unit, String _heigh, String _width) throws Exception {

		Document doc = XmlAdapter.getNewDocument();

		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("bgAlpha", "0");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("baseFontSize", "13");
		rootMap.put("showValue", "0");//显示value值
		rootMap.put("lowerLimit", _min);
		rootMap.put("baseFont", "黑体");
		rootMap.put("upperLimit", _max);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("showBorder", "0");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("basefontColor", "000000");
		rootMap.put("toolTipBgColor", "80A905");

		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element colorRange = XmlAdapter.createElement(root, "colorRange");

		Map<String, String> color1Map = Maps.newHashMap();
		color1Map.put("minValue", _min);
		color1Map.put("maxValue", _minlimit);
		color1Map.put("code", "FF654F");
		XmlAdapter.createElement(colorRange, "color", color1Map);

		Map<String, String> color2Map = Maps.newHashMap();
		color2Map.put("minValue", _minlimit);
		color2Map.put("maxValue", _maxlimit);
		color2Map.put("code", "F6BD0F");
		XmlAdapter.createElement(colorRange, "color", color2Map);

		Map<String, String> color3Map = Maps.newHashMap();
		color3Map.put("minValue", _maxlimit);
		color3Map.put("maxValue", _max);
		color3Map.put("code", "FF654F");
		XmlAdapter.createElement(colorRange, "color", color3Map);

		Element dials = XmlAdapter.createElement(root, "dials");

		Map<String, String> dialsMap = Maps.newHashMap();
		dialsMap.put("value", _pointer);
		dialsMap.put("rearExtension", "10");
		XmlAdapter.createElement(dials, "dial", dialsMap);

		Element trendpoints = XmlAdapter.createElement(root, "trendpoints");

		Map<String, String> pointMap = Maps.newHashMap();
		pointMap.put("displayValue", _unit);
		pointMap.put("fontcolor", "FF4400");
		pointMap.put("useMarker", "1");
		pointMap.put("dashed", "1");
		pointMap.put("dashLen", "2");
		pointMap.put("dashGap", "2");
		pointMap.put("valueInside", "1");
		XmlAdapter.createElement(trendpoints, "point", pointMap);

		Element annotations = XmlAdapter.createElement(root, "annotations");
		Element annotationGroup = XmlAdapter.createElement(annotations, "annotationGroup");

		Map<String, String> annotationGroupMap = Maps.newHashMap();
		annotationGroupMap.put("x", "0");
		annotationGroupMap.put("y", "0");
		annotationGroupMap.put("toX", _width);// 300
		annotationGroupMap.put("toY", _heigh);// 200
		//annotationGroupMap.put("color", "ffffff");
		//annotationGroupMap.put("showBorder", "0");
		annotationGroupMap.put("alpha", "1");
		XmlAdapter.createElement(annotationGroup, "annotation", annotationGroupMap);

		return doc;
	}
	public Document generateSingleWellDialXmlData(String _max, String _min, String _maxlimit, String _minlimit, String _pointer,
			String _unit, String _heigh, String _width) throws Exception {

		Document doc = XmlAdapter.getNewDocument();

		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("bgAlpha", "0");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("baseFontSize", "21");
		rootMap.put("showValue", "1");//显示value值
		rootMap.put("lowerLimit", _min);
		rootMap.put("baseFont", "黑体");
		rootMap.put("upperLimit", _max);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("showBorder", "0");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("basefontColor", "000000");
		rootMap.put("toolTipBgColor", "80A905");

		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);
		Element colorRange = XmlAdapter.createElement(root, "colorRange");

		Map<String, String> color1Map = Maps.newHashMap();
		color1Map.put("minValue", _min);
		color1Map.put("maxValue", _minlimit);
		color1Map.put("code", "FF654F");
		XmlAdapter.createElement(colorRange, "color", color1Map);

		Map<String, String> color2Map = Maps.newHashMap();
		color2Map.put("minValue", _minlimit);
		color2Map.put("maxValue", _maxlimit);
		color2Map.put("code", "F6BD0F");
		XmlAdapter.createElement(colorRange, "color", color2Map);

		Map<String, String> color3Map = Maps.newHashMap();
		color3Map.put("minValue", _maxlimit);
		color3Map.put("maxValue", _max);
		color3Map.put("code", "FF654F");
		XmlAdapter.createElement(colorRange, "color", color3Map);

		Element dials = XmlAdapter.createElement(root, "dials");

		Map<String, String> dialsMap = Maps.newHashMap();
		dialsMap.put("value", _pointer);
		dialsMap.put("rearExtension", "10");
		XmlAdapter.createElement(dials, "dial", dialsMap);

		Element trendpoints = XmlAdapter.createElement(root, "trendpoints");

		Map<String, String> pointMap = Maps.newHashMap();
		pointMap.put("displayValue", _unit);
		pointMap.put("fontcolor", "FF4400");
		pointMap.put("useMarker", "1");
		pointMap.put("dashed", "1");
		pointMap.put("dashLen", "2");
		pointMap.put("dashGap", "2");
		pointMap.put("valueInside", "1");
		XmlAdapter.createElement(trendpoints, "point", pointMap);

		Element annotations = XmlAdapter.createElement(root, "annotations");
		Element annotationGroup = XmlAdapter.createElement(annotations, "annotationGroup");

		Map<String, String> annotationGroupMap = Maps.newHashMap();
		annotationGroupMap.put("x", "0");
		annotationGroupMap.put("y", "0");
		annotationGroupMap.put("toX", _width);// 300
		annotationGroupMap.put("toY", _heigh);// 200
		//annotationGroupMap.put("color", "ffffff");
		//annotationGroupMap.put("showBorder", "0");
		annotationGroupMap.put("alpha", "1");
		XmlAdapter.createElement(annotationGroup, "annotation", annotationGroupMap);

		return doc;
	}
	/**
	 * liguiqiang 温度计型图
	 * 
	 * <chart palette='3' bgColor='FFFFFF' bgAlpha='0' showBorder='0'
	 * lowerLimit='0'
	 * 
	 * upperLimit='100' lowerLimitDisplay='Low' upperLimitDisplay='High'
	 * numberSuffix='%25'
	 * 
	 * majorTMHeight='4' minorTMNumber='5' useSameFillColor='0'
	 * showTickValues='1' decimalPrecision='0' chartTopMargin='25'
	 * chartLeftMargin='20'>
	 * 
	 * <value>78.9</value> <annotations> <annotationGroup id='Grp1'
	 * showBelow='1'> <annotation type='rectangle' x='0' y='0' toX='100'
	 * toY='450' radius='10'
	 * 
	 * fillColor='AEC0CA, 333333, AEC0CA' fillAngle='90' /> <annotation
	 * type='rectangle' x='5' y='5' toX='95' toY='445' radius='10'
	 * 
	 * fillColor='333333, C3D0D8, 333333' fillAngle='90' /> <annotation
	 * type='rectangle' x='10' y='10' toX='90' toY='440' radius='10'
	 * 
	 * fillColor='C4D5DC, A3A5A4' fillAngle='180' /> </annotationGroup>
	 * </annotations> </chart>
	 * 
	 * numberSuffix='%0' 单位 majorTMHeight='10' 副线长度 minorTMNumber='56' 主线长度
	 * showTickValues='1' 0 and 1 是否显示单位 1为显示 decimalPrecision='0' 0 显示刻度数
	 * chartTopMargin='25' 温度及距离顶部距离 chartLeftMargin='20' 温度及距离左侧距离 annotation
	 * type='rectangle' 为三层底边 fillAngle='180' 为颜色渐变角度
	 * 
	 * @param _max
	 *            最大值
	 * @param _maxlimit
	 *            最大上限
	 * @param _minlimit
	 *            最小下限
	 * @param _pointer
	 *            当前值，超出最大值不能正常显示（产生异常）
	 * @param _unit
	 *            单位
	 * @return
	 * @throws Exception
	 */

	public Document generateThermometerXmlData(String _max, String _min, String _maxlimit, String _minlimit,
			String _pointer, String _unit, String _heigh, String _width) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("gaugeFillColor", "22B148");//设置温度计的颜色
		rootMap.put("bgAlpha", "0");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("baseFont", "黑体");
		rootMap.put("showBorder", "0");
		rootMap.put("baseFontSize", "16");
		rootMap.put("lowerLimit", _min);
		rootMap.put("upperLimit", _max);
		rootMap.put("lowerLimitDisplay", _min + _unit);
		rootMap.put("upperLimitDisplay", _max + _unit);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("useSameFillColor", "0");
		rootMap.put("showTickValues", "1");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("chartTopMargin", "10");//距离顶部
		rootMap.put("chartLeftMargin", "27");//距离左侧
		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);// 创建一个标签

		// 加入Map值
		XmlAdapter.createElement(root, "value", _pointer);// 创建一个标签同时赋值
		Element annotations = XmlAdapter.createElement(root, "annotations");// 创建一个标签
		Element annotationGroup = XmlAdapter.createElement(annotations, "annotationGroup");// 创建一个标签
		// 第一层
		Map<String, String> annotationMap1 = Maps.newHashMap();
		annotationMap1.put("type", "rectangle");
		annotationMap1.put("xPos", "0");
		annotationMap1.put("yPos", "0");
		
		annotationMap1.put("toXPos", _width);// div宽度 150
		annotationMap1.put("toYPos", _heigh);// div高度400
		annotationMap1.put("fillColor", "ffffff");
		annotationMap1.put("fillAngle", "190");// 显示背景渐变角度
		XmlAdapter.createElement(annotationGroup, "annotation", annotationMap1);// 创建一个标签
		return doc;
	}

	public Document generateAllWellThermometerXmlData(String _max, String _min, String _maxlimit, String _minlimit,
			String _pointer, String _unit, String _heigh, String _width) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("gaugeFillColor", "22B148");//设置温度计的颜色
		rootMap.put("bgAlpha", "0");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("showBorder", "0");
		rootMap.put("baseFontSize", "15");
		rootMap.put("baseFont", "黑体");
		rootMap.put("lowerLimit", _min);
		rootMap.put("upperLimit", _max);
		rootMap.put("lowerLimitDisplay", _min + _unit);
		rootMap.put("upperLimitDisplay", _max + _unit);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("useSameFillColor", "0");
		rootMap.put("showTickValues", "1");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("chartTopMargin", "10");//距离顶部
		rootMap.put("chartLeftMargin", "27");//距离左侧
		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);// 创建一个标签

		// 加入Map值
		XmlAdapter.createElement(root, "value", _pointer);// 创建一个标签同时赋值
		Element annotations = XmlAdapter.createElement(root, "annotations");// 创建一个标签
		Element annotationGroup = XmlAdapter.createElement(annotations, "annotationGroup");// 创建一个标签
		// 第一层
		Map<String, String> annotationMap1 = Maps.newHashMap();
		annotationMap1.put("type", "rectangle");
		annotationMap1.put("xPos", "0");
		annotationMap1.put("yPos", "0");
		
		annotationMap1.put("toXPos", _width);// div宽度 150
		annotationMap1.put("toYPos", _heigh);// div高度400
		annotationMap1.put("fillColor", "ffffff");
		annotationMap1.put("fillAngle", "190");// 显示背景渐变角度
		XmlAdapter.createElement(annotationGroup, "annotation", annotationMap1);// 创建一个标签
		return doc;
	}
	public Document generateSingleWellThermometerXmlData(String _max, String _min, String _maxlimit, String _minlimit,
			String _pointer, String _unit, String _heigh, String _width) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap = Maps.newHashMap();
		rootMap.put("gaugeFillColor", "22B148");//设置温度计的颜色
		rootMap.put("bgAlpha", "0");
		rootMap.put("bgColor", "FFFFFF");
		rootMap.put("showBorder", "0");
		rootMap.put("baseFontSize", "21");
		rootMap.put("baseFont", "黑体");
		rootMap.put("lowerLimit", _min);
		rootMap.put("upperLimit", _max);
		rootMap.put("lowerLimitDisplay", _min + _unit);
		rootMap.put("upperLimitDisplay", _max + _unit);
		rootMap.put("numberSuffix", _unit);
		rootMap.put("useSameFillColor", "0");
		rootMap.put("showTickValues", "1");
		rootMap.put("decimalPrecision", "3");
		rootMap.put("chartTopMargin", "10");//距离顶部
		rootMap.put("chartLeftMargin", "27");//距离左侧
		Element root = XmlAdapter.createRootElement(doc, "chart", rootMap);// 创建一个标签

		// 加入Map值
		XmlAdapter.createElement(root, "value", _pointer);// 创建一个标签同时赋值
		Element annotations = XmlAdapter.createElement(root, "annotations");// 创建一个标签
		Element annotationGroup = XmlAdapter.createElement(annotations, "annotationGroup");// 创建一个标签
		// 第一层
		Map<String, String> annotationMap1 = Maps.newHashMap();
		annotationMap1.put("type", "rectangle");
		annotationMap1.put("xPos", "0");
		annotationMap1.put("yPos", "0");
		
		annotationMap1.put("toXPos", _width);// div宽度 150
		annotationMap1.put("toYPos", _heigh);// div高度400
		annotationMap1.put("fillColor", "ffffff");
		annotationMap1.put("fillAngle", "190");// 显示背景渐变角度
		XmlAdapter.createElement(annotationGroup, "annotation", annotationMap1);// 创建一个标签
		return doc;
	}

}
