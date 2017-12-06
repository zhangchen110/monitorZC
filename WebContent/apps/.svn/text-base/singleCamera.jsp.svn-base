<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>单监控画面</title>
<script type="text/javascript">
document.oncontextmenu=function(e){return   false;}
document.onkeydown = function(event){ 

    event = window.event|| event;  
    if(event.keyCode==116 ||event.keyCode==8){  
        event.keyCode =0;  
        event.returnvalue = false;  
        return false;
    }  
}  
</script>
</head>
<body style="TEXT-ALIGN: center;margin:0 auto">
	<div style="height: 500px; text-align:center">
	<iframe scrolling="no"  id="singleCamera" src="<%=basePath%>viewjpeg.html?live=1.${num}&chname=${num}" style="width: 700px;height: 500px; "></iframe>
	</div>

</body>
</html>