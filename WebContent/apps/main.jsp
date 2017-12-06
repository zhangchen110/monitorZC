<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="x-viewport">
<head>
    <title></title>
	<%@ include file="/common/meta.jsp"%>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<meta http-equiv="Cache-Control" content="no-store"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
    <link type="text/css" href="${ctx}/css/menu.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/js/menu.js"></script>
	<style type="text/css">
* { margin:0;
    padding:0;
}
body { background:rgb(74,81,85); }
</style>
<script type="text/javascript">
	function executeAlarm(){
		$.get("${ctx}/alarmlog_queryAlarmMessage.do", {		
			}, function(data) {
			
			if(data!=null){
				var msgArr=data.split(";");
				for(i=0;i<msgArr.length;i++){
				var msg=msgArr[i];
					if(msg!=""&&msg!=null){
					//	showAlarm(msg);
					}
				}
			}
			});
	}

	function cli(){
		$("#cameraId").attr("url","${ctx}/apps/zhanCamera.jsp");
	}
	$(document).ready(function() {
		$("a").click(function(){
			var url = $(this).attr("url");
			var id = $(this).attr("id");
			if(url!= ""&&url!=undefined){
				$("#iframe").attr("src",url);
				if(id=="cameraId"){
					$(this).attr("url","");
					setTimeout('cli()', 15000 );
				}else{
					$("#cameraId").attr("url","${ctx}/apps/zhanCamera.jsp");
				}
			}
		});
		setInterval('executeAlarm()', 5000 );
	});
</script>
</head>
<body>
<div id="menu">
    <ul class="menu">
    	<li><a url="${ctx}/jointOilCompressor.do"><span>平面图</span></a></li>
        <li><a url="" class="parent"><span>机房监控</span></a>
            <div>
            	<ul>
            		<s:iterator value="machineRoomList" status="s1" var="mr">
	                	<li>
	                	<a url="${ctx}/indexcom.do?roomId=${id}" class="parent"><span>${roomName}</span></a>
	                	<div>
	                	<s:if test="#mr.compressors.size>0">
		                	<s:iterator value="#mr.compressors" status="s2" var="com">
		                	<ul>
		                		<li><a url="${ctx}/compressorRealTimeMonitor.do?comCode=${com.compressorCode}" class="parent"><span>${compressorName}</span></a></li>
		                	</ul>
		                	</s:iterator>
	                	</s:if>
	                	</div>
	                	</li>
                	</s:iterator>
            	</ul>
            </div>
        </li>
        <li><a url="${ctx}/jointOilWell.do" class="parent"><span>油井监控</span></a>
            <div>
            	<ul>
	                <s:iterator value="wellList" status="s" var="w">
	                <li><a url="${ctx}/wellreal_excute.do?wellNo=${wellNo}"><span>${w.wellNo}</span></a></li>
	                </s:iterator>
            	</ul>
           	</div>
        </li>
	<li><a url="" class="parent"><span>视频监控</span></a>
		<div>
           	<ul> 
                <li><a url="${ctx}/apps/allCamera.jsp"><span>机房监控</span></a></li>
                <li><a id="cameraId" url="${ctx}/apps/zhanCamera.jsp"><span>厂区监控</span></a></li>
           	</ul>
        </div>
	</li>
        <li><a url=""><span>班报</span></a>
        	<div>
            	<ul> 
	                <li><a url="${ctx}/statistics_listclassreport.do"><span>油井班报</span></a></li>
	                <li><a url="${ctx}/record_execute.do"><span>压缩机班报</span></a></li>
            	</ul>
           	</div>
        </li>
        <li><a url=""><span>历史数据查询</span></a>
        	<div>
            	<ul> 
	                <li><a url="${ctx}/statistics.do"><span>油井历史记录</span></a></li>
	                <li><a url="${ctx}/compressorHistoryRecord.do"><span>压缩机历史记录</span></a></li>
	                <li><a url="${ctx}/machineRoomRecord.do"><span>机房历史记录</span></a></li>
            	</ul>
           	</div>
        </li>
        <li><a url="${ctx}/alarmlog.do"><span>报警日志查询</span></a></li>
         <li><a url=""><span>基础信息录入</span></a>
        	<div>
            	<ul> 
	                <li><a url="${ctx}/well.do"><span>油井指标信息</span></a></li>
	                <li><a url="${ctx}/compressor.do"><span>压缩机指标信息</span></a></li>
	                <li><a url="${ctx}/machineRoom.do"><span>机房指标信息</span></a></li>
            	</ul>
           	</div>
        </li>
    </ul>
</div>
<div id="ifr" style="width: 100%;">
	<iframe id="iframe" src="jointOilCompressor.do" style="width: 100%;height: 1040px;" >
	
	</iframe>
</div>
</body>
</html>