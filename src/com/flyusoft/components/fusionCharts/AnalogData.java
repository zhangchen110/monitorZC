package com.flyusoft.components.fusionCharts;

import java.util.Arrays;
import java.util.List;

/**
 * 报表演示的模拟数据提供类.
 * @author Yanglongquan
 * 2011-9-26
 * yanglongquan@flyu.com
 *
 */
public class AnalogData {

	public static List<ColData> getDummyColumnData() {
		return Arrays.asList(new ColData[] { new ColData("1999年", Arrays.asList("100", "125", "150","130","105")),
				new ColData("2000年", Arrays.asList("200", "175", "210", "180", "210")),
				new ColData("2001年", Arrays.asList("170", "200", "100", "140", "122")),
				 });
	}

	public static List<LineData> getDummyLineData() {
		return Arrays.asList(new LineData[] { 
				new LineData("1999年", Arrays.asList("2000", "2125","1500", "1925", "1625","1500", "1825", "1325", "1525","1700", "2125", "1825")),
				new LineData("2000年", Arrays.asList("1000", "3000", "1725","1500", "1125", "1825","1600", "1425", "2025","1600", "2025", "1125")) 
				});
	}

	public static List<PieData> getDummyPieData() {
		return Arrays.asList(new PieData[] { new PieData("中国 金牌", true, "100"), new PieData("美国 金牌", false, "50"),
				new PieData("俄罗斯 金牌", false, "35"), new PieData("德国 金牌", false, "25"),new PieData("其他国家 金牌", false, "15") });
	}
	
	public static List<String> getColCaption(){
		return Arrays.asList(new String[]{"中国","德国","美国","英国","俄罗斯"});
	}
	public static List<String> getLineCaption(){
		return Arrays.asList(new String[]{"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"});
	}
}
