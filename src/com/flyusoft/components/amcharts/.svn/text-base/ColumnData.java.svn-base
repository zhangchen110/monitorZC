package com.flyusoft.components.amcharts;

import java.util.List;

import com.google.common.collect.Lists;

/** 
 * 柱状图数据对象
 */
public class ColumnData {

	//要显示的内容
	private String title;
	//此内容下的数据集合
	private List<String> values = Lists.newArrayList();
	/**
	 * 示例：要显示2009年，2010年，2011年的拥有汽车的人数和没有汽车的人数的对比
	 * 2009年有汽车是500M人，没有汽车的是100000M
	 * 2010年有汽车是600M人，没有汽车的是99000M
	 * 2011年有汽车是700M人，没有汽车的是98000M
	 * 数据是：title是拥有汽车的人数，values是500M，600M，700M；title是没有汽车的人数，values是100000M，99000M，98000M
	 */
	
	public ColumnData(String title, List<String> values) {
		this.title = title;
		this.values = values;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

}
