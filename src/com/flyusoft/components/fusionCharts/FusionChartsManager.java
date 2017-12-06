package com.flyusoft.components.fusionCharts;

import java.io.StringWriter;
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
 * 生成xml文件工具类
 * 
 * @author Yanglongquan 2011-9-26 yanglongquan@flyu.com
 * 
 */

@Component
public class FusionChartsManager {

	/**
	 * 生成线图
	 *<chart caption="Production Forecast" yAxisName="Units" numVDivLines="10" valuePosition="auto">
	<categories>
		<category label="2006" /> 
		<category label="2007" /> 
		<category label="2008" /> 
		<category label="2009" /> 
		<category label="2010" /> 
		<category label="2011" /> 
	</categories>
	<dataset seriesName="Model A12" color="A66EDD" >
		<set value="35" /> 
		<set value="42" /> 
		<set value="31" /> 
		<set value="28" /> 
		<set value="34" /> 
		<set value="30" /> 
	</dataset>
	<dataset seriesName="Model A15" color="F6BD0F">
		<set value="22" /> 
		<set value="25" /> 
		<set value="18" /> 
		<set value="22" /> 
		<set value="17" /> 
		<set value="16" />
	</dataset>
</chart>
	 * @return
	 * @throws Exception
	 */
	public Document generateLineXmlData(String _caption,List<LineData> _lineDatas
			,List<String> _categories,String _unit) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap=Maps.newHashMap();
		rootMap.put("caption", _caption);
		rootMap.put("yAxisName", _unit);
		rootMap.put("numVDivLines", "10");
		rootMap.put("numVDivLines", "auto");
		rootMap.put("bgColor", "F7F7F7, E9E9E9");
		rootMap.put("divLineAlpha", "30");
		rootMap.put("labelPadding", "10");
		rootMap.put("yAxisValuesPadding", "10");
		rootMap.put("showValues", "1");
		
		
		Element root=XmlAdapter.createRootElement(doc, "chart",rootMap);
		Element categories=XmlAdapter.createElement(root, "categories");
		if(_categories!=null){
			for (String cName : _categories) {
				XmlAdapter.createElement(categories, "category","label",cName);
			}
		}
		if(_lineDatas!=null){
			for (LineData line : _lineDatas) {
				Element dataset=XmlAdapter.createElement(root, "dataset","seriesName",line.getTitle());
				for (String value : line.getValues()) {
					XmlAdapter.createElement(dataset, "set","value",value);
				}
			}
		}
		return doc;
	}
	
	/**
	 * <chart caption="Alphabet Usage in a Novel"> 
		<set label="B" value="51852" /> 
		<set label="C" value="88168" /> 
		<set label="D" value="73897" /> 
		<set label="E" value="93933" /> 
		<set label="F" value="19289" /> 
		<set label="G" value="79623" /> 
		<set label="H" value="48262" /> 
		<set label="I" value="29162" /> 
		<set label="J" value="96878" /> 
		<set label="K" value="81241" /> 
		<set label="L" value="40652" isSliced="1"/> 
		<set label="M" value="37581" isSliced="1"/> 
		<set label="N" value="2882" /> 
		<set label="O" value="746" /> 
		<set label="P" value="7155" /> 
		<set label="Q" value="12072" /> 
		<set label="R" value="45608" /> 
		<set label="S" value="72570" /> 
		<set label="T" value="44799" />
		<set label="U" value="71887" />
		<set label="V" value="78170" />
		</chart>
	 * 生成饼图
	 * @return
	 * @throws Exception
	 */
	public Document generatePieXmlData(String _caption,List<PieData> _pieDatas) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap=Maps.newHashMap();
		rootMap.put("caption", _caption);
		
		Element root=XmlAdapter.createRootElement(doc, "chart", rootMap);
		if(_pieDatas!=null){
			for (PieData pieData : _pieDatas) {
				Map<String, String> setMap=Maps.newHashMap();
				setMap.put("label", pieData.getTitle());
				setMap.put("value", pieData.getValue());
				if(pieData.isPullOut()){
					setMap.put("isSliced","1");
				}
				XmlAdapter.createElement(root, "set",setMap);
			}
		}
		return doc;
	}
	
	/**
	 * 生成柱图
	 * <chart caption="Country Comparison" showLabels="1" showvalues="0" decimals="0" numberPrefix="$">
		<categories>
			<category label="Austria" />
			<category label="Brazil" />
			<category label="France" />
			<category label="Germany" />
			<category label="USA" />
		</categories>
		<dataset seriesName="1996" color="AFD8F8" showValues="0">
			<set value="25601.34" />
			<set value="20148.82" />
			<set value="17372.76" />
			<set value="35407.15" />
			<set value="38105.68" />
		</dataset>
		<dataset seriesName="1997" color="F6BD0F" showValues="0">
			<set value="57401.85" />
			<set value="41941.19" />
			<set value="45263.37" />
			<set value="117320.16" />
			<set value="114845.27" />
		</dataset>
		<dataset seriesName="1998" color="8BBA00" showValues="0">
			<set value="45000.65" />
			<set value="44835.76" />
			<set value="18722.18" />
			<set value="77557.31" />
			<set value="92633.68" />
		</dataset>
		</chart>
	 * @param  _title :标题
	 * @param  _colDatas :数据集
	 * @return
	 * @throws Exception
	 */
	public Document generateColXmlData(String _caption,List<ColData> _colDatas,List<String> _categories) throws Exception {
		Document doc = XmlAdapter.getNewDocument();
		Map<String, String> rootMap=Maps.newHashMap();
		rootMap.put("caption",_caption);//标题
		rootMap.put("showLabels","1");
		rootMap.put("decimals","3");//3位小数
		rootMap.put("forceDecimals","1");//设置为转换小数
		rootMap.put("numberPrefix","$");//前缀为$符号
		
		Element root=XmlAdapter.createRootElement(doc, "chart", rootMap);
		
		Element categories=XmlAdapter.createElement(root, "categories");
		if(_categories!=null){
			for (String cName : _categories) {
				XmlAdapter.createElement(categories, "category","label",cName);
			}
		}
		if(_colDatas!=null){
			for (ColData col : _colDatas) {
				Element dataset=XmlAdapter.createElement(root, "dataset","seriesName",col.gettitle());
				for (String value : col.getValues()) {
					XmlAdapter.createElement(dataset, "set","value",value);
				}
			}
		}
		
		return doc;
	}
	/**
	 * 生成doc字符串
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	public String toDocString(Document doc) throws Exception {
			
			StringWriter sw = new StringWriter();
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.transform(new DOMSource(doc), new StreamResult(sw));
			
			return sw.toString().replace(
					"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>","");
	}
}