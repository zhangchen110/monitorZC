﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
document.oncontextmenu=function(e){return   false;}
document.onkeydown = function(event){ 

    event = window.event || event;  
    if(event.keyCode==116||event.keyCode==8){  
        event.keyCode =0;  
        event.returnvalue = false;  
        return false;
    }  
}  
</script>
<title>监控页面</title>
</head>
<body >
	<div style="text-align:center;background-color:#000000;">
<%--
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">四机房1号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">四机房2号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">四机房3号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">二机放1号</div>
	<iframe id="J4-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.6&chname=6" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J4-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.7&chname=7" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J4-C3" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.8&chname=8" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J2-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.3&chname=3" style="float: left;width: 462px;height: 340px;"></iframe>
	 
	
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">一机房1号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">一机房2号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">三机房1号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">三机放2号</div>
	<iframe id="J1-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.1&chname=1" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J1-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.2&chname=2" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J3-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.4&chname=4" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J3-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.5&chname=5" style="float: left;width: 462px;height: 340px;"></iframe>

	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">五机房1号</div>
	<div style="float: left;width: 463px;height: 20px;background-color:#FFFFFF;">五机房2号</div>
	<div style="float: left;width: 463px;height: 20px;"></div>
	<div style="float: left;width: 463px;height: 20px;"></div>
	
	<iframe id="J5-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.9&chname=9" style="float: left;width: 462px;height: 340px;"></iframe>
	<iframe id="J5-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.10&chname=10" style="float: left;width: 462px;height: 340px;"></iframe>
	 --%>
	</div>
</body>
</html>