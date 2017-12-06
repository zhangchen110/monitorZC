<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<script type="text/javascript">
		$(document).ready(function() {
	   
	    });
		function save(){
			$("#mainForm").submit();
		}
		function addIndex(){
			var num = $("#num").val();
			num++;
			var $div = $("#indexTable");
			var $ul = $("<ul id="+num+">"+
		            "<li class='form_tit4'>指标名称:</li><input type='hidden' name='indexIdList' value='${i.id}' />"+
		            "<li class='form_in'><input name='indexNameList' value='${i.indexName}' /></li>"+
		            "<li class='form_tit4'>指标编码:</li>"+
		            "<li class='form_in'><input name='indexCodeList' value='${i.indexCode}' /></li>"+
		            "<li class='form_tit4'>单位:</li>"+
		            "<li class='form_in'><input name='unitList' value='${i.unit}' /></li>"+
		            "<li class='form_tit4'>报警选择</li>"+
		            "<li class='form_in'><select name='statusList' id='statusList'>"+
               		"<option value=0 <s:if test='#i.status==0'>selected='true'</s:if>>报警指标</option>"+
               		"<option value=1 <s:if test='#i.status==1'>selected='true'</s:if>>非报警指标</option>"+
               		"</select></li>"+
               		"<li class='form_tit5'>排序:</li>"+
	               	" <li class='form_in1'><input  name='orderByList' value='${i.orderBy}' /></li>"+
		            "<li class='form_tit5'>最大值:</li>"+
		            "<li class='form_in1'><input name='maxList' value='${i.max}' /></li>"+
		            "<li class='form_tit5'>最小值:</li>"+
		            "<li class='form_in1'><input name='minList' value='${i.min}' /></li>"+
		            "<li class='form_tit5'>最大上限:</li>"+
		            "<li class='form_in1'><input  name='maxLimitList' value='${i.maxLimit}' /></li>"+
		            "<li class='form_tit5'>最小下限:</li>"+
		            "<li class='form_in1'><input  name='minLimitList' value='${i.minLimit}' /></li>"+
		            "<li class='form_but'><input type='button' value='删除' onclick='delIndex("+num+");' /></li></ul>");		
		   	$div.append($ul);
			$("#num").val(num);
		}
		function delIndex(num) {
			if(confirm("确认删除节点吗")){
				$("ul[id="+num+"]").remove();
			}		
		}
		function goback(){
			location.href = "${ctx}/machineRoom.do";
		}
		</script>
	</head>
	<body>
		<form id="mainForm" action="${ctx}/machineRoomIndex_save.do" method="post">
			<input type="hidden" name="num" id="num" value="<s:property value="indexList.size()"/>"/>
			<input type="hidden" name="machineRoomId" id="machineRoomId" value="${machineRoomId}"/>
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>流程配置</span>
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->
			</div>
			<!--top说明层over-->
			
		    <div class="form_box">
		    	<div class="page_box">
					<div class="choose_box">
						<input class="button75" onmouseover="this.className='button75_over'" onmouseout="this.className='button75'"
							onmousedown="this.className='button75_down'" onclick=addIndex(); value="新增指标" type=button name=button1>
						<input class="button75" onmouseover="this.className='button75_over'" onmouseout="this.className='button75'"
							onmousedown="this.className='button75_down'" onclick=save(); value="保 存" type=button name=button1>
						<input class="button75" onmouseover="this.className='button75_over'" onmouseout="this.className='button75'"
							onmousedown="this.className='button75_down'" onclick=goback(); value="返 回" type=button name=button1>
					</div>
				</div>
	        	<div class="form_con" id="indexTable">
	        		<s:iterator value="indexList" status="s" var="i">
		           	<ul id="${s.count}">
		               <li class="form_tit4">指标名称:</li><input type="hidden" name="indexIdList" value="${i.id}" />
		               <li class="form_in"><input name="indexNameList" value="${i.indexName}" /></li>
		               <li class="form_tit4">指标编码:</li>
		               <li class="form_in"><input name="indexCodeList" value="${i.indexCode}" /></li>
		               <li class="form_tit4">单位:</li>
		               <li class="form_in"><input name="unitList" value="${i.unit}" /></li>
		               <li class='form_tit4'>报警选择</li>
		               <li class='form_in'><select name='statusList' id='statusList'>
		               		<option value=0 <s:if test='#i.status==0'>selected='true'</s:if>>报警指标</option>
		               		<option value=1 <s:if test='#i.status==1'>selected='true'</s:if>>非报警指标</option>
		               	</select></li>
	               	   <li class="form_tit5">排序:</li>
	               	   <li class="form_in1"><input  name="orderByList" value="${i.orderBy}" /></li>
		               <li class="form_tit5">最大值:</li>
		               <li class="form_in1"><input name="maxList" value="${i.max}" /></li>
		               <li class="form_tit5">最小值:</li>
		               <li class="form_in1"><input name="minList" value="${i.min}" /></li>
	               	   <li class="form_tit5">最大上限:</li>
	               	   <li class="form_in1"><input  name="maxLimitList" value="${i.maxLimit}" /></li>
	                   <li class="form_tit5">最小下限:</li>
	               	   <li class="form_in1"><input  name="minLimitList" value="${i.minLimit}" /></li>
		               <li class="form_but"><input type="button" value="删除" onclick="delIndex(${s.count});" /></li>
		           	</ul>
		           	</s:iterator>
	        	</div>  
	        </div>        
		</form>
	</body>
</html>