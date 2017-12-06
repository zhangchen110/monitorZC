<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>监控页面</title>
<%@ include file="/common/meta.jsp"%>
</head>
<body >
	<div style="text-align:center;">
	<embed autostart="true" type="application/x-vlc-plugin" pluginspage="http://www.videolan.org" 
	version="VideoLAN.VLCPlugin.2" width="700" height="568" id="vlc" target="rtsp://192.168.1.163" >
	</embed>
	</div>
</body>
</html>