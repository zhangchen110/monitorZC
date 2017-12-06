package com.flyusoft.common.utils;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xpath.internal.XPathAPI;

public class XMLConfigReader {

	private Document configdoc;

	public Document getConfigdoc() {
		return configdoc;
	}

	public void setConfigdoc(Document configdoc) {
		this.configdoc = configdoc;
	}

	private XMLConfigReader() {
	}

	/**
	 * 获取配置文件读取工具实例
	 * @param configname 配置文件名称   输入null或者""则定位到config.xml
	 * @return
	 * @throws Exception
	 */
	public static XMLConfigReader getInstance(String configname) throws Exception {
		if (configname == null || configname.equals("")) {
			configname = "config.xml";
		}
		XMLConfigReader reader = new XMLConfigReader();
		String path = UriUtil.getUriPath(configname);
		Document doc = XmlAdapter.load(path);
		if (doc != null) {
			reader.setConfigdoc(doc);
		} else {
			throw new Exception("无法读取配置文件");
		}

		return reader;
	}

	/**
	 * 通过xpath取值  一般情况下使用//形式从根路径读取
	 * @param xpath 
	 * @return
	 * @throws Exception
	 */
	public String getValueFromXPath(String xpath) throws Exception {
		String value = "";
		Element ele = getElementFromPath(xpath);
		value = XmlAdapter.getText(ele);

		return value;
	}

	/**
	 * 通过xpath取属性  一般情况下使用//形式从根路径读取
	 * @param xpath 
	 * @return
	 * @throws Exception
	 */
	public String getAttributeFromPath(String xpath, String attname) throws Exception {
		String value = "";
		Element ele = getElementFromPath(xpath);
		value = ele.getAttribute(attname);
		return value;
	}

	public String getTextFromPath(String xpath, String attname, String attvalue) throws Exception {
		String value = "";
		NodeList list = getElementListFromPath(xpath);
		for (int i = 0; i < list.getLength(); i++) {
			Element ele = (Element) list.item(i);
			ele.getAttribute(attname);
			if (ele.getAttribute(attname).equals(attvalue)) {
				value = ele.getTextContent();
			}
		}
		return value;
	}

	/**
	 * 通过xpath获取Element节点对象 //形式从根路径读取
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public Element getElementFromPath(String xpath) throws Exception {
		Element ele = (Element) XPathAPI.selectSingleNode(configdoc.getDocumentElement(), xpath);
		return ele;
	}

	public NodeList getElementListFromPath(String xpath) throws Exception {
		NodeList list = XPathAPI.selectNodeList(configdoc.getDocumentElement(), xpath);
		return list;
	}

}
