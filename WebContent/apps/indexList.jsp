<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<style>
			.JFZB{
				font-size:24px;
			}
			.JFZBDW{
				font-size:21px;
			}
			.tdCss{
				font-size:18px;
			}
			.titleTd{
				font-size:20px;
			}
		</style>
		<script type="text/javascript">
		function updateIndex(){
		var roomId=$("#roomId").val();
		$.get("${ctx}/indexcom_realTime.do", {
			"roomId":roomId		
			},function(data){
			var roomAndCom=data.split("#");
			var com=null;
			if(roomAndCom.length==1){
				com=roomAndCom[0];
			}else if(roomAndCom.length==2){
				var room=roomAndCom[0];
				var roomArr=room.split(",");
				for(var k=0;k<roomArr.length;k++){
					if(roomArr[k]!=null){
						var roomValueArr=roomArr[k].split("_");
						$("#"+roomValueArr[0]).text(roomValueArr[1]);
						if(roomValueArr[2]==1){
							$("#"+roomValueArr[0]).css("border-color","FF0000");
						}else{
							$("#"+roomValueArr[0]).css("border-color","FFFFFF");
						}
					}
				}
				com=roomAndCom[1];
			}
			if(com!=null){
			var array = com.split(";");
				for(var j=0;j<array.length; j++){
					var array0=array[j];
					var comArr=array0.split(":");
					var compressorCode=comArr[0];
					var compressorState=comArr[1];
					if(compressorState==0){
						$("#"+compressorCode+"tr0").attr("bgcolor","#ff9900");
					}else if(compressorState==1){
						$("#"+compressorCode+"tr1").attr("bgcolor","#00CC33");
					}else if(compressorState==2){
						$("#"+compressorCode+"tr2").attr("bgcolor","#ff0000");
					}
					var comIndexs=comArr[2];
					if(comIndexs!=null){
						var indexsArr=comIndexs.split(",");
						for(i=0;i<indexsArr.length;i++){
							var indexArr=indexsArr[i].split("_");
							$("#"+compressorCode+indexArr[0]).text(indexArr[1]);
							if(indexArr[3]==1){
								$("#"+compressorCode+indexArr[0]).css("border-color","FF0000");
							}else {
								$("#"+compressorCode+indexArr[0]).css("border-color","FFFFFF");
							}
						}
					}
				}
			}
			});
		}
		$(document).ready(function() {
			var str="${alarmString}";
			if(str!=null&&str!=""){
				var arr=str.split(",");
				for(i=0;i<arr.length;i++){
					var alarm=arr[i];
					$("#"+alarm).css("border-color","FF0000");
				}
			}
			setInterval('updateIndex()', 5000);
		});
		</script>
	</head>
	<body style="text-align: center;">
	<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">
				<script language="JavaScript"> 
				   //弹出DIV提示
	               showMessage("<s:property escape="false"/>");
	       		</script>
			</s:iterator>
		</s:if>
		<form id="mainForm" action="${ctx}/machineRoom.do" method="post">
			<div class="top_box">
				<div class="position_box">
					<div class="pos_tit">
						<input id="roomId" value="${roomId}" type="hidden"/>
						<span>机房列表</span>
						
					</div>
					<div class="sa_box"></div>
				</div>

			</div>
			<c:if test="${!empty indexListY}">
			<div class="userlist_box">
						<s:if test="indexListMr!=null&&indexListMr.size>0">
				<div><span class="JFZB">机房指标:</span>
						<s:iterator  value="indexListMr"  status="s" var="in">
						<span class="JFZB">　${in.indexName}:</span>
						<span id="${in.indexCode}" class="JFZB"><s:property value="mrList[#s.index]"/></span><span id="JFZBDW" class="JFZBDW">(${in.unit })</span>
						</s:iterator>
				</div>
						</s:if>
				<div class="userinfo_title">
	             	<span>压缩机</span>
	          	</div>
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%" bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								<td align="center">
								</td>
								<s:iterator value="indexListY">
								<td align="center" class="titleTd"><strong>${indexName}</strong><label><s:if test="indexCode!='YXZT'&&indexCode!='QDQFKCD'&&indexCode!='YGLQ'&&indexCode!='YFLQ'&&indexCode!='KQGLQ'">(${unit})</label></s:if></td>				
								</s:iterator>
							</tr>
							<s:iterator value="compressorsList" var="com">
								<s:if test="#com.identify==0">
									<s:if  test="#com.state==0">
										<tr id="${com.compressorCode}tr0" bgcolor="#FF9900">
											<td align="center" class="tdCss"><strong>${com.compressorName}</strong></td>
											<s:iterator value="#com.indexYValueList"  status="s" var="in">
											<td align="center"  class="tdCss"  id="${com.compressorCode}${s.index}">${in}</td>
											</s:iterator>
										</tr>
									</s:if>
									<s:if  test="#com.state==1">
										<tr id="${com.compressorCode}tr1" bgcolor="#00CC33">
											<td align="center" class="tdCss"><strong>${com.compressorName}</strong></td>
											<s:iterator value="#com.indexYValueList"  status="s" var="in">
											<td align="center"  class="tdCss"  id="${com.compressorCode}${s.index}">${in}</td>
											</s:iterator>
										</tr>
									</s:if>
									<s:if test="#com.state==2">
										<tr id="${com.compressorCode}tr2" bgcolor="#ff0000">
											<td align="center" class="tdCss"><strong>${com.compressorName}</strong></td>
											<s:iterator value="#com.indexYValueList"  status="s" var="in">
											<td align="center"  class="tdCss"  id="${com.compressorCode}${s.index}">${in}</td>
											</s:iterator>
										</tr>
									</s:if>
								</s:if>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
			</c:if>
			<c:if test="${!empty indexListL}">
				<div class="userlist_box">
					<div class="userinfo_title">
		             	<span>螺杆机</span>
		          	</div>
					<div class="userinfo_box">
						<table cellspacing="1" cellpadding="3" width="100%" bgcolor="#C4DDE1" border="0">
							<tbody>
								<tr bgcolor="#D0E6EA">
									<td align="center">
									</td>
									<s:iterator value="indexListL" status="s" var="index">
									<td align="center"  class="titleTd"><strong>${indexName}</strong><label><s:if test="indexCode!='YXZT'&&indexCode!='QDQFKCD'&&indexCode!='YGLQ'&&indexCode!='YFLQ'&&indexCode!='KQGLQ'">(${unit})</label></s:if></td>				
									</s:iterator>
								</tr>
								<s:iterator value="compressorsList" var="com">
									<s:if test="#com.identify==1">
										<s:if  test="#com.state==0">
											<tr id="${com.compressorCode}tr0" bgcolor="#ff9900">
												<td align="center"  class="tdCss"><strong>${com.compressorName}</strong></td>
												<s:iterator value="#com.indexLValueList"   status="s" var="in">
												<td align="center"  class="tdCss" id="${com.compressorCode}${s.index}">${in}</td>
												</s:iterator>
											</tr>	
										</s:if>	
										<s:if test="#com.state==1">
											<tr id="${com.compressorCode}tr1" bgcolor="#00CC33">
												<td align="center"  class="tdCss"><strong>${com.compressorName}</strong></td>
												<s:iterator value="#com.indexLValueList"   status="s" var="in">
												<td align="center"  class="tdCss" id="${com.compressorCode}${s.index}">${in}</td>
												</s:iterator>
											</tr>	
										</s:if>	
										<s:if test="#com.state==2">
											<tr id="${com.compressorCode}tr2" bgcolor="#ff0000">
												<td align="center"  class="tdCss"><strong>${com.compressorName}</strong></td>
												<s:iterator value="#com.indexLValueList"   status="s" var="in">
												<td align="center"  class="tdCss" id="${com.compressorCode}${s.index}">${in}</td>
												</s:iterator>
											</tr>	
										</s:if>	
									</s:if>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</form>
		<table align="center">
		<%--
			<s:if test="roomNo=='MR1'">
			<tr>
				<td><iframe id="J1-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.1&chname=1" style="float: left;width: 462px;height: 340px;"></iframe></td>
				<td><iframe id="J1-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.2&chname=2" style="float: left;width: 462px;height: 340px;"></iframe></td>
			</tr>
			</s:if>
			<s:if test="roomNo=='MR2'">
			<tr>
				<td><iframe id="J2-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.3&chname=3" style="float: left;width: 462px;height: 340px;"></iframe></td>
			</tr>
			</s:if>
			<s:if test="roomNo=='MR3'">
			<tr>
				<td><iframe id="J3-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.4&chname=4" style="float: left;width: 462px;height: 340px;"></iframe></td>
				<td><iframe id="J3-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.5&chname=5" style="float: left;width: 462px;height: 340px;"></iframe></td>
			</tr>
			</s:if>
			<s:if test="roomNo=='MR4'">
			<tr>
				<td><iframe id="J4-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.6&chname=6" style="float: left;width: 462px;height: 340px;"></iframe></td>
				<td><iframe id="J4-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.7&chname=7" style="float: left;width: 462px;height: 340px;"></iframe></td>
				<td><iframe id="J4-C3" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.8&chname=8" style="float: left;width: 462px;height: 340px;"></iframe></td>
			</tr>
			</s:if>
			<s:if test="roomNo=='MR5'">
			<tr>
				<td><iframe id="J5-C1" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.9&chname=9" style="float: left;width: 462px;height: 340px;"></iframe></td>
				<td><iframe id="J5-C2" scrolling="no"  src="<%=basePath%>viewjpeg.html?live=1.10&chname=10" style="float: left;width: 462px;height: 340px;"></iframe></td>
			</tr>
			</s:if>
		--%>
		</table>
	</body>
</html>