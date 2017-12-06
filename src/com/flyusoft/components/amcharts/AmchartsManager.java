package com.flyusoft.components.amcharts;

import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.flyusoft.common.utils.XmlAdapter;

@Component
public class AmchartsManager {

	/**
	 * 生成曲线图XML数据文件格式内容
	 * 示例：
	 * <chart>
	 * 	<series>
	 * 		<value xid="1">1950</value>
	 * 	</series>
	 * 	<graphs>
	 * 		<graph gid="1">
	 * 			<value xid="1">-0.307</value>
	 * 		</graph>
	 * 		<graph gid="2">
	 * 			<value xid="1">-0.171</value>
	 * 		</graph>
	 * 	</graphs>
	 * </chart>
	 * @param lineDataArray LineData类型的List集合
	 * @see LineData
	 * @return w3c Document对象
	 */
	public Document generateLineXmlData(List<LineData> lineDataArray) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		if (lineDataArray != null && lineDataArray.size() > 0) {
			Element root = XmlAdapter.createRootElement(doc, "chart");
			Element series = XmlAdapter.createElement(root, "series");
			for (int i = 0; i < lineDataArray.size(); i++) {
				LineData data = lineDataArray.get(i);
				XmlAdapter.createElement(series, "value", "xid", String.valueOf(i), data.getTitle());
			}
			Element graphs = XmlAdapter.createElement(root, "graphs");
			int count = lineDataArray.get(0).getValues().size();
			for (int j = 0; j < count; j++) {
				Element graph = XmlAdapter.createElement(graphs, "graph", "gid", String.valueOf(j));
				for (int k = 0; k < lineDataArray.size(); k++) {
					LineData data = lineDataArray.get(k);
					XmlAdapter.createElement(graph, "value", "xid", String.valueOf(k), data.getValues().get(j));
				}
			}
		}
		return doc;
	}

	/**
	 * 生成柱状图XML数据文件格式内容
	 * 示例：
	 * <chart>
	 * 	<series>
	 * 		<value xid="1">1950</value>
	 * 	</series>
	 * 	<graphs>
	 * 		<graph gid="1">
	 * 			<value xid="1">-0.307</value>
	 * 		</graph>
	 * 		<graph gid="2">
	 * 			<value xid="1">-0.171</value>
	 * 		</graph>
	 * 	</graphs>
	 * </chart>
	 * @param columnDataArray ColumnData类型的List集合
	 * @see ColumnData
	 * @return w3c Document对象
	 */
	public Document generateColumnXmlData(List<ColumnData> columnDataArray) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		if (columnDataArray != null && columnDataArray.size() > 0) {
			Element root = XmlAdapter.createRootElement(doc, "chart");
			Element series = XmlAdapter.createElement(root, "series");
			for (int i = 0; i < columnDataArray.size(); i++) {
				ColumnData data = columnDataArray.get(i);
				XmlAdapter.createElement(series, "value", "xid", String.valueOf(i), data.getTitle());
			}
			Element graphs = XmlAdapter.createElement(root, "graphs");
			int count = columnDataArray.get(0).getValues().size();
			for (int j = 0; j < count; j++) {
				Element graph = XmlAdapter.createElement(graphs, "graph", "gid", String.valueOf(j));
				for (int k = 0; k < columnDataArray.size(); k++) {
					ColumnData data = columnDataArray.get(k);
					XmlAdapter.createElement(graph, "value", "xid", String.valueOf(k), data.getValues().get(j));
				}
			}
		}
		return doc;
	}

	/**
	 * 生成饼状图XML格式内容.
	 * 示例：
	 * <pie>
	 * 	<slice title="Twice a day" pull_out="true">358</slice>
	 * </pie>
	 * @param pieDataArray PieData类型的List集合
	 * @see PieData
	 * @return w3c Document对象
	 */
	public Document generatePieXmlData(List<PieData> pieDataArray) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		if (pieDataArray != null && pieDataArray.size() > 0) {
			Element root = XmlAdapter.createRootElement(doc, "pie");
			for (int i = 0; i < pieDataArray.size(); i++) {
				PieData data = pieDataArray.get(i);
				Element slice = XmlAdapter.createElement(root, "slice", "title", data.getTitle(), data.getValue());
				String pullOut = data.getPullOut();
				if (pullOut != null && "true".equals(pullOut)) {
					slice.setAttribute("pull_out", "true");
				}
			}
		}
		return doc;
	}

	/**
	 * 生成曲线图XML配置文件格式内容
	 * 示例：
	 * <settings>
	 * <data_type>xml</data_type>
	 * <skip_rows>1</skip_rows>
	 * <font>微软雅黑</font>
	 * <text_size>11</text_size>
	 * <text_color />
	 * <column>
	 * 	<type></radius>
	 * 	<width>80</height>
	 * 	<spacing>0</angle>
	 * </column>
	 * ......
	 * </settings>
	 * @param title 显示的标题
	 * @see titles 要分类对比的名称集合
	 * @return w3c Document对象
	 */
	public Document generateLineXmlSetting(String title, List<String> titles) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Element root = XmlAdapter.createRootElement(doc, "settings");
		XmlAdapter.createElement(root, "data_type", "xml");
		XmlAdapter.createElement(root, "font", "微软雅黑");
		XmlAdapter.createElement(root, "text_size", "11");
		XmlAdapter.createElement(root, "digits_after_decimal", "2");

		Element legend = XmlAdapter.createElement(root, "legend");
		Element legendValues = XmlAdapter.createElement(legend, "values");
		XmlAdapter.createElement(legendValues, "enabled", "true");
		XmlAdapter.createElement(legendValues, "width", "44");
		XmlAdapter.createElement(legendValues, "align", "left");
		XmlAdapter.createElement(legendValues, "text", "${value}");

		Element graphs = XmlAdapter.createElement(root, "graphs");
		for (int i = 0; i < titles.size(); i++) {
			Element graph = XmlAdapter.createElement(graphs, "graph", "gid", String.valueOf(i));
			XmlAdapter.createElement(graph, "axis", "left");
			XmlAdapter.createElement(graph, "title", titles.get(i));
			XmlAdapter.createElement(graph, "selected", "false");
			XmlAdapter.createElementByCDATA(graph, "balloon_text", "${value}");
		}

		Element labels = XmlAdapter.createElement(root, "labels");
		Element label0 = XmlAdapter.createElement(labels, "label", "lid", "0");
		XmlAdapter.createElement(label0, "width", "");
		XmlAdapter.createElement(label0, "align", "center");
		XmlAdapter.createElement(label0, "text_color", "");
		XmlAdapter.createElement(label0, "text_size", "20");
		XmlAdapter.createElementByCDATA(label0, "text", "<b>" + title + "</b>");
		return doc;
	}

	/**
	 * 生成柱状图XML配置文件格式内容
	 * 示例：
	 * <settings>
	 * <data_type>xml</data_type>
	 * <skip_rows>1</skip_rows>
	 * <font>微软雅黑</font>
	 * <text_size>11</text_size>
	 * <text_color />
	 * <column>
	 * 	<type></radius>
	 * 	<width>80</height>
	 * 	<spacing>0</angle>
	 * </column>
	 * ......
	 * </settings>
	 * @param title 显示的标题
	 * @see titles 要分类对比的名称集合
	 * @return w3c Document对象
	 */
	public Document generateColumnXmlSetting(String title, List<String> titles) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Element root = XmlAdapter.createRootElement(doc, "settings");
		XmlAdapter.createElement(root, "data_type", "xml");
		XmlAdapter.createElement(root, "type", "column");
		XmlAdapter.createElement(root, "skip_rows", "1");
		XmlAdapter.createElement(root, "font", "微软雅黑");
		XmlAdapter.createElement(root, "text_size", "11");
		XmlAdapter.createElement(root, "text_color", "");
		XmlAdapter.createElement(root, "precision", "");
		XmlAdapter.createElement(root, "depth", "10");
		XmlAdapter.createElement(root, "angle", "10");
		XmlAdapter.createElement(root, "colors", "");

		Element column = XmlAdapter.createElement(root, "column");
		XmlAdapter.createElement(column, "type", "");
		XmlAdapter.createElement(column, "width", "80");
		XmlAdapter.createElement(column, "spacing", "0");
		XmlAdapter.createElement(column, "grow_time", "3");
		XmlAdapter.createElement(column, "grow_effect", "7");
		XmlAdapter.createElement(column, "sequenced_grow", "true");
		XmlAdapter.createElement(column, "border_color", "");
		XmlAdapter.createElement(column, "data_labels", "{value}");
		XmlAdapter.createElementByCDATA(column, "balloon_text", "{title}: {value}");
		XmlAdapter.createElement(column, "hover_color", "#EED600");

		Element plot_area = XmlAdapter.createElement(root, "plot_area");
		XmlAdapter.createElement(plot_area, "color", "");
		XmlAdapter.createElement(plot_area, "alpha", "80");
		XmlAdapter.createElement(plot_area, "border_color", "");
		Element margins = XmlAdapter.createElement(plot_area, "margins");
		XmlAdapter.createElement(margins, "left", "70");
		XmlAdapter.createElement(margins, "top", "60");
		XmlAdapter.createElement(margins, "right", "50");
		XmlAdapter.createElement(margins, "bottom", "80");

		Element grid = XmlAdapter.createElement(root, "grid");
		Element gridCategory = XmlAdapter.createElement(grid, "category");
		XmlAdapter.createElement(gridCategory, "color", "");
		XmlAdapter.createElement(gridCategory, "alpha", "5");
		XmlAdapter.createElement(gridCategory, "dashed", "");
		XmlAdapter.createElement(gridCategory, "dash_length", "");
		Element gridValue = XmlAdapter.createElement(plot_area, "value");
		XmlAdapter.createElement(gridValue, "text_color", "");
		XmlAdapter.createElement(gridValue, "alpha", "0");
		XmlAdapter.createElement(gridValue, "dashed", "");
		XmlAdapter.createElement(gridValue, "dash_length", "");
		XmlAdapter.createElement(gridValue, "fill_color", "000000");
		XmlAdapter.createElement(gridValue, "fill_alpha", "5");

		Element graphs = XmlAdapter.createElement(root, "graphs");
		for (int i = 0; i < titles.size(); i++) {
			Element graph = XmlAdapter.createElement(graphs, "graph", "gid", String.valueOf(i));
			XmlAdapter.createElement(graph, "title", titles.get(i));
		}

		Element labels = XmlAdapter.createElement(root, "labels");
		Element label0 = XmlAdapter.createElement(labels, "label", "lid", "0");
		XmlAdapter.createElement(label0, "y", "20");
		XmlAdapter.createElement(label0, "rotate", "false");
		XmlAdapter.createElement(label0, "width", "");
		XmlAdapter.createElement(label0, "align", "center");
		XmlAdapter.createElement(label0, "text_color", "");
		XmlAdapter.createElement(label0, "text_size", "20");
		XmlAdapter.createElementByCDATA(label0, "text", "<b>" + title + "</b>");

		return doc;
	}

	/**
	 * 生成饼状图XML配置文件格式内容
	 * 示例：
	 * <settings>
	 * <data_type>xml</data_type>
	 * <skip_rows>1</skip_rows>
	 * <font>微软雅黑</font>
	 * <text_size>11</text_size>
	 * <text_color />
	 * <pie>
	 * 	<radius>90</radius>
	 * 	<height>7</height>
	 * 	<angle>0</angle>
	 * </pie>
	 * ......
	 * </settings>
	 * @param title 显示的标题
	 * @return w3c Document对象
	 */
	public Document generatePieXmlSetting(String title) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Element root = XmlAdapter.createRootElement(doc, "settings");
		XmlAdapter.createElement(root, "data_type", "xml");
		XmlAdapter.createElement(root, "skip_rows", "1");
		XmlAdapter.createElement(root, "font", "微软雅黑");
		XmlAdapter.createElement(root, "text_size", "11");
		XmlAdapter.createElement(root, "text_color", "");

		Element pie = XmlAdapter.createElement(root, "pie");
		XmlAdapter.createElement(pie, "radius", "90");
		XmlAdapter.createElement(pie, "height", "7");
		XmlAdapter.createElement(pie, "angle", "0");

		Element animation = XmlAdapter.createElement(root, "animation");
		XmlAdapter.createElement(animation, "start_time", "strong");
		XmlAdapter.createElement(animation, "start_effect", "2");
		XmlAdapter.createElement(animation, "sequenced", "true");
		XmlAdapter.createElement(animation, "pull_out_time", "1.5");
		XmlAdapter.createElement(animation, "pull_out_effect", "Bounce");

		Element data_labels = XmlAdapter.createElement(root, "data_labels");
		XmlAdapter.createElement(data_labels, "text_color", "strong");
		XmlAdapter.createElement(data_labels, "text_size", "11");
		XmlAdapter.createElement(data_labels, "max_width", "true");
		XmlAdapter.createElementByCDATA(data_labels, "show", "{title}: {percents}%");

		Element legend = XmlAdapter.createElement(root, "legend");
		XmlAdapter.createElement(legend, "width", "");
		XmlAdapter.createElement(legend, "color", "");
		XmlAdapter.createElement(legend, "max_columns", "");
		XmlAdapter.createElement(legend, "alpha", "");
		XmlAdapter.createElement(legend, "border_color", "");
		XmlAdapter.createElement(legend, "border_alpha", "");
		XmlAdapter.createElement(legend, "text_color", "");
		XmlAdapter.createElement(legend, "text_size", "");
		XmlAdapter.createElement(legend, "spacing", "9");
		XmlAdapter.createElement(legend, "margins", "5");
		XmlAdapter.createElement(legend, "align", "center");

		Element labels = XmlAdapter.createElement(root, "labels");
		Element label0 = XmlAdapter.createElement(labels, "label", "lid", "0");
		XmlAdapter.createElement(label0, "y", "20");
		XmlAdapter.createElement(label0, "rotate", "false");
		XmlAdapter.createElement(label0, "width", "");
		XmlAdapter.createElement(label0, "align", "center");
		XmlAdapter.createElement(label0, "text_color", "");
		XmlAdapter.createElement(label0, "text_size", "20");
		XmlAdapter.createElementByCDATA(label0, "text", "<b>" + title + "</b>");

		return doc;
	}

	public static void main(String args[]) throws Exception {
		Document document = new AmchartsManager().generatePieXmlSetting("金牌对比");
		XmlAdapter.writeXmlToOutputStream(document, System.out);
	}
}
