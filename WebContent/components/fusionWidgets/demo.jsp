<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<script type="text/javascript" src="${ctx}/fusionWidgets/Charts/FusionCharts.js"></script>
		<script type="text/javascript">
			   function updateData(){
				   $.get("fusionWidgets_getDataXml.do", {},
						   function(data){
					   		var $data=$(data);
					   		$data.find("ctype").each(function(){
					   			var typeName=$(this).attr("id");
					   			if(typeName.trim()=="plate"){
					   				
						   			 var chartObj = getChartFromId("ChId1");
						   			 chartObj.setDataXML($(this).xml());
						   			
					   			}else if(typeName.trim()=="pillar"){
					   				 var chartObj = getChartFromId("ChId2");
						   			 chartObj.setDataXML($(this).xml());
					   			}
					   		});
						   },"xml");
				   setTimeout('updateData()',5000);
			   }
			   $(document).ready(function() {
				   var chart1 = new FusionCharts("${ctx}/fusionWidgets/Charts/AngularGauge.swf", "ChId1", "300", "100", "0", "1");
				   chart1.setDataURL("${ctx}/components/fusionWidgets/RealTime1.xml");
				   chart1.render("chart1div");
				   var chart2 = new FusionCharts("${ctx}/fusionWidgets/Charts/HLinearGauge.swf", "ChId2", "300", "80", "0", "1");
				   chart2.setDataURL("${ctx}/components/fusionWidgets/RealTime2.xml");
				   chart2.render("pillar1div");
				   setTimeout('updateData()',2000);
			   });
		</script>
	</head>
	<body style="text-align: center;">
	<div id="bodyDiv">
			<div id="chart1div">
		 	 This text is replaced by the Flash movie.
			</div>
			<div id="pillar1div">
			  This text is replaced by the Flash movie.
			</div>
			
	</div>
		
	</body>
</html>