package com.flyusoft.components.fusionWidgets;
/**
 * 段数据
 * @author Yanglongquan
 * 2011-9-23
 * yanglongquan@flyu.com
 *
 */
public class FWColumnData {
	private String label;
	private String value;
	
	
	public FWColumnData() {
		super();
	}
	public FWColumnData(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
