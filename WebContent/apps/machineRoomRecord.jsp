<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#mainForm").focus();
			//为mainForm注册validate函数
			//调用日期控件
            $("#startime").datetimepicker();
            $("#endtime").datetimepicker();
            
            $("#mainForm").validate({
				rules: {
					"wellid": {
						required: true
					},
					"startime": {
						required: true
					} 
					,
					"endtime": {
						required: true
					}
				}
				
			});
		});
		function jumpPage(pageNo){
		    $("#pageNo").val(pageNo);
		    if(getTrueDay($("#startime").attr("value"))&&getTrueDay($("#endtime").attr("value"))){
		    $("#mainForm").submit();
		    }
		}
		
		function jumpAppointed(){
			$("#pageNo").val($("#appionted").attr("value"));
		    if(getTrueDay($("#startime").attr("value"))&&getTrueDay($("#endtime").attr("value"))){
		    $("#mainForm").submit();
		    }
		}
		
		function search(){
			//if(getTrueDay($("#startime").attr("value"))&&getTrueDay($("#endtime").attr("value"))){
		    $("#mainForm").submit();
		    //  }
		}
	 
		</script>
	</head>
	<body style="text-align: center;">
		<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">
				<script language="JavaScript"> 
	               showMessage("<s:property escape="false"/>");
	       		</script>
			</s:iterator>
		</s:if>
		<form id="mainForm" action="${ctx}/machineRoomRecord.do" method="post">
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>机房历史统计查询列表</span>
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->

				<!--用户查询层-->
				<div class="searlist_box">
					<label>
						机房编号：
						 <select name="roomNo"  id="roomNo"  value="${roomNo}" >
							<option value="0">请选择</option>
							<option value="MR1" <s:if test="roomNo=='MR1'">selected</s:if>>一机房</option>
							<option value="MR4" <s:if test="roomNo=='MR4'">selected</s:if>>四机房</option>
						</select> 
						开始时间：
						<input   id="startime" name="startime" type="text" value="${param['startime']}"/>
						结束时间：
						<input   id="endtime"  name="endtime" type="text" value="${param['endtime']}"/>
						<input type="button" value="查询" onclick="javascript:search();" />
					</label>
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
					<span>历史查询列表</span>
				</div>
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
						<s:if test="page.result.size>0">
							<tr bgcolor="#D0E6EA">
								<td align="center" width="5%" nowrap>
									<strong>序号</strong>
								</td>
								<td align="center"  width="8%" nowrap>
									<strong>机房编号</strong>
								</td>
								<td align="center"  width="10%" nowrap>
									<strong>汇管温度(℃)</strong>
								</td>
								<td align="center"  width="10%" nowrap>
									<strong>汇管压力(MPa)</strong>
								</td>
								<td align="center"  width="10%" nowrap>
									<strong>水管冷却水温度(℃)</strong>
								</td>
								<td align="center"  width="10%" nowrap>
									<strong>水管冷却水压力(MPa)</strong>
								</td>
								<td align="center"  width="10%" nowrap>
									<strong>时间</strong>
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
							<s:iterator value="page.result" status="s" >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">

									<td align="center">
										${s.count}
									</td>
									<td align="center" >
										${roomNo}
									</td>
									<td align="center" >
										${convergePipeTemperature}
									</td>
									<td align="center" >
										${convergePipePressure}
									</td>
									<td align="center" >
										${convergePipeCoolingWaterTemperature}
									</td>
									<td align="center" >
										${convergePipeCoolingWaterPressure}
									</td>
									<td align="center" >
										<s:date name="time" format="yyyy-MM-dd  HH:mm:ss" />
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