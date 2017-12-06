<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="x-viewport">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<link href="${ctx}/css/home.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.wellfontcss{
				font-size: 12px;
				font-weight: bold;
				text-align:center;

			}
		</style>
		<script type="text/javascript">
		
	function toSingleWell(wellNo){
			window.open("${ctx}/wellreal_excute.do?wellNo="+wellNo);
		}
		
		function updateChart(){
			$.get("${ctx}/jointOilWell_realTime.do", {		
			}, function(data) {
				var array = data.split(";");
				for(var i = 0; i < array.length; i++){
					var str = array[i].split(",");
					var wellNo = str[0];
					if(wellNo!="no"){
					//柱形
					var temRef = getChartFromId("chart_" + wellNo + "_1_1");
					
					var preRef = getChartFromId("chart_" + wellNo + "_2_1");
					//var iflowRef = getChartFromId("chart_" + wellNo + "_3_1");
					//var aflowRef = getChartFromId("chart_" + wellNo + "_4_1");
					//曲线
					var temCurveRef = getChartFromId("chart_" + wellNo + "_1_2");
					var preCurveRef = getChartFromId("chart_" + wellNo + "_2_2");
					//var iflowCurveRef = getChartFromId("chart_" + wellNo + "_3_2");
					//var aflowCurveRef = getChartFromId("chart_" + wellNo + "_4_2");
					
					var temValue = str[1];
					var preValue = str[2];
					var iflowValue = str[3];
					var aflowValue = str[4];
					
					var currDate = str[5];
					var alarmType=str[6];
					
					//Build data string in format &label=...&value=...
					var temData = "&label=" + currDate + "&value=" + temValue;
					var preData = "&label=" + currDate + "&value=" + preValue;
					//var iflowData = "&label=" + label + "&value=" + iflowValue;
					//var aflowData = "&label=" + label + "&value=" + aflowValue;
					
					var temCurveData = "&label=" + "" + "&value=" + temValue;
					var preCurveData = "&label=" + "" + "&value=" + preValue;
					//var iflowCurveData = "&label=" + "" + "&value=" + iflowValue;
					//var aflowCurveData = "&label=" + "" + "&value=" + aflowValue;
					
					//Feed it to chart.
					temRef.feedData(temData);
					preRef.feedData(preData);
					var preNumValue=$("#"+wellNo+"_value");
					if(preNumValue!=null){
						preNumValue.text(preValue+"Mpa");
					}
					//iflowRef.feedData(iflowData);
					//aflowRef.feedData(aflowData);
					
					//实时更新
					$("#" + wellNo).find("h3").replaceWith(
							"<h3 class='wellfontcss'>井号："+wellNo+"&nbsp;<label id='"+wellNo+"sjll'>瞬时流量："
							+iflowValue+"</label>&nbsp;累计流量："+aflowValue+"监测时间:"+currDate+"</h3>");
					
					temCurveRef.feedData(temCurveData);
					preCurveRef.feedData(preCurveData);
					//iflowCurveRef.feedData(iflowCurveData);
					//aflowCurveRef.feedData(aflowCurveData);
					var alarmArr=alarmType.split("_");
						for(j=0;j<alarmArr.length;j++){
							var alarmName=alarmArr[j];
							if(alarmName=="no"){
								$("#chart_"+wellNo+"_1_1").css("border-color","#FFFFFF");
								$("#chart_"+wellNo+"_2_1").css("border-color","#FFFFFF");
								$("#"+wellNo+"sjll").css("border-color","#FFFFFF");
							}else if(alarmName=="TEM"){
								$("#chart_"+wellNo+"_1_1").css("border-color","#FF0000");
							}else if(alarmName=="PRE"){
								$("#chart_"+wellNo+"_2_1").css("border-color","#FF0000");
							}else if(alarmName=="SJLL"){
								$("#"+wellNo+"sjll").css("border-color","#FF0000");
							}
						}
				}
				}
			});
		}
		$(document).ready(function() {
			var str="${alarmString}";
			if(str!=null&&str!=""){
				var arr=str.split(";");
				for(i=0;i<arr.length;i++){
					var indexArrStr=arr[i];
					var indexArr=indexArrStr.split("_");
					var wNo=indexArr[0];
					for(var m=0;m<indexArr.length;m++){
						var alarmmsg=indexArr[m];
						if(alarmmsg=="tem"){
							$("#chart_"+wNo+"_1_1").css("border-color","#FF0000");
						}else if(alarmmsg=="pre"){
							$("#chart_"+wNo+"_2_1").css("border-color","#FF0000");
						}else if(alarmmsg=="sjll"){
							$("#"+wNo+"sjll").css("border-color","#FF0000");
						}
					}
				}
			}
			setInterval('updateChart()', 5000 );	
		});
		</script>
	</head>
	<body id="ext-gen7" class=" ext-gecko x-border-layout-ct" style="position: relative;">
	
		
		<div id="ext-well" class="x-panel x-border-panel x-panel-noborder" style="left: 0px; top: 0px; width: 1920px;">
			<div id="ext-gen15" class="x-panel-bwrap">
				<s:iterator value="wellList" var="w">
				<div id="ext-gen16" class="x-panel-body x-panel-body-noheader x-panel-body-noborder x-frame-mask-target " style="float:left;width: 480px;">
					<div id="${wellNo}"  style="margin: 5px; height: 330px; width: 460px; border: solid #99BBE8 1px;" onclick="toSingleWell('${wellNo}')">
						<h3 class="wellfontcss">井号：${wellNo}&nbsp;<label id="${wellNo}sjll">瞬时流量：${insString}</label>&nbsp;累计流量：${accString}&nbsp;监测时间:${monitorTime}</h3>
							<s:iterator value="xmlList" var="xml" status="s">
							<s:if test="#s.count==1">
							<div id="chart_${w.wellNo}_${s.count}_1" style="float:left;height: 145px; width: 170px; text-align:right;">					
								${xml}
							</div>
							</s:if>
							<s:else>
							<div style="float:left;height: 145px; width: 170px; text-align:center;">					
								<div id="${w.wellNo}_value" style="width: 170px ;height:20px; text-align:center;">${w.preValue}Mpa</div>
								<div id="chart_${w.wellNo}_${s.count}_1" style="float:left;height: 125px; width: 170px; text-align:center;">${xml}</div>
								
							</div>
							
							</s:else>
							<div id="chart_${w.wellNo}_${s.count}_2" style="float:left; height: 145px; width: 280px;">	
							曲线图			
							</div>
						<script type="text/javascript">
						   var countTmp="${s.count}";
						   if(countTmp==1){
							   var chart = new FusionCharts("${ctx}/fusionWidgets/Charts/Thermometer.swf", "chart_${w.wellNo}_${s.count}_1", "125", "135", "0", "1");
							   chart.setDataXML('${xml}');
							   chart.render("chart_${w.wellNo}_${s.count}_1");
						   }else if(countTmp==2){
							   var chart = new FusionCharts("${ctx}/fusionWidgets/Charts/AngularGauge.swf", "chart_${w.wellNo}_${s.count}_1", "160", "80", "0", "1");
							   chart.setDataXML('${xml}');
							   chart.render("chart_${w.wellNo}_${s.count}_1");
						   }
							//$("#chart_${w.wellNo}_${s.count}_1").find("p").replaceWith("<p class='LjLLcss'>"+'${xml}'+"</p>");
						
						</script>
						<script type="text/javascript">	 
						   var chart = new FusionCharts("${ctx}/fusionWidgets/Charts/RealTimeLine.swf", "chart_${w.wellNo}_${s.count}_2", "280", "125", "0", "1");
						   chart.setDataXML('${curveXmlList[s.index]}');
						   chart.render("chart_${w.wellNo}_${s.count}_2");
						</script>
						</s:iterator>
					</div>			
				</div>
				</s:iterator>
			</div>
		</div>
	</body>
</html>