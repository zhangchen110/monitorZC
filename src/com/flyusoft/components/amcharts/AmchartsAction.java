package com.flyusoft.components.amcharts;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;

import com.flyusoft.common.utils.XmlAdapter;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AmchartsAction extends ActionSupport {

	private static final long serialVersionUID = 8407621774680957321L;

	//amcharts的帮助类
	@Autowired
	private AmchartsManager amchartsManager;

	public String demo() {
		return "demo";
	}

	/**
	 * 获得曲线图xml数据
	 */
	public String lineXmlData() throws Exception {
		//模拟数据库生成测试数据
		List<LineData> lineDataArray = DummyDataFetcher.getDummyLineData();
		//根据数据生成曲线图xml数据document对象
		Document document = amchartsManager.generateLineXmlData(lineDataArray);
		HttpServletResponse response = Struts2Utils.getResponse();
		//将document对象从流中输出
		XmlAdapter.writeXmlToResponse(document, response);

		return null;
	}

	/**
	 * 获得曲线图xml配置
	 */
	public String lineXmlSetting() throws Exception {
		//生成曲线图xml配置document对象
		Document document = amchartsManager.generateColumnXmlSetting("xxxxxxx",
				Arrays.asList(new String[] { "x", "y" }));
		HttpServletResponse response = Struts2Utils.getResponse();
		//将document对象从流中输出
		XmlAdapter.writeXmlToResponse(document, response);
		return null;
	}

	/**
	 * 获得柱状图xml数据
	 */
	public String columnXmlData() throws Exception {
		List<ColumnData> columnDataArray = DummyDataFetcher.getDummyColumnData();
		Document document = amchartsManager.generateColumnXmlData(columnDataArray);
		HttpServletResponse response = Struts2Utils.getResponse();
		XmlAdapter.writeXmlToResponse(document, response);

		return null;
	}

	/**
	 * 获得柱状图xml配置
	 */
	public String columnXmlSetting() throws Exception {
		Document document = amchartsManager.generateColumnXmlSetting("xxxxxxx",
				Arrays.asList(new String[] { "x", "y", "z" }));
		HttpServletResponse response = Struts2Utils.getResponse();
		XmlAdapter.writeXmlToResponse(document, response);
		return null;
	}

	/**
	 * 获得饼图xml数据
	 */
	public String pieXmlData() throws Exception {
		List<PieData> pieDataArray = DummyDataFetcher.getDummyPieData();
		Document document = amchartsManager.generatePieXmlData(pieDataArray);
		HttpServletResponse response = Struts2Utils.getResponse();
		XmlAdapter.writeXmlToResponse(document, response);

		return null;
	}

	/**
	 * 获得饼图xml配置
	 */
	public String pieXmlSetting() throws Exception {
		Document document = amchartsManager.generatePieXmlSetting("金牌对比图");
		HttpServletResponse response = Struts2Utils.getResponse();
		XmlAdapter.writeXmlToResponse(document, response);

		return null;
	}

}
