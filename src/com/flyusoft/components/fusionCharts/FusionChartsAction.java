
package com.flyusoft.components.fusionCharts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 生成线，柱，饼图
 * @author Yanglongquan
 * 2011-9-26
 * yanglongquan@flyu.com
 *
 */
@Controller
@Scope("prototype")
public class FusionChartsAction extends ActionSupport{

	private static final long serialVersionUID = 2014153656168461055L;
	
	private String lineXml; //线图Xml
	
	private String pieXml; //饼图Xml
	
	private String ColXml; //柱图Xml
	@Autowired
	private FusionChartsManager fusionChartsManager;
	public String execute() throws Exception{
		Document lineDoc=fusionChartsManager
		.generateLineXmlData("曲线图", AnalogData.getDummyLineData(), AnalogData.getLineCaption(), "元");
		
		Document pieDoc=fusionChartsManager
		.generatePieXmlData("3D饼图", AnalogData.getDummyPieData());
		
		Document colDoc=fusionChartsManager
		.generateColXmlData("3D柱图", AnalogData.getDummyColumnData(), AnalogData.getColCaption());
		
		lineXml=fusionChartsManager.toDocString(lineDoc);
		pieXml=fusionChartsManager.toDocString(pieDoc);
		ColXml=fusionChartsManager.toDocString(colDoc);
		return SUCCESS;
	}
	
	public String getLineXml() {
		return lineXml;
	}

	public String getPieXml() {
		return pieXml;
	}

	public String getColXml() {
		return ColXml;
	}
	
	
}
