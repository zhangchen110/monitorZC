package com.flyusoft.components.amcharts;

import java.util.Arrays;
import java.util.List;

/**
 * 报表演示的模拟数据提供类.
 * 
 * @author helin
 */
public class DummyDataFetcher {

	public static List<ColumnData> getDummyColumnData() {
		return Arrays.asList(new ColumnData[] { new ColumnData("1999", Arrays.asList("100", "125", "150")),
				new ColumnData("2000", Arrays.asList("200", "225", "250")),
				new ColumnData("2001", Arrays.asList("300", "325", "350")),
				new ColumnData("2002", Arrays.asList("400", "425", "450")) });
	}

	public static List<LineData> getDummyLineData() {
		return Arrays.asList(new LineData[] { new LineData("1999", Arrays.asList("1100", "2125")),
				new LineData("2000", Arrays.asList("2200", "5225")), new LineData("2001", Arrays.asList("1300", "5325")),
				new LineData("2002", Arrays.asList("3400", "4425")) });
	}

	public static List<PieData> getDummyPieData() {
		return Arrays.asList(new PieData[] { new PieData("中国 金牌", "true", "100"), new PieData("美国 金牌", "", "50"),
				new PieData("俄罗斯 金牌", "", "35"), new PieData("德国 金牌", "", "25"),new PieData("其他国家 金牌", "", "15") });
	}
}
