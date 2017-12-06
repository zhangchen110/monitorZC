<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Flash Chart演示</title>
	<%@ include file="/common/meta.jsp"%>

</head>

<body>
		<div style="text-align:center">
		<h1>Flash Chart演示</h1>

		<h2>技术说明：</h2>

		<p>使用FusionCharts渲染Flash图表</p>
		<div id="report1Content"></div>
		<script type="text/javascript">
            var chart = new FusionCharts("${ctx}/fusionCharts/FusionCharts/MSColumn3D.swf", "ChartId1", "560", "400", "0", "0");
            chart.setXMLData('${colXml}');
            chart.render("report1Content");
        </script>

		<div id="report2Content"></div>
		<script type="text/javascript">
		 var chart = new FusionCharts("${ctx}/fusionCharts/FusionCharts/Pie3D.swf", "ChartId2", "560", "400", "0", "0");
		   chart.setXMLData('${pieXml}');		   
		   chart.render("report2Content");
		</script>
		
		<div id="report3Content"></div>

		<script type="text/javascript">
		var chart = new FusionCharts("${ctx}/fusionCharts/FusionCharts/MSLine.swf", "ChartId3", "560", "400", "0", "0");
			 chart.setXMLData('${lineXml}');		   
			 chart.render("report3Content");
		</script>
		</div>
</body>
</html>