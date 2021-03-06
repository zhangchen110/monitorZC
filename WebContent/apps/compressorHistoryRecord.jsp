﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<script type="text/javascript">
		$(document).ready(function() {
		
			$("table input").hide();
			$("table input").attr("size", "3");
			$("table tr").css({ "background-color": "#FFFFFF" });
			$("table tr").bind("onmouseover","this.className='row_over'");
			$("table tr").bind("onmouseout","this.className='row_out'");
			$("#mainForm").focus();
			//为mainForm注册validate函数
			//调用日期控件
            $("#starttime").datetimepicker();
            $("#endtime").datetimepicker();
             $("#mainForm").validate({
				rules: {
					"roomNumber": {
						required: true
					},
					"compressorNo": {
						required: true
					},
					"starttime": {
						required: true
					} ,
					"endtime": {
						required: true
					} 
				}
			});
         
		});
		function jumpPage(pageNo){
			$("#options").attr("value",$("#compressorNo").html());
		    $("#pageNo").val(pageNo);
		  // alert($("#options").attr("value"));
		    if(getTrueDay($("#starttime").attr("value"))&&getTrueDay($("#endtime").attr("value"))){
		    $("#mainForm").submit();
		    }
		}
		
		function jumpAppointed(){
		    $("#options").attr("value",$("#compressorNo").html());
			$("#pageNo").val($("#appionted").attr("value"));
		    if(getTrueDay($("#starttime").attr("value"))&&getTrueDay($("#endtime").attr("value"))){
		    $("#mainForm").submit();
		    }
		}
		
		function search(){
		 	$("#options").attr("value",$("#compressorNo").html());
		 	//alert($("#options").attr("value"));
		   // if(getTrueDay($("#starttime").attr("value"))&&getTrueDay($("#endtime").attr("value"))){
		    $("#mainForm").submit();
		    // }
		}
		
		function roomSelect(){
 			var roomId = $("#roomNumber").val(); 
 			if(roomId==""||roomId==undefined){
 				return false;
 			}
			$.get("${ctx}/compressorHistoryRecord_searchCompressor.do?roomId=" + roomId, {},function (data){
				$("#compressorNo").html(data);
			});
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
		<form id="mainForm" action="${ctx}/compressorHistoryRecord.do" method="post">
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>压缩机历史统计查询列表</span>
						<input type="hidden" name="options" id="options"  value="" />
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->

				<!--用户查询层-->
				<div class="searlist_box">
						机房编号：
						<s:select style="width: 140px" list="machineRoomList" listKey="id" listValue="roomName" name="roomNumber" id="roomNumber" onchange="roomSelect()" headerKey="" headerValue="请选择"></s:select>
						压缩机编号：
						<select name="compressorNo" id="compressorNo"  style="width: 160px">${options}</select>
						开始时间：
						<input   id="starttime" name="starttime" type="text" value="${param['starttime']}"/>
						结束时间：
						<input   id="endtime"  name="endtime" type="text" value="${param['endtime']}"/>

 
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
						<%@ include file="/common/compressorHistoryRecord-page.jsp"%>
					</div>
				</div>
				<div class="userinfo_title">
					<span>历史查询列表</span>
				</div>
				
				<!-- OneIntegratedMachine -->
				<s:if test="oneIntegratedList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								 <td>时间</td><td>机油压力(MPa)</td><td>冷却水压力(MPa)</td><td>螺杆压力(MPa)</td><td>螺杆温度(℃)</td><td>一级活塞压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级活塞温度(℃)</td><td>三级活塞压力(MPa)</td><td>三级活塞温度(℃)</td> <td>机油温度(℃)</td><td>冷却水温度(℃)</td>
							</tr>
							<s:iterator value="oneIntegratedList.result" status="s" >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${oilPressure}</td>
									<td>${coolingWaterPressure}</td>
									<td>${screwPressure}</td>
									<td>${screwTemperature}</td>
									<td>${firstPistonPressure}</td>
									<td>${firstPistonTemperature}</td>
									<td>${secondPistonPressure}</td>
									<td>${secondPistonTemperature}</td>
									<td>${thirdPistonPressure}</td>
									<td>${thirdPistonTemperature}</td>
									 
									<td>${oilTemperature}</td>
									<td>${coolingWaterTemperature}</td>
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
					<input type="hidden" name="oneIntegratedList.pageNo" id="pageNo"
						value="${oneIntegratedList.pageNo}" />
					<input type="hidden" name="oneIntegratedList.orderBy" id="orderBy"
						value="${oneIntegratedList.orderBy}" />
					<input type="hidden" name="oneIntegratedList.order" id="order"
						value="${oneIntegratedList.order}" />
				</div>
				</s:if>
				
				<!-- TwoScrewMachine -->
				<s:if test="twoScrewList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								 <td>时间</td><td>机油压力(MPa)</td><td>排气压力(MPa)</td><td>螺杆出气温度1(℃)</td><td>螺杆出气温度2(℃)</td>
							</tr>
							<s:iterator value="twoScrewList.result" status="s"   >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${oilPressure}</td>
									<td>${exhaustPressure}</td>
									 <td>${outScrewTemperature1}</td>
									 <td>${outScrewTemperature2}</td>
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
					<input type="hidden" name="twoScrewList.pageNo" id="pageNo"
						value="${twoScrewList.pageNo}" />
					<input type="hidden" name="twoScrewList.orderBy" id="orderBy"
						value="${twoScrewList.orderBy}" />
					<input type="hidden" name="twoScrewList.order" id="order"
						value="${twoScrewList.order}" />
				</div>
				</s:if>
				
				<!-- TwoBoosterCompressor -->
				<s:if test="twoBoosterList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								<td>时间</td><td>进气压力(MPa)</td><td>一级活塞压力(MPa)</td><td>二级活塞压力(MPa)</td><td>三级活塞压力(MPa)</td><td>机油压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞温度(℃)</td><td>三级活塞温度(℃)</td><td>机油温度(℃)</td> 
							</tr>
							<s:iterator value="twoBoosterList.result" status="s"  >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${inletPressure}</td>
									<td>${firstPistonPressure}</td>
									<td>${secondPistonPressure}</td>
									<td>${thirdPistonPressure}</td>
									<td>${oilPressure}</td>
									<td>${firstPistonTemperature}</td>
									<td>${secondPistonTemperature}</td>
									<td>${thirdPistonTemperature}</td>
									<td>${oilTemperature}</td>
								   
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
					<input type="hidden" name="twoBoosterList.pageNo" id="pageNo"
						value="${twoBoosterList.pageNo}" />
					<input type="hidden" name="twoBoosterList.orderBy" id="orderBy"
						value="${twoBoosterList.orderBy}" />
					<input type="hidden" name="twoBoosterList.order" id="order"
						value="${twoBoosterList.order}" />
				</div>
				</s:if>
				
				<!-- ThreeScrewMachine -->
				<s:if test="threeScrewList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								 <td>时间</td><td>排气温度(℃)</td><td>排气压力(MPa)</td><td>机油压力(MPa)</td><td>机油温度(℃)</td>
							</tr>
							<s:iterator value="threeScrewList.result" status="s"  >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${exhaustTemperature}</td>
									<td>${exhaustPressure}</td>
									<td>${oilPressure}</td>
									<td>${oilTemperature}</td>
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
					<input type="hidden" name="threeScrewList.pageNo" id="pageNo"
						value="${threeScrewList.pageNo}" />
					<input type="hidden" name="threeScrewList.orderBy" id="orderBy"
						value="${threeScrewList.orderBy}" />
					<input type="hidden" name="threeScrewList.order" id="order"
						value="${threeScrewList.order}" />
				</div>
				</s:if>
				
				<!-- ThreeBoosterCompressor -->
				<s:if test="threeBoosterList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								<td>时间</td><td>一级活塞压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级活塞温度(℃)</td><td>机油压力(MPa)</td><td>机油温度(℃)</td> 
							</tr>
							<s:iterator value="threeBoosterList.result" status="s"  >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${firstPistonPressure}</td>
									<td>${firstPistonTemperature}</td>
									<td>${secondPistonPressure}</td>
									<td>${secondPistonTemperature}</td>
									<td>${oilPressure}</td>
									<td>${oilTemperature}</td>
									 
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
					<input type="hidden" name="threeBoosterList.pageNo" id="pageNo"
						value="${threeBoosterList.pageNo}" />
					<input type="hidden" name="threeBoosterList.orderBy" id="orderBy"
						value="${threeBoosterList.orderBy}" />
					<input type="hidden" name="threeBoosterList.order" id="order"
						value="${threeBoosterList.order}" />
				</div>
				</s:if>
				
				<!--FourIntegratedMachine  -->
				<s:if test="fourIntegratedList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								 <td>时间</td><td>机油压力(MPa)</td><td>冷却水压力(MPa)</td><td>螺杆压力(MPa)</td><td>螺杆温度(℃)</td><td>一级活塞压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级活塞温度 (℃)</td> <td>机油温度(℃)</td><td>冷却水温度(℃)</td>
							</tr>
							<s:iterator value="fourIntegratedList.result" status="s"  >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${oilPressure}</td>
									<td>${coolingWaterPressure}</td>
									<td>${screwPressure}</td>
									<td>${screwTemperature}</td>
									<td>${firstPistonPressure}</td>
									<td>${firstPistonTemperature}</td>
									<td>${secondPistonPressure}</td>
									<td>${secondPistonTemperature}</td>
									 
									<td>${oilTemperature}</td> 
									<td>${coolingWaterTemperature}</td>
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
					<input type="hidden" name="fourIntegratedList.pageNo" id="pageNo"
						value="${fourIntegratedList.pageNo}" />
					<input type="hidden" name="fourIntegratedList.orderBy" id="orderBy"
						value="${fourIntegratedList.orderBy}" />
					<input type="hidden" name="fourIntegratedList.order" id="order"
						value="${fourIntegratedList.order}" />
				</div>
				</s:if>
				
				<!-- FiveScrewMachine -->
				<s:if test="fiveScrewList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								 <td>时间</td><td>进气温度(℃)</td><td>进气压力(MPa)</td><td>轴承温度(℃)</td>
							</tr>
							<s:iterator value="fiveScrewList.result" status="s"  >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${inletTemperature}</label></td>
									<td>${inletPressure}</label></td>
									<td>${bearingTemperature}</td> 
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
					<input type="hidden" name="fiveScrewList.pageNo" id="pageNo"
						value="${fiveScrewList.pageNo}" />
					<input type="hidden" name="fiveScrewList.orderBy" id="orderBy"
						value="${fiveScrewList.orderBy}" />
					<input type="hidden" name="fiveScrewList.order" id="order"
						value="${fiveScrewList.order}" />
				</div>
				</s:if>
				
				<!-- FiveBoosterCompressor -->
				<s:if test="fiveBoosterList.result.size!=0">
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								<td>时间</td><td>一级活塞压力(MPa)</td><td>一级排气温度(℃)</td><td>二级进气温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级排气温度(℃)</td><td>机油压力(MPa)</td><td>机油温度(℃)</td><td>螺杆出气温度1(℃)</td><td>螺杆出气温度2(℃)</td> 
							</tr>
							<s:iterator value="fiveBoosterList.result" status="s"  >
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td><s:date name="time" format="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${firstPistonPressure}</td> 
									<td>${firstExhaustTemperature}</td> 
									<td>${secondInletTemperature}</td> 
									<td>${secondPistonPressure}</td> 
									<td>${secondExhaustTemperature}</td>
									<td>${oilPressure}</td> 
									<td>${oilTemperature}</td>
									 <td>${outScrewTemperature1}</td>
									 <td>${outScrewTemperature2}</td>
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
					<input type="hidden" name="fiveBoosterList.pageNo" id="pageNo"
						value="${fiveBoosterList.pageNo}" />
					<input type="hidden" name="fiveBoosterList.orderBy" id="orderBy"
						value="${fiveBoosterList.orderBy}" />
					<input type="hidden" name="fiveBoosterList.order" id="order"
						value="${fiveBoosterList.order}" />
				</div>
				</s:if>
				
				
				
			</div>
		</form>
	</body>
</html>