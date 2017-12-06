<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<style type="text/css">
		  body{TEXT-ALIGN: center;}
		  
		   div.mainone{
		    width:1700px;
		    height:750px;
			MARGIN-RIGHT: auto;
			MARGIN-LEFT: auto;
		  }
		  
		   div.mmnn { 
		     margin:5px;float:left;width:550px; height:300px;background-color: #FFFFFF;border:2px solid #D6DEFA;
		  }
		   div.mmni { 
		     margin:5px;float:left;width:550px; height:400px;background-color: #FFFFFF;border:2px solid #D6DEFA;
		  }
		   div.leiji { 
		    font-size:23px;margin:5px;float:left;width:1680px; height:40px;background-color: #FFFFFF;border:2px solid #D6DEFA;
		  }
		   
		</style>
		<script type="text/javascript">
	function updateChart() {
		var wellId = $("#wellNo").val(); //获取井Id
		$.get("${ctx}/wellreal_realTimeCurve.do?wellNo=" + wellId, {},
				function(data) {
					if(data=='isnull'){//无数据不执行
						return;
					}
					var array = data.split(",");
					var wellNo = array[0];
	 
					var pre1Ref = getChartFromId("chart_pre1_1");
					var pre2Ref = getChartFromId("chart_pre1_2");
					var tem1Ref = getChartFromId("chart_tem1_1");
					var tem2Ref = getChartFromId("chart_tem1_2");
					var ins1Ref = getChartFromId("chart_ins1_1");
					var ins2Ref = getChartFromId("chart_ins1_2");
					 

					var temValue = array[1];
					var preValue = array[2];
					var iflowValue = array[3];
					var aflowValue = array[4];
					var minitorDate = array[5];
					var alarmTmp=array[7];
					var temData = "&label=" + minitorDate + "&value="
							+ temValue;
					var preData = "&label=" + minitorDate + "&value="
							+ preValue;
					var iflowData = "&label=" + minitorDate + "&value="
							+ iflowValue;
					var aflowData = "&label=" + minitorDate + "&value=" + aflowValue;
					//Feed it to chart.
					pre1Ref.feedData(preData);
					pre2Ref.feedData(preData);
					tem1Ref.feedData(temData);
					tem2Ref.feedData(temData);
					ins1Ref.feedData(iflowData);
					ins2Ref.feedData(iflowData);
					$("#accref").text(aflowValue);
					$("#datetime").text(array[6]);
					alarmArr=alarmTmp.split("_");
					 
					for(m=0;m<alarmArr.length;m++){
							var alarm=alarmArr[m];
							if(alarm=="no"){
									$("#chart_tem_1").css("border-color","#FFFFFF");
									$("#chart_pre_1").css("border-color","#FFFFFF");
									$("#chart_ins_1").css("border-color","#FFFFFF");
									$("#chart_tem_2").css("border-color","#FFFFFF");
									$("#chart_pre_2").css("border-color","#FFFFFF");
									$("#chart_ins_2").css("border-color","#FFFFFF");
							}else{
								$("#chart_"+alarm+"_1").css("border-color","#FF0000");
								$("#chart_"+alarm+"_2").css("border-color","#FF0000");
							}
					}
				});
				 
	}
	$(document).ready(function() {
		var str="${alarmString}";
			if(str!=null&&str!=""){
				var arr=str.split(",");
				for(k=0;k<arr.length;k++){
					var alarm=arr[k];
					//alert(alarm);
					//$("#chart_"+alarm+"_1").css("border-color","#FF0000");
					//$("#chart_"+alarm+"_2").css("border-color","#FF0000");
				}
			}
		setInterval('updateChart()', 5000);
	});
	
</script>
	</head>

	<body>
	
		<input type="hidden" id="wellNo" value="${wellNo}" />
			 <div id="mainone" class="mainone">
		 			 <div  class="leiji" align="center"> 当前井号为：${wellNo} 　　监测时间：<label id="datetime">${datetime }</label> 　　累计流量为：<label  id="accref">${monitorData.accumulativeFlow}</label>${ indexACC.unit}</div>
					 <div  align='center' class="mmnn"   id="chart_pre_1"  ></div>
					 <div  align='center' class="mmnn"   id="chart_tem_1"  ></div>
					 <div  align='center' class="mmnn"   id="chart_ins_1"  ></div>

					 <div  align='center' class="mmni"    id="chart_pre_2"  ></div>
					 <div  align='center' class="mmni"    id="chart_tem_2"  ></div>
					 <div  align='center' class="mmni"    id="chart_ins_2"  ></div>
			 </div>

		<script type="text/javascript">
	var chartpre = new FusionCharts(
			"${ctx}/fusionWidgets/Charts/AngularGauge.swf", "chart_pre1_1",
			"450", "250", "0", "1");
	chartpre.setDataXML('${prexml}');
	chartpre.setTransparent(true);
	chartpre.render("chart_pre_1");

	var chartpre1 = new FusionCharts(
			"${ctx}/fusionWidgets/Charts/RealTimeLine.swf", "chart_pre1_2",
			"520", "400", "0", "1");
	chartpre1.setDataXML('${precurveXml}');
	chartpre1.render("chart_pre_2");

	var charttem = new FusionCharts(
			"${ctx}/fusionWidgets/Charts/Thermometer.swf", "chart_tem1_1",
			"160", "280", "0", "1");
	charttem.setDataXML('${temxml}');
	charttem.render("chart_tem_1");

	var charttem1 = new FusionCharts(
			"${ctx}/fusionWidgets/Charts/RealTimeLine.swf", "chart_tem1_2",
			"520", "400", "0", "1");
	charttem1.setDataXML('${temcurveXml}');
	charttem1.render("chart_tem_2");

	var chartins = new FusionCharts(
			"${ctx}/fusionWidgets/Charts/AngularGauge.swf", "chart_ins1_1",
			"450", "250", "0", "1");
	chartins.setDataXML('${insxml}');
	chartins.render("chart_ins_1");

	var chartins1 = new FusionCharts(
			"${ctx}/fusionWidgets/Charts/RealTimeLine.swf", "chart_ins1_2",
			"520", "400", "0", "1");
	chartins1.setDataXML('${inscurveXml}');
	chartins1.render("chart_ins_2");
</script>
	<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">
				<script language="JavaScript"> 			
				   //弹出DIV提示
				   $("#mainone").hide();
	               showMessage("<s:property escape="false"/>");
	               
	       		</script>
			</s:iterator>
		</s:if>
	</body>
</html>
