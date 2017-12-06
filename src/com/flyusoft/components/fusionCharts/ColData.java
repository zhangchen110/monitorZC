package com.flyusoft.components.fusionCharts;

import java.util.List;

import com.google.common.collect.Lists;

/** 
 * 柱状图数据对象
 */
public class ColData {

	//要显示的内容
	private String title;
	
	private	List<String> values=Lists.newArrayList();//显示值

	
	public ColData(String title, List<String> values) {
		super();
		this.title = title;
		this.values = values;
	}

	public ColData() {
		super();
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	


	
	
	
}
