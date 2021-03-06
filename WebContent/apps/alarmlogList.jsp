<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<script type="text/javascript">
		
		$(document).ready(function() {
		//	$("#mainForm").focus();
			//为mainForm注册validate函数
			//调用日期控件
            $("#todays").datepicker();
            $("#todaye").datepicker();
            $("#mainForm").validate({
				rules: {
					"todays": {
						required: true
					} ,
					"todaye": {
						required: true
					}
				}
			});
		});
		
		function jumpPage(pageNo){
			
		    $("#pageNo").val(pageNo);
		    if(getTrueDay($("#todays").attr("value"))&&getTrueDay($("#todaye").attr("value"))){
		    $("#mainForm").submit();
		    }
		}
		
		function jumpAppointed(){
			$("#pageNo").val($("#appionted").attr("value"));
		    if(getTrueDay($("#todays").attr("value"))&&getTrueDay($("#todaye").attr("value"))){
		    	$("#mainForm").submit();
		    }
		}
		
		function search(){
			//if(getTrueDay($("#todays").attr("value"))&&getTrueDay($("#todaye").attr("value"))){
		    $("#mainForm").submit();
		    //}
		}
	 
		</script>
	</head>
	<body style="text-align: center;">
		<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">
				<script language="JavaScript"> 
	               alert("<s:property escape="false"/>");
	       		</script>
			</s:iterator>
		</s:if>
		<form id="mainForm" action="${ctx}/alarmlog.do" method="post">
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>预警日志列表</span>
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->

				<!--用户查询层-->
				<div class="searlist_box">
					
					<%-- 
						井编号：
						<s:select list="wellAllList" headerKey="" headerValue="请选择" listKey="id" listValue="wellNo" name="filter_LIKES_wellId" id="filter_LIKES_wellId"/>
 					--%>
						开始日期：
						<input   id="todays" name="todays" type="text" value="${todays}"/>
						结束日期：
						<input   id="todaye" name="todaye" type="text" value="${todaye}"/>
						<input type="button" value="查询" onclick="javascript:search();" />
					
				</div>
				<!--用户查询层over-->
			</div>
			<!--top说明层over-->

			<!--页面主体层-->
			<!--用户信息列表-->
			<div class="userlist_box">
				<div class="page_box">
					<div class="page">
						<%@ include file="/common/page.jsp"%>
					</div>
				</div>
				<div class="userinfo_title">
					<span>日志列表</span>
				</div>
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
						<s:if test="page.result.size>0">
							<tr bgcolor="#D0E6EA" align="center" >

								<td   width="5%" nowrap>
									<strong>序号</strong>
								</td>
								<td   width="15%" nowrap>
									<strong>时间</strong>
								</td>
								<td   nowrap>
									<strong>信息</strong>
								</td>
							</tr>
						</s:if>
						<s:else>
						<tr bgcolor="#D0E6EA" align="center" >
								<td    nowrap>
									<b>无查询数据</b>
								</td>
						</tr>
						</s:else>
							<s:iterator value="page.result" status="s"  var="alarmlog">
								<tr bgcolor="#ffffff"  onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">

									<td  align="center">
										${s.count}
									</td>
									<td  align="center">
										<s:date name="time" format="yyyy-MM-dd  HH:mm:ss" />
									</td>
									<td  align="left">
										${alarmlog.msg}
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="page_box">
					<div class="choose_box">
					</div>
				</div>
				<div class="new_user">
					<input type="hidden" name="page.pageNo" id="pageNo"
						value="${page.pageNo}" />
					<input type="hidden" name="page.orderBy" id="orderBy"
						value="${page.orderBy}" />
					<input type="hidden" name="page.order" id="order"
						value="${page.order}" />
				</div>
			</div>
		</form>
	</body>
</html>