package com.flyusoft.common.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlAdapter {

	public static DocumentBuilder getBuilder() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder;
	}

	/**
	 * 从路径加载xml文档
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static Document load(String path) throws Exception {
		return getBuilder().parse(path);
	}

	/**
	 * 创建新xml对象
	 * @return
	 * @throws Exception
	 */
	public static Document getNewDocument() throws Exception {
		return getBuilder().newDocument();

	}

	/**
	 * 从文件加载xml文档
	 * @param xmlFile
	 * @return
	 * @throws Exception
	 */
	public static Document load(File xmlFile) throws Exception {
		return getBuilder().parse(xmlFile);
	}

	/**
	 * 通过内容加载xml对象
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Document loadXML(String xml) throws Exception {
		if (xml == null || xml.equals("")) {
			return getNewDocument();
		}
		return getBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
	}

	/**
	 * 获取element对象的text节点值
	 * @param ele
	 * @return
	 */
	public static String getText(Element ele) {
		NodeList nodelist = ele.getChildNodes();
		if (nodelist.getLength() > 0) {
			return nodelist.item(0).getNodeValue();
		} else {
			return "";
		}
	}

	/**
	 * 把xml输出到流
	 * @param doc
	 * @param out
	 * @throws Exception
	 */
	public static void writeXmlToOutputStream(Document doc, OutputStream out) throws Exception {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(out);
		t.transform(source, result);
	}

	/**
	 * 把xml输出到response
	 * @param doc
	 * @param response
	 * @throws Exception
	 */
	public static void writeXmlToResponse(Document doc, HttpServletResponse response) throws Exception {
		response.setContentType("text/xml");
		writeXmlToOutputStream(doc, response.getOutputStream());

	}

	/**
	 * 创建根节点
	 * @param doc
	 * @param rootTagName
	 */
	public static Element createRootElement(Document doc, String rootTagName) {
		if (doc.getDocumentElement() == null) {
			Element root = doc.createElement(rootTagName);
			doc.appendChild(root);
			return root;
		}
		return doc.getDocumentElement();
	}

	/**
	 * 创建根节点
	 * @param doc
	 * @param rootTagName
	 */
	public static Element createRootElement(Document doc, String rootTagName, Map<String, String> attMap) {
		if (doc.getDocumentElement() == null) {
			Element root = doc.createElement(rootTagName);
			Set<String> attNameSet = attMap.keySet();
			for (String attName : attNameSet) {
				root.setAttribute(attName, attMap.get(attName));
			}
			doc.appendChild(root);
			return root;
		}
		return doc.getDocumentElement();

	}

	/**
	 * 创建子节点
	 * @param parent
	 * @param tagName
	 */
	public static Element createElement(Element parent, String tagName) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		parent.appendChild(child);
		return child;

	}

	/**
	 * 创建带属性的子节点
	 * @param parent
	 * @param tagName
	 * @param attName
	 * @param attValue
	 */
	public static Element createElement(Element parent, String tagName, String attName, String attValue) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		child.setAttribute(attName, attValue);
		parent.appendChild(child);
		return child;
	}

	/**
	 * 创建带属性的子节点
	 * @param parent
	 * @param tagName
	 * @param attName
	 * @param attValue
	 */
	public static Element createElement(Element parent, String tagName, Map<String, String> attMap) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		Set<String> attNameSet = attMap.keySet();
		for (String attName : attNameSet) {
			child.setAttribute(attName, attMap.get(attName));
		}
		parent.appendChild(child);
		return child;
	}

	/**
	 * 创建带值的子节点
	 * @param parent
	 * @param tagName
	 * @param textValue
	 */
	public static Element createElement(Element parent, String tagName, String textValue) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		Node node = doc.createTextNode(textValue);
		child.appendChild(node);
		parent.appendChild(child);
		return child;
	}

	/**
	 * 创建带属性和值的子节点
	 * @param parent
	 * @param tagName
	 * @param attName
	 * @param attValue
	 * @param textValue
	 */
	public static Element createElement(Element parent, String tagName, String attName, String attValue,
			String textValue) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		child.setAttribute(attName, attValue);
		Node node = doc.createTextNode(textValue);
		child.appendChild(node);
		parent.appendChild(child);
		return child;
	}

	/**
	 * 创建带CDATA值的子节点
	 * @param parent
	 * @param tagName
	 * @param textValue
	 */
	public static Element createElementByCDATA(Element parent, String tagName, String textValue) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		Node node = doc.createCDATASection(textValue);
		child.appendChild(node);
		parent.appendChild(child);
		return child;
	}
}
