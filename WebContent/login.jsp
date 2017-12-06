<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>HR产品登录页</title>
<META content="IE=9.0000" http-equiv="X-UA-Compatible">
<META name="copyright" content="沈阳福隆宇数据技术有限公司版权所有 Copyright (c) 2011">
<META name="viewport" content="minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, width=device-width, user-scalable=no">
<META name="msapplication-window" content="width=1024;height=768">
<META name="google-site-verification" content="ooeu0Ygs68PA-Vyx1AiufsVIVVbkU7RukGiAeXhSxlA">
<META content="IE=Edge" http-equiv="X-UA-Compatible">
<link href="${ctx}/css/menus.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/login.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/js/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$("#loginForm").focus();
			//为mainForm注册validate函数
			$("#loginForm").validate({
				rules: {
					loginName: "required",
					password: "required"
				}
			});	
		});
		document.onkeydown = function(event) {
			var e = event ? event :(window.event ? window.event : null);
			if(e.keyCode == 13) {
				login();
			}
			
		}
		function login(){
			$("#loginForm").submit();
		}
		</script>
		</head>
<body>
<form action="login.do" id="loginForm" name="loginForm" method="post">
<div class="building"><!--建筑物背景--></div>
<div class="cloud01"><!--白云--></div>
<div class="cloud02"><!--白云--></div>
<!--登录区begin-->
<div class="login_box">
   <div class="log_con">
       <ul>
           <li class="log_li1"><span>帐号：</span></li>
           <li class="log_li2"><input id="loginName" name="loginName" value="${loginName}" type="text" /></li>
           <li class="log_li1"><span>密码：</span></li>
           <li class="log_li2"><input type="password" id="password" name="password" value="${password}" /></li>
           <li class="log_li1" style="padding-top:15px; height:40px; display: none"><input name="" type="checkbox" value="" /></li>
           <li class="log_li3" style="padding-top:15px; height:40px; display: none"><span>记住密码</span></li>
           <li class="log_li4"> <img src="${ctx}/images/empty.gif" width="101" height="46" title="登录系统" onclick="javascript:login();"></li>
       </ul>
   </div>
</div>
<!--登录区over-->
</form>
</body>
</html>
