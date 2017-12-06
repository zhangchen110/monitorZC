package com.flyusoft.components.report;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.flyusoft.common.utils.XmlAdapter;
import com.flyusoft.components.report.annotation.ReportTable;

public class ReportManager<T> {

	protected Class<T> myclass;

	/**
	 * 获得泛型的类。<br>
	 * 
	 * @return
	 */
	private Class<T> getMyClass() throws Exception {
		return myclass;
	}

	public ReportManager() {
	}

	public ReportManager(Class myclass) {
		this.myclass = myclass;
	}

	/**
	 * 利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以html的形式输出到jsp页面上
	 * 
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyyy-MM-dd"。不修改格式可以传null
	 * @throws Exception
	 */
	public void generateReport(Collection<T> dataset, String pattern)
			throws Exception {

		if (pattern == null || pattern.equals("")) {
			pattern = "yyyy-MM-dd";
		}

		ReportTable reportTable = getMyClass().getAnnotation(ReportTable.class);
		String[] titleList = reportTable.titleList();
		Document doc = XmlAdapter.getNewDocument();
		Element root = XmlAdapter.createRootElement(doc, "report");
		Element titleTr = XmlAdapter.createElement(root, "tr");
		for (String title : titleList) {
			XmlAdapter.createElementByCDATA(titleTr, "td", title);
		}
		XmlAdapter.writeXmlToOutputStream(doc, System.out);
	}

	public static void main(String args[]) throws Exception {
		ReportManager<TestVO> manager = new ReportManager<TestVO>(TestVO.class);
		manager.generateReport(new ArrayList(), "");
	}
}
