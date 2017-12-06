﻿<%@ page contentType="text/html;charset=UTF-8"%>
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
            $("#reporttime").datepicker();
            $("#mainForm").validate({
				rules: {
					"wellno": {
						required: true
					},
					"reporttime": {
						required: true
					} 
				}
			});
		});
	 	
		function search(){
		   if( getTrueDay($("#reporttime").attr("value"))){
		   $("#mainForm").submit();
		   }
		}
		function save(){
		   $("#htmls").attr("value",$("#reportlist").html());
		   $("#mainForm").attr("action","${ctx}/statistics_save.do");
		   $("#mainForm").submit();
		}
	 
 		function savecode(type,no){
				$("#edit_"+type+"_l_"+no).text($("#edit_"+type+"_i_"+no).val());
			 	$("#edit_"+type+"_i_"+no).hide();
				$("#edit_"+type+"_l_"+no).show();
	 			$("#edit_"+type+"_t_"+no).attr("onclick","editcode('"+type+"','"+no+"')");
				$("#edit_"+type+"_t_"+no).bind("click",function(){
					 editcode(type,no);
				});			 
			}
		function editcode(type,no){ 	
	 		$("#edit_"+type+"_i_"+no).attr("value",$("#edit_"+type+"_l_"+no).text());
			$("#edit_"+type+"_l_"+no).hide();
			$("#edit_"+type+"_i_"+no).show();
	 		$("#edit_"+type+"_i_"+no).focus();
			$("#edit_"+type+"_t_"+no).removeAttr("onclick");
			$("#edit_"+type+"_t_"+no).unbind("click"); 
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
		<form id="mainForm" action="${ctx}/statistics_listclassreport.do" method="post">
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>班报信息查询列表</span>
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->

				<!--用户查询层-->
				<div class="searlist_box">
					<label>
						井编号：
						<s:select list="wellAllList" listKey="wellNo" listValue="wellNo" name="wellno" />
						具体日期：
						<input   id="reporttime" name="reporttime" type="text" value="${reporttime}"/>
						<input type="button" value="查询" onclick="javascript:search();" />
						<input type="button" value="保存" onclick="javascript:save();" />
					</label>
				</div>
				<!--用户查询层over-->
			</div>
			<!--top说明层over-->
<!--页面主体层-->
			<!--用户信息列表-->
			<div class="userlist_box">
				<div class="userinfo_title">
					<span>班报查询列表</span><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前井号：${wellno}</span>
				</div>
				<div class="userinfo_box">
						<table id="reportlist"  cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
						<s:property value="#ishtml" />
						<s:if test="ishtml">
							<tbody>
							<tr bgcolor="#ffffff" align="center" id="dddd">
							
							<td colspan="11" id="edit_titlename_t_0"  onclick="editcode('titlename','0')"><label style="text-align:center"><font size="h3" ><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input size="7" type="text" id="edit_titlename_i_0" style="display: none" onblur="savecode('titlename','0')"   /><u><label id="edit_titlename_l_0"   ></label></u>站火驱注气井班报表</b></font></label></td>
							</tr>
							<tr bgcolor="#ffffff"  >
								<td colspan="3" align="left">
								<strong> 
								<label  onclick="editcode('wellno','0')" > 井号：&nbsp;&nbsp;</label>
								<label id="edit_wellno_l_0"  onclick="editcode('wellno','0')" >${wellno}</label>
								<input size="7"  type="text" id="edit_wellno_i_0" style="display: none;" onblur="savecode('wellno','0')"/>   
								</strong>	 </td>
								
								<td colspan="7" align="center" >
								 <strong> 
								
								 <label id="edit_timeyear_l_0"  onclick="editcode('timeyear','0')" >${time_year}</label>
								 <input size="3" type="text" id="edit_timeyear_i_0"  style="display: none" onblur="savecode('timeyear','0')"/>   
								 <label  onclick="editcode('timeyear','0')" > 年&nbsp;&nbsp;</label>
								 
								 <label id="edit_timemonth_l_0"  onclick="editcode('timemonth','0')" >${time_month}</label>
								 <input size="1" type="text" id="edit_timemonth_i_0" style="display: none"    onblur="savecode('timemonth','0')"/>   
								 <label  onclick="editcode('timemonth','0')" > 月&nbsp;&nbsp;</label>
								 
								 <label id="edit_timeday_l_0"  onclick="editcode('timeday','0')" >${time_day}</label>
								 <input size="1" type="text" id="edit_timeday_i_0" style="display: none" onblur="savecode('timeday','0')"/>   
								 <label  onclick="editcode('timeday','0')" > 日&nbsp;&nbsp;</label>
								 
								 </strong></td>
								<td colspan="1"  width="17%" align="center">
								<strong >    <label  onclick="editcode('rizhuqiliang','0')" > 日配注气量:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><label id="edit_rizhuqiliang_l_0"  onclick="editcode('rizhuqiliang','0')" ></label><input size="1" type="text" id="edit_rizhuqiliang_i_0" style="display: none" onblur="savecode('rizhuqiliang','0')"/> &nbsp;&nbsp;m3&nbsp;&nbsp;</strong>								
							  </td>
							</tr>
							<tr  bgcolor="#ffffff" align="center">
							  <td    rowspan="2" nowrap  width="40px;" >
							  <strong>班次</strong></td>
							  <td    rowspan="2" nowrap width="60px;">
							  <strong>时间</strong></td>
							  <td    rowspan="2" nowrap width="80px;">
							  <strong>注气方式</strong></td>
							  <td    rowspan="2" nowrap  width="80px;">
							  <strong>流量计读数(m3)</strong></td>
							  <td     rowspan="2" nowrap  width="80px;">
							  <strong>瞬时注入量</strong></td>
							  <td colspan="3" nowrap><strong>压力(Map)</strong></td>
							  <td   rowspan="2" nowrap  width="80px;">
							  <strong>井口温度(℃)</strong></td>
							  <td   rowspan="2" nowrap  width="80px;">
							  <strong>填报人</strong></td>
							  <td     rowspan="2" nowrap  width="140px;">
							  <strong>备注</strong></td>
						  </tr>
							<tr bgcolor="#ffffff" align="center">
							    <td  nowrap  width="80px;">干压</td>
								<td  nowrap  width="80px;">油压</td>
								<td  nowrap  width="80px;">套压</td>
							</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
									<td align="center" rowspan="2" >零点</td>
								     <td  align="center"  onclick="editcode('oneday','0')"   id="edit_oneday_t_0"   ><label id="edit_oneday_l_0">3:00</label><input size="3" type="text" id="edit_oneday_i_0" style="display: none" onblur="savecode('oneday','0')"  /></td>
								    <td  align="center"  onclick="editcode('zhuqifangshi','0')"    id="edit_zhuqifangshi_t_0" ><label id="edit_zhuqifangshi_l_0"></label><input size="7" type="text" id="edit_zhuqifangshi_i_0" style="display: none" onblur="savecode('zhuqifangshi','0')"/></td>
									 <td  align="center" id="edit_accumulative_t_0"  onclick="editcode('accumulative','0')"     ><label id="edit_accumulative_l_0">${mon3.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_0" style="display: none" onblur="savecode('accumulative','0')"/></td>
								    <td  align="center"  onclick="editcode('instantaneous','0')"    id="edit_instantaneous_t_0"  ><label id="edit_instantaneous_l_0">${mon3.instantaneousFlow}</label><input size="7" type="text" id="edit_instantaneous_i_0" style="display: none" onblur="savecode('instantaneous','0')"/></td>
								     <td  align="center"  onclick="editcode('pressure','0')"   id="edit_pressure_t_0"   ><label id="edit_pressure_l_0">${mon3.pressure}</label><input size="7" type="text" id="edit_pressure_i_0" style="display: none" onblur="savecode('pressure','0')"/></td>
								   
								    <td  align="center"  onclick="editcode('youya','0')"    id="edit_youya_t_0"  ><label id="edit_youya_l_0"></label><input size="7" type="text" id="edit_youya_i_0" style="display: none" onblur="savecode('youya','0')"/></td>
								    <td  align="center"  onclick="editcode('taoya','0')"   id="edit_taoya_t_0"  ><label id="edit_taoya_l_0"></label><input size="7" type="text" id="edit_taoya_i_0" style="display: none" onblur="savecode('taoya','0')"/></td>
									 <td  align="center"  onclick="editcode('temperature','0')"  id="edit_temperature_t_0"  ><label id="edit_temperature_l_0">${mon3.temperature}</label><input size="7" type="text" id="edit_temperature_i_0" style="display: none" onblur="savecode('temperature','0')"/></td>
								   
								    
									<td  align="center"  rowspan="2" onclick="editcode('tianbaoren','0')"   id="edit_tianbaoren_t_0"  ><label id="edit_tianbaoren_l_0"></label><input size="7" type="text" id="edit_tianbaoren_i_0" style="display: none" onblur="savecode('tianbaoren','0')"/></td>
								    <td align="left"  rowspan="7"  >
									<label id="edit_oneday_l_7"  onclick="editcode('oneday','7')" >${beforeday} &nbsp;&nbsp;&nbsp;&nbsp; 23:00</label><input size="3" type="text" id="edit_oneday_i_7" style="display: none" onblur="savecode('oneday','7')"/>  <label  onclick="editcode('oneday','7')" >读数：&nbsp;&nbsp;</label>
								
								<ul>
								   
								      <li><label  onclick="editcode('pressure','7')" >压力：&nbsp;&nbsp;</label><label id="edit_pressure_l_7"  onclick="editcode('pressure','7')" > ${beforemon23.pressure }</label><input size="7" type="text" id="edit_pressure_i_7" style="display: none" onblur="savecode('pressure','7')"/> </li>
									
							  <li> <label  onclick="editcode('temperature','7')" >温度：&nbsp;&nbsp;</label><label id="edit_temperature_l_7"  onclick="editcode('temperature','7')" >${beforemon23.temperature }</label><input size="7" type="text" id="edit_temperature_i_7" style="display: none" onblur="savecode('temperature','7')"/> </li>
							  
									  <li><label  onclick="editcode('instantaneous','7')" >瞬时流量：&nbsp;&nbsp;</label><label id="edit_instantaneous_l_7"  onclick="editcode('instantaneous','7')" >${beforemon23.instantaneousFlow }</label><input size="7" type="text" id="edit_instantaneous_i_7" style="display: none" onblur="savecode('instantaneous','7')"/>  </li>
									 
									 <li><label  onclick="editcode('accumulative','7')" >累计流量：&nbsp;&nbsp;</label><label id="edit_accumulative_l_7"  onclick="editcode('accumulative','7')" >${beforemon23.accumulativeFlow }</label><input size="7" type="text" id="edit_accumulative_i_7" style="display: none" onblur="savecode('accumulative','7')"/>   </li>
									
								   <li> <label  onclick="editcode('leijizhuqiliang','0')" >累计计注气量：&nbsp;&nbsp;</label><label id="edit_leijizhuqiliang_l_0"  onclick="editcode('leijizhuqiliang','0')" ></label><input size="7" type="text" id="edit_leijizhuqiliang_i_0" style="display: none" onblur="savecode('leijizhuqiliang','0')"/> </li>
								    
									</ul>
									 
								   </td>
								</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
								     <td  align="center"  onclick="editcode('oneday','1')"   id="edit_oneday_t_1"    ><label id="edit_oneday_l_1">7:00</label><input size="3" type="text" id="edit_oneday_i_1" style="display: none" onblur="savecode('oneday','1')"  /></td>
								    <td  align="center"  onclick="editcode('zhuqifangshi','1')"  id="edit_zhuqifangshi_t_1"   ><label id="edit_zhuqifangshi_l_1"></label><input size="7" type="text" id="edit_zhuqifangshi_i_1" style="display: none" onblur="savecode('zhuqifangshi','1')"/></td>
								    <td  align="center"  onclick="editcode('accumulative','1')"   id="edit_accumulative_t_1"  ><label id="edit_accumulative_l_1">${mon7.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_1" style="display: none" onblur="savecode('accumulative','1')"/></td>
								    <td  align="center"  onclick="editcode('instantaneous','1')"    id="edit_instantaneous_t_1"  ><label id="edit_instantaneous_l_1">${mon7.instantaneousFlow}</label><input size="7" type="text" id="edit_instantaneous_i_1" style="display: none" onblur="savecode('instantaneous','1')"/></td>
								     <td  align="center"  onclick="editcode('pressure','1')"   id="edit_pressure_t_1"   ><label id="edit_pressure_l_1">${mon7.pressure}</label>
								       <input size="7" type="text" id="edit_pressure_i_1" style="display: none" onblur="savecode('pressure','1')"/></td>
								    <td  align="center"  onclick="editcode('youya','1')"     id="edit_youya_t_1"  ><label id="edit_youya_l_1"></label><input size="7" type="text" id="edit_youya_i_1" style="display: none" onblur="savecode('youya','1')"/></td>
								    <td  align="center"  onclick="editcode('taoya','1')"    id="edit_taoya_t_1"   ><label id="edit_taoya_l_1"></label><input size="7" type="text" id="edit_taoya_i_1" style="display: none" onblur="savecode('taoya','1')"/></td>
								     <td  align="center"  onclick="editcode('temperature','1')"  id="edit_temperature_t_1"      ><label id="edit_temperature_l_1">${mon7.temperature}</label><input size="7" type="text" id="edit_temperature_i_1" style="display: none" onblur="savecode('temperature','1')"/></td>
								</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
								    <td align="center" rowspan="2">八点</td>
								     <td  align="center"  onclick="editcode('oneday','2')"     id="edit_oneday_t_2"   ><label id="edit_oneday_l_2">11:00</label><input size="3" type="text" id="edit_oneday_i_2" style="display: none" onblur="savecode('oneday','2')"  /></td>
								       <td  align="center"  onclick="editcode('zhuqifangshi','2')"  id="edit_zhuqifangshi_t_2"  ><label id="edit_zhuqifangshi_l_2"></label><input size="7" type="text" id="edit_zhuqifangshi_i_2" style="display: none" onblur="savecode('zhuqifangshi','2')"/></td>
								   <td  align="center"  onclick="editcode('accumulative','2')" id="edit_accumulative_t_2"     ><label id="edit_accumulative_l_2">${mon11.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_2" style="display: none" onblur="savecode('accumulative','2')"/></td>
								     <td  align="center"  onclick="editcode('instantaneous','2')"    id="edit_instantaneous_t_2"  ><label id="edit_instantaneous_l_2">${mon11.instantaneousFlow}</label>
								       <input size="7" type="text" id="edit_instantaneous_i_2" style="display: none" onblur="savecode('instantaneous','2')"/></td>
								      <td  align="center"  onclick="editcode('pressure','2')"   id="edit_pressure_t_2"   ><label id="edit_pressure_l_2">${mon11.pressure}</label>
								        <input size="7" type="text" id="edit_pressure_i_2" style="display: none" onblur="savecode('pressure','2')"/></td>
								    <td  align="center"  onclick="editcode('youya','2')"    id="edit_youya_t_2"   ><label id="edit_youya_l_2"></label><input size="7" type="text" id="edit_youya_i_2" style="display: none" onblur="savecode('youya','2')"/></td>
								    <td  align="center"  onclick="editcode('taoya','2')"   id="edit_taoya_t_2"    ><label id="edit_taoya_l_2"></label><input size="7" type="text" id="edit_taoya_i_2" style="display: none" onblur="savecode('taoya','2')"/></td>
								    <td  align="center"  onclick="editcode('temperature','2')"   id="edit_temperature_t_2"    ><label id="edit_temperature_l_2">${mon11.temperature}</label><input size="7" type="text" id="edit_temperature_i_2" style="display: none" onblur="savecode('temperature','2')"/></td>
								   <td  align="center"  rowspan="2" onclick="editcode('tianbaoren','1')"   id="edit_tianbaoren_t_1"  ><label id="edit_tianbaoren_l_1"></label><input size="7" type="text" id="edit_tianbaoren_i_1" style="display: none" onblur="savecode('tianbaoren','1')"/></td>
								</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
								    <td  align="center"  onclick="editcode('oneday','3')"     id="edit_oneday_t_3"   ><label id="edit_oneday_l_3">15:00</label><input size="3" type="text" id="edit_oneday_i_3" style="display: none" onblur="savecode('oneday','3')"  /></td>
								      <td  align="center"  onclick="editcode('zhuqifangshi','3')" id="edit_zhuqifangshi_t_3"    ><label id="edit_zhuqifangshi_l_3"></label><input size="7" type="text" id="edit_zhuqifangshi_i_3" style="display: none" onblur="savecode('zhuqifangshi','3')"/></td>
								     <td  align="center"  onclick="editcode('accumulative','3')"  id="edit_accumulative_t_3"   ><label id="edit_accumulative_l_3">${mon15.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_3" style="display: none" onblur="savecode('accumulative','3')"/></td>
								   <td  align="center"  onclick="editcode('instantaneous','3')"   id="edit_instantaneous_t_3"   ><label id="edit_instantaneous_l_3">${mon15.instantaneousFlow}</label>
								     <input size="7" type="text" id="edit_instantaneous_i_3" style="display: none" onblur="savecode('instantaneous','3')"/></td>
								    <td  align="center"  onclick="editcode('pressure','3')"    id="edit_pressure_t_3"  ><label id="edit_pressure_l_3">${mon15.pressure}</label>
								      <input size="7" type="text" id="edit_pressure_i_3" style="display: none" onblur="savecode('pressure','3')"/></td>
								    <td  align="center"  onclick="editcode('youya','3')"    id="edit_youya_t_3"   ><label id="edit_youya_l_3"></label><input size="7" type="text" id="edit_youya_i_3" style="display: none" onblur="savecode('youya','3')"/></td>
								    <td  align="center"  onclick="editcode('taoya','3')"    id="edit_taoya_t_3"   ><label id="edit_taoya_l_3"></label><input size="7" type="text" id="edit_taoya_i_3" style="display: none" onblur="savecode('taoya','3')"/></td>
								   <td  align="center"  onclick="editcode('temperature','3')"   id="edit_temperature_t_3"    ><label id="edit_temperature_l_3">${mon15.temperature}</label>
								     <input size="7" type="text" id="edit_temperature_i_3" style="display: none" onblur="savecode('temperature','3')"/></td>
								</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
								    <td align="center"  rowspan="2">四点</td>
								     <td  align="center"  onclick="editcode('oneday','4')"     id="edit_oneday_t_4"  ><label id="edit_oneday_l_4">19:00</label><input size="3" type="text" id="edit_oneday_i_4" style="display: none" onblur="savecode('oneday','4')"  /></td>
								    <td  align="center"  onclick="editcode('zhuqifangshi','4')"  id="edit_zhuqifangshi_t_4"   ><label id="edit_zhuqifangshi_l_4"></label><input size="7" type="text" id="edit_zhuqifangshi_i_4" style="display: none" onblur="savecode('zhuqifangshi','4')"/></td>
								    <td  align="center"  onclick="editcode('accumulative','4')"   id="edit_accumulative_t_4"  ><label id="edit_accumulative_l_4">${mon19.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_4" style="display: none" onblur="savecode('accumulative','4')"/></td>
								   <td  align="center"  onclick="editcode('instantaneous','4')"     id="edit_instantaneous_t_4" ><label id="edit_instantaneous_l_4">${mon19.instantaneousFlow}</label>
								     <input size="7" type="text" id="edit_instantaneous_i_4" style="display: none" onblur="savecode('instantaneous','4')"/></td>
								      <td  align="center"  onclick="editcode('pressure','4')"   id="edit_pressure_t_4"   ><label id="edit_pressure_l_4">${mon19.pressure}</label>
								        <input size="7" type="text" id="edit_pressure_i_4" style="display: none" onblur="savecode('pressure','4')"/></td>
								    <td  align="center"  onclick="editcode('youya','4')"   id="edit_youya_t_4"    ><label id="edit_youya_l_4"></label><input size="7" type="text" id="edit_youya_i_4" style="display: none" onblur="savecode('youya','4')"/></td>
								    <td  align="center"  onclick="editcode('taoya','4')"  id="edit_taoya_t_4"     ><label id="edit_taoya_l_4"></label><input size="7" type="text" id="edit_taoya_i_4" style="display: none" onblur="savecode('taoya','4')"/></td>
								     <td  align="center"  onclick="editcode('temperature','4')"  id="edit_temperature_t_4"      ><label id="edit_temperature_l_4">${mon19.temperature}</label>
								       <input size="7" type="text" id="edit_temperature_i_4" style="display: none" onblur="savecode('temperature','4')"/></td>
								   <td  align="center"  rowspan="2" onclick="editcode('tianbaoren','2')" id="edit_tianbaoren_t_2"    ><label id="edit_tianbaoren_l_2"></label><input size="7" type="text" id="edit_tianbaoren_i_2" style="display: none" onblur="savecode('tianbaoren','2')"/></td>
								</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
								     <td  align="center"  onclick="editcode('oneday','5')"   id="edit_oneday_t_5"    ><label id="edit_oneday_l_5">23:00</label><input size="3" type="text" id="edit_oneday_i_5" style="display: none" onblur="savecode('oneday','5')"  /></td>
								      <td  align="center"  onclick="editcode('zhuqifangshi','5')"  id="edit_zhuqifangshi_t_5"   ><label id="edit_zhuqifangshi_l_5"></label><input size="7" type="text" id="edit_zhuqifangshi_i_5" style="display: none" onblur="savecode('zhuqifangshi','5')"/></td>
								     <td  align="center"  onclick="editcode('accumulative','5')"    id="edit_accumulative_t_5" ><label id="edit_accumulative_l_5">${mon23.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_5" style="display: none" onblur="savecode('accumulative','5')"/></td>
								    <td  align="center"  onclick="editcode('instantaneous','5')"    id="edit_instantaneous_t_5"  ><label id="edit_instantaneous_l_5">${mon23.instantaneousFlow}</label>
								      <input size="7" type="text" id="edit_instantaneous_i_5" style="display: none" onblur="savecode('instantaneous','5')"/></td>
								    <td  align="center"  onclick="editcode('pressure','5')"   id="edit_pressure_t_5"   ><label id="edit_pressure_l_5">${mon23.pressure}</label>
								      <input size="7" type="text" id="edit_pressure_i_5" style="display: none" onblur="savecode('pressure','5')"/></td>
								    <td  align="center"  onclick="editcode('youya','5')"   id="edit_youya_t_5"    ><label id="edit_youya_l_5"></label><input size="7" type="text" id="edit_youya_i_5" style="display: none" onblur="savecode('youya','5')"/></td>
								    <td  align="center"  onclick="editcode('taoya','5')"    id="edit_taoya_t_5"   ><label id="edit_taoya_l_5"></label><input size="7" type="text" id="edit_taoya_i_5" style="display: none" onblur="savecode('taoya','5')"/></td>
								     <td  align="center"  onclick="editcode('temperature','5')"   id="edit_temperature_t_5"    ><label id="edit_temperature_l_5">${mon23.temperature}</label>
								       <input size="7" type="text" id="edit_temperature_i_5" style="display: none" onblur="savecode('temperature','5')"/></td>
								</tr>
								<tr bgcolor="#ffffff" onmouseover="this.className='row_over'"
									onmouseout="this.className='row_out'">
								    <td align="center" >全日</td>
								    <td  align="center"  onclick="editcode('oneday','6')"     id="edit_oneday_t_6"  ><label id="edit_oneday_l_6"></label><input size="3" type="text" id="edit_oneday_i_6" style="display: none" onblur="savecode('oneday','6')"  /></td>
								      <td  align="center"  onclick="editcode('zhuqifangshi','6')"  id="edit_zhuqifangshi_t_6" ><label id="edit_zhuqifangshi_l_6"></label><input size="7" type="text" id="edit_zhuqifangshi_i_6" style="display: none" onblur="savecode('zhuqifangshi','6')"/></td>
									   <td  align="center"  onclick="editcode('accumulative','6')"  id="edit_accumulative_t_6"><label id="edit_accumulative_l_6">${fullaverage.accumulativeFlow}</label><input size="7" type="text" id="edit_accumulative_i_6" style="display: none" onblur="savecode('accumulative','6')"/></td>
								    
								   <td  align="center"  onclick="editcode('instantaneous','6')"    id="edit_instantaneous_t_6"  ><label id="edit_instantaneous_l_6">${fullaverage.instantaneousFlow}</label><input size="7" type="text" id="edit_instantaneous_i_6" style="display: none" onblur="savecode('instantaneous','6')"/></td>
								    <td  align="center"  onclick="editcode('pressure','6')"   id="edit_pressure_t_6"   ><label id="edit_pressure_l_6">${fullaverage.pressure}</label><input size="7" type="text" id="edit_pressure_i_6" style="display: none" onblur="savecode('pressure','6')"/></td>
								    <td  align="center"  onclick="editcode('youya','6')"    id="edit_youya_t_6"   ><label id="edit_youya_l_6"></label><input size="7" type="text" id="edit_youya_i_6" style="display: none" onblur="savecode('youya','6')"/></td>
								    <td  align="center"  onclick="editcode('taoya','6')"   id="edit_taoya_t_6"    ><label id="edit_taoya_l_6"></label><input size="7" type="text" id="edit_taoya_i_6" style="display: none" onblur="savecode('taoya','6')"/></td>
								    <td  align="center"  onclick="editcode('temperature','6')"   id="edit_temperature_t_6"    ><label id="edit_temperature_l_6">${fullaverage.temperature}</label>
								    <input size="7" type="text" id="edit_temperature_i_6" style="display: none" onblur="savecode('temperature','6')"/></td>
								    <td  align="center"  rowspan="2" onclick="editcode('tianbaoren','3')" id="edit_tianbaoren_t_3"    ><label id="edit_tianbaoren_l_3"></label><input size="7" type="text" id="edit_tianbaoren_i_3" style="display: none" onblur="savecode('tianbaoren','3')"/></td>
								</tr>
	  </tbody>
							</s:if>
							<s:else>${htmls}</s:else>
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
						
					<input type="hidden" name="id" id="id"
						value="${id}" />
					<input type="hidden" name="htmls" id="htmls"
						value="" />
					<input type="hidden" name="wellno_h" id="wellno_h"
						value="${wellno_h}" />
					<input type="hidden" name="reporttime_h" id="reporttime_h"
						value="${reporttime_h}" />
				</div>
			</div>
		</form>
	</body>
</html>