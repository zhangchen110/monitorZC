<%@ page contentType="text/html;charset=UTF-8"%>
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
            $("#reporttime").datepicker();
            $("#mainForm").validate({
				rules: {
					"roomNumber": {
						required: true
					},
					"compressorNo": {
						required: true
					},
					"reporttime": {
						required: true
					} 
				}
			});
		});
	 	
		function search(){
		 	$("#options").attr("value",$("#compressorNo").html());
		   if( getTrueDay($("#reporttime").attr("value"))){
		   $("#mainForm").submit();
		   }
		}
		function save(){
			if(roomNumber==""||roomNumber==undefined){
 				return false;
 			}
 		   $("#options").attr("value",$("#compressorNo").html());
		   $("#htmls").attr("value",$("#reportlist").html());
		   $("#mainForm").attr("action","${ctx}/record_save.do");
		   $("#mainForm").submit();
		}
	 
 	function roomSelect(){
 		
 		var roomNumber = $("#roomNumber").val(); //获取井Id
 		if(roomNumber==""||roomNumber==undefined){
 			return false;
 		}
		$.get("${ctx}/record_ajaxSearch.do?roomNumber=" + roomNumber, {},function (data){
			$("#compressorNo").html(data);
		});
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
		<form id="mainForm" action="${ctx}/record_execute.do" method="post">
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>压缩机信息查询列表</span>
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->

				<!--用户查询层-->
				<div class="searlist_box">
				 
								机房编号编号：
								<s:select style="width: 140px" list="machineRoomList" listKey="roomNo" listValue="roomName" name="roomNumber" id="roomNumber" onchange="roomSelect()" headerKey="" headerValue="请选择"></s:select>
								压缩机编号：
								<select name="compressorNo" id="compressorNo"  style="width: 160px">${options}</select>
								具体日期：
								<input id="reporttime" name="reporttime" type="text" value="${reporttime}"/>
								<input type="button" value="查询" onclick="javascript:search();" />
								<s:if test="roomNumber=='暂时不实现存储功能'">
								<input type="button" value="保存" onclick="javascript:save();" />
								</s:if>
					 
				</div>
				<!--用户查询层over-->
			</div>
			<!--top说明层over-->
<!--页面主体层-->
			<!--用户信息列表-->
			<div class="userlist_box">
			<s:if test="messageOne.size>0||messageThree.size>0">
				<div class="userinfo_title">
					 <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前机房：${compressorIndex[roomNumber]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前压缩机编号：${titleNO}</span>
				</div>
			</s:if>
				<div class="userinfo_box">
					<table id="reportlist"  cellspacing="1" cellpadding="3" width="100%"
						bgcolor="#C4DDE1" border="0">
							<s:property value="ishtml" />
							<s:property value="htmls" />
							<s:if test="htmls==''">
								<s:if test="roomNumber=='MR1'">
									<tbody>
										  <tr>
										  <td colspan="20"  align="center"><font size="+2">空气压缩机组运行记录</font></td>
										  </tr>
										   <tr>
										  <td colspan="3" rowspan="2">时间</td>
										  <td colspan="12" align="center"><font size="+1">空气压缩机</font></td><td rowspan="2">备注</td>
										  </tr>
										  <tr>
										   <td>机油压力(MPa)</td><td>冷却水压力(MPa)</td><td>螺杆压力(MPa)</td><td>螺杆温度(℃)</td><td>一级活塞压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级活塞温度(℃)</td><td>三级活塞压力(MPa)</td><td>三级活塞温度(℃)</td><!--<td>运行状态</td><td>运行时间(h)</td>--><td>机油温度(℃)</td><td>冷却水温度(℃)</td>
										  </tr>
										   <s:iterator value="messageOne" status="s" var="em">
														<tr>
														<td width="5%"><s:date name="time" format="MM" />月<s:date name="time" format="dd" />日</td>  
														<td width="3%"><s:date name="time" format="HH:mm" /></td>
														<td width="11%">${compressorIndex[compressorCode]}</td>
															<td><label>${  oilPressure}</label><input/></td> 
															<td><label>${  coolingWaterPressure}</label><input/></td> 
															<td><label>${  screwPressure}</label><input/></td> 
															<td><label>${  screwTemperature}</label><input/></td> 
															<td><label>${  firstPistonPressure}</label><input/></td> 
															<td><label>${  firstPistonTemperature}</label><input/></td> 
															<td><label>${  secondPistonPressure}</label><input/></td> 
															<td><label>${  secondPistonTemperature}</label><input/></td> 
															<td><label>${  thirdPistonPressure}</label><input/></td> 
															<td><label>${  thirdPistonTemperature}</label><input/></td> 
															<!--<td>
																<s:if test="runningState==0&&runningState!=''"> <label>停止</label>	</s:if>
																<s:if test="runningState==1"> <label>正常</label>	</s:if>
																<s:if test="runningState==2"> <label>报警</label>	</s:if>
																<input/>
															</td> 
															 <td><label>${  runningTime}</label><input/></td> --> 
															<td><label>${  oilTemperature}</label><input/></td> 
															<td><label>${  coolingWaterTemperature}</label><input/></td> 
														<s:if test="#s.count==1"><td rowspan="24" width="5%"></td></s:if>
													 	</tr>
											  </s:iterator>
									 </tbody>
								</s:if>
								<s:if test="roomNumber=='MR2'">
									<tbody>
										     <tr>
											  <td colspan="27"  align="center"><font size="+2">空气压缩机组运行记录</font></td>
											  </tr>
											   <tr>
											  <td colspan="3" rowspan="2">时间</td>
											  <td colspan="4" align="center"><font size="+1">螺杆机</font></td><td colspan="9" align="center"><font size="+1">压缩机</font></td><td rowspan="2">备注</td>
											  </tr>
											  <tr>
											    <td>机油压力(MPa)</td> <td>排气压力(MPa)</td><td>螺杆出气温度1(℃)</td><td>螺杆出气温度2(℃)</td> <!--  <td>运行状态</td> -->
											    <!--<td>运行时间(h)</td>-->
											   <td>进气压力(MPa)</td><td>一级活塞压力(MPa)</td><td>二级活塞压力(MPa)</td><td>三级活塞压力(MPa)</td><td>机油压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞温度(℃)</td><td>三级活塞温度(℃)</td><td>机油温度(℃)</td><!--<td>运行状态</td><td>运行时间(h)</td>-->
											  </tr>
											  
											  <s:iterator value="messageThree" status="s" var="em">
														<tr>
														<td width="5%"><s:date name="time" format="MM" />月<s:date name="time" format="dd" />日</td>  
														<td width="3%"><s:date name="time" format="HH:mm" /></td>
														<td width="8%">${compressorIndex[compressorCode]}|${compressorIndex[compressorCode_ya]}</td>
															<td><label>${  oilPressure}</label><input/></td> 
															<td><label>${  exhaustPressure}</label><input/></td> 
															<td><label> ${ outScrewTemperature1}</label><input/></td>
														    <td><label> ${ outScrewTemperature2}</label><input/></td>   
															<!--<td>
																<s:if test="runningState==0&&runningState!=''"> <label>停止</label>	</s:if>
																<s:if test="runningState==1"> <label>正常</label>	</s:if>
																<s:if test="runningState==2"> <label>报警</label>	</s:if>
																<input/>
															</td>  --> 
															<!-- <td><label>${  runningTime }</label><input/></td> --> 
														 
															<td><label>${  inletPressure_ya}</label><input/></td> 
															<td><label>${  firstPistonPressure_ya}</label><input/></td> 
															<td><label>${  secondPistonPressure_ya}</label><input/></td> 
															<td><label>${  thirdPistonPressure_ya}</label><input/></td> 
															<td><label>${  oilPressure_ya}</label><input/></td> 
															<td><label>${  firstPistonTemperature_ya}</label><input/></td> 
															<td><label>${  secondPistonTemperature_ya}</label><input/></td> 
															<td><label>${  thirdPistonTemperature_ya}</label><input/></td> 
															<td><label>${  oilTemperature_ya}</label><input/></td> 
															<!--<td>
																<s:if test="runningState_ya==0&&runningState_ya!=''"> <label>停止</label>	</s:if>
																<s:if test="runningState_ya==1"> <label>正常</label>	</s:if>
																<s:if test="runningState_ya==2"> <label>报警</label>	</s:if>
																<input/>
															</td> 
															 <td><label>${  runningTime_ya}</label><input/></td> -->     
														<s:if test="#s.count==1"><td rowspan="24" width="4%"></td></s:if>
													 	</tr>
											  </s:iterator>
									 </tbody>
								</s:if>
								<s:if test="roomNumber=='MR3'">
									 <tbody>
										     <tr>
											  <td colspan="27"  align="center"><font size="+2">空气压缩机组运行记录</font></td>
											  </tr>
											   <tr>
											  <td colspan="3" rowspan="2">时间</td>
											  <td colspan="4" align="center"><font size="+1">螺杆机</font></td><td colspan="6" align="center"><font size="+1">压缩机</font></td><td rowspan="2">备注</td>
											  </tr>
											  <tr>
											     <td>排气温度(℃)</td><td>排气压力(MPa)</td><td>机油压力(MPa)</td><td>机油温度(℃)</td><!-- <td>运行状态</td> --><!-- <td>运行时间(h)</td> -->												
											      <td>一级活塞压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级活塞温度(℃)</td><td>机油压力(MPa)</td><td>机油温度(℃)</td><!--<td>运行状态</td><td>运行时间(h)</td>-->
											  </tr>
											   <s:iterator value="messageThree" status="s" var="em">
														<tr >
														<td width="5%"><s:date name="time" format="MM" />月<s:date name="time" format="dd" />日</td>  
														<td width="3%"><s:date name="time" format="HH:mm" /></td>
														<td width="8%">${compressorIndex[compressorCode]}|${compressorIndex[compressorCode_ya]}</td>
														 	    <td><label>${  exhaustTemperature}</label><input/></td> 
																<td><label>${  exhaustPressure}</label><input/></td> 
																<td><label>${  oilPressure}</label><input/></td> 
																<td><label>${  oilTemperature}</label><input/></td> 
																<!-- <td>
																	<s:if test="runningState==0&&runningState!=''"> <label>停止</label>	</s:if>
																	<s:if test="runningState==1"> <label>正常</label>	</s:if>
																	<s:if test="runningState==2"> <label>报警</label>	</s:if>
																	<input/>
																</td>   -->
																<!-- <td><label>${  runningTime}</label><input/></td>--> 
																<td><label>${  firstPistonPressure_ya}</label><input/></td> 
																<td><label>${  firstPistonTemperature_ya}</label><input/></td> 
																<td><label>${  secondPistonPressure_ya}</label><input/></td> 
																<td><label>${  secondPistonTemperature_ya}</label><input/></td> 
																<td><label>${  oilPressure_ya}</label><input/></td> 
																<td><label>${  oilTemperature_ya}</label><input/></td> 
																<!-- <td>
																	<s:if test="runningState_ya==0&&runningState_ya!=''"> <label>停止</label>	</s:if>
																	<s:if test="runningState_ya==1"> <label>正常</label>	</s:if>
																	<s:if test="runningState_ya==2"> <label>报警</label>	</s:if>
																	<input/>
																</td> 
																<td><label>${  runningTime_ya}</label><input/></td> -->
														<s:if test="#s.count==1"><td rowspan="24" width="4%"></td></s:if>
													 	</tr>
											  </s:iterator>
									 </tbody>
								</s:if>
								<s:if test="roomNumber=='MR4'">
									 <tbody>
										      <tr>
												  <td colspan="18"  align="center"><font size="+2">空气压缩机组运行记录</font></td>
												  </tr>
												   <tr>
												  <td colspan="3" rowspan="2">时间</td>
												  <td colspan="10" align="center"><font size="+1">压缩机</font></td> <td rowspan="2">备注</td>
												  </tr>
												  <tr><td>机油压力(MPa)</td><td>冷却水压力(MPa)</td><td>螺杆压力(MPa)</td><td>螺杆温度(℃)</td><td>一级活塞压力(MPa)</td><td>一级活塞温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级活塞温度 (℃)</td><!-- <td>运行状态</td><td>运行时间(h)</td>--><td>机油温度(℃)</td><td>冷却水温度(℃)</td>
												  </tr>
												  <s:iterator value="messageOne" status="s" var="em">
														<tr  >
														<td width="5%"><s:date name="time" format="MM" />月<s:date name="time" format="dd" />日</td>  
														<td width="3%"><s:date name="time" format="HH:mm" /></td>
														<td width="11%">${compressorIndex[compressorCode]}</td>
														 	<td><label>${  oilPressure}</label><input/></td> 
															<td><label>${  coolingWaterPressure}</label><input/></td> 
															<td><label>${  screwPressure}</label><input/></td> 
															<td><label>${  screwTemperature}</label><input/></td> 
															<td><label>${  firstPistonPressure}</label><input/></td> 
															<td><label>${  firstPistonTemperature}</label><input/></td> 
															<td><label>${  secondPistonPressure}</label><input/></td> 
															<td><label>${  secondPistonTemperature}</label><input/></td> 
															<!-- <td>
																<s:if test="runningState==0&&runningState!=''"> <label>停止</label>	</s:if>
																<s:if test="runningState==1"> <label>正常</label>	</s:if>
																<s:if test="runningState==2"> <label>报警</label>	</s:if>
																<input/>
															</td>  
															<td><label>${  runningTime}</label><input/></td> --> 
															<td><label>${  oilTemperature}</label><input/></td>  
															<td><label>${  coolingWaterTemperature}</label><input/></td> 
														<s:if test="#s.count==1"><td rowspan="24" width="4%"></td></s:if>
													 	</tr>
											  </s:iterator>
									 </tbody>
								</s:if>
								<s:if test="roomNumber=='MR5'">
									 <tbody>
										      <tr>
											  <td colspan="33"  align="center"><font size="+2">空气压缩机组运行记录</font></td>
											  </tr>
											   <tr>
											  <td colspan="3" rowspan="2">时间</td>
											  <td colspan="3" align="center"><font size="+1">螺杆机</font></td> <td colspan="10" align="center"><font size="+1">压缩机</font></td> <td rowspan="2">备注</td>
											  </tr>
											  <tr >
												  <td>轴承温度(℃)</td><td>螺杆出气温度1(℃)</td><td>螺杆出气温度2(℃)</td><!-- <td>运行状态</td> --><!-- <td>运行时间(h)</td> -->
												  <td>进气温度(℃)</td><td> 进气压力(MPa)</td><td>一级活塞压力(MPa)</td><td>一级排气温度(℃)</td><td>二级进气温度(℃)</td><td>二级活塞压力(MPa)</td><td>二级排气温度(℃)</td><td>机油压力(MPa)</td><td>机油温度(℃)</td><td>进气压力(KPa)</td><!--<td>运行状态</td><td>运行时间(h)</td>-->
											  </tr>
											  <s:iterator value="messageThree" status="s" var="em">
														<tr >
														<td width="5%"><s:date name="time" format="MM" />月<s:date name="time" format="dd" />日</td>  
														<td width="3%"><s:date name="time" format="HH:mm" /></td>
														<td width="8%">${compressorIndex[compressorCode]}|${compressorIndex[compressorCode_ya]}</td>
														
														<td><label> ${ bearingTemperature}</label><input/></td>  
														<td><label> ${ outScrewTemperature1}</label><input/></td>
														<td><label> ${ outScrewTemperature2}</label><input/></td>    
														<!-- <td>
															<s:if test="runningState==0&&runningState!=''"> <label>停止</label>	</s:if>
															<s:if test="runningState==1"> <label>正常</label>	</s:if>
															<s:if test="runningState==2"> <label>报警</label>	</s:if>
															<input/>
														</td>  -->
														<!--<td><label> ${ runningTime}</label><input/></td>-->  
														<td><label> ${ inletTemperature}</label><input/></td>
														<td><label> ${ inletinletPressure}</label><input/></td>
														<td><label> ${ firstPistonPressure_ya}</label><input/></td>  
														<td><label> ${ firstExhaustTemperature_ya}</label><input/></td>  
														<td><label> ${ secondInletTemperature_ya}</label><input/></td>  
														<td><label> ${ secondPistonPressure_ya}</label><input/></td>  
														<td><label> ${ secondExhaustTemperature_ya}</label><input/></td> 
														<td><label> ${ oilPressure_ya}</label><input/></td>  
														<td><label> ${ oilTemperature_ya}</label><input/></td> 
														<td><label> ${ inletPressure}</label><input/></td> 
														<!-- <td>
															<s:if test="runningState_ya==0&&runningState_ya!=''"> <label>停止</label>	</s:if>
															<s:if test="runningState_ya==1"> <label>正常</label>	</s:if>
															<s:if test="runningState_ya==2"> <label>报警</label>	</s:if>
															<input/>
														</td>
														<td><label> ${ runningTime_ya}</label><input/></td>--> 
														
													 	<s:if test="#s.count==1"><td rowspan="30" width="4%"></td></s:if>
													 	</tr>
											  </s:iterator>
									 </tbody>
								</s:if>
							</s:if>
							<s:else>${htmls}</s:else>
							
					</table>
				 
				</div>
				<div class="page_box">
					<div class="choose_box">
					</div>
				</div>
				<div class="new_user">
					<input type="hidden" name="htmls" id="htmls"  value="" />
					<input type="hidden" name="options" id="options"  value="" />
				</div>
			</div>
		</form>
	</body>
</html>