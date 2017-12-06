<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/meta.jsp"%>
<style type="text/css">

	}
</style>
<title>添加井指标信息</title>
<script type="text/javascript">
$().ready(function(){
	
	$("#mainForm").focus();
	//为mainForm注册validate函数
	$("#mainForm").validate({
		rules: {
			"wellNo": {
				required: true,
				maxlength:15
			},
			"wellName":{
				required:true,
				maxlength:15,
				minlength:2
			},
			"indexNames":{
				required:true
			}
			
		}
	});
});
	//增加一行
	function addNode(){
		var tmp=$("#num").val();
    	tmp++;
    	var $div=$(".form_con");
    	var $str=$("<ul id='"+tmp+"'>"+
				"<li class='form_tit'>指标名称：</li>"+
				"<input type='hidden' name='indexIds' />"+
				"<li class='form_in'><input  name='indexNames'/></li>"+
				"<li class='form_tit'>指标编码：</li>"+
				"<li class='form_in'><input name='indexCodes'/></li>"+
				"<li class='form_tit'>单位：</li>"+
				"<li class='form_in'><input name='units' /></li>"+
				"<li class='form_tit'>报警选择:</li>"+
        		"<li class='form_in1'>"+
        		"<select id='statusList' name='statusList' >"+
        		"<option value=0 <s:if test='#i.status==0'>selected='true'</s:if>>报警指标</option>"+
        		"<option value=1 <s:if test='#i.status==1'>selected='true'</s:if>>非报警指标</option>"+
        		"</select></li>"+
				"<li class='form_tit'>最大值：</li>"+
				"<li class='form_in1'><input name='maxs'></li>"+
				"<li class='form_tit'>最小值：</li>"+
				"<li class='form_in1'><input name='mins'/></li>"+
				"<li class='form_tit'>最高上限：</li>"+
				"<li class='form_in1'><input name='maxLimitList'/></li>"+
				"<li class='form_tit'>最低下限：</li>"+
				"<li class='form_in1'><input name='minLimitList'/></li>"+
		        "<li class='form_but'><input type='button' value='删除' onclick='delNode("+tmp+");' /></li></ul>");
    	$div.append($str);
    	$("#num").val(tmp);//赋值
	}
	//删除增加的某一行
	function delNode(num){
		var isDel=confirm("确认删除吗");
		if(isDel==false)return;
		$("ul[id='"+num+"']").remove();
	}
	function save(){
		$("#mainForm").submit();
	}
	
	function goback(){
		location.href = "${ctx}/well.do";
	}

</script>
</head>
	<body style="text-align:center;">
	<form id="mainForm" name="mainForm" action="well_save.do" method="post">
			<input type="hidden" id="id" name="id" value="${id}" />
			<input type="hidden"" id="num" name="num" value="<s:property value='indexList.size()'/>" />
	<!--top说明层-->
<div class="top_box">
   <!--位置-->
   <div class="position_box">
       <div class="pos_tit">
       </div>
       <div class="sa_box">
       <INPUT class=button75 onmouseover="this.className='button75_over'" onmouseout="this.className='button75'" onmousedown="this.className='button75_down'" onclick="save();" value="保 存" type=button name=button1> 
	   <input type="button" name="button1" value="返 回" onclick="goback();" class="button75" onmouseover="this.className='button75_over'" onmouseout="this.className='button75'" onmousedown="this.className='button75_down'" />
	   </div>
   <!--位置over-->

   <!--用户查询层
   <div class="searlist_box">
        
   </div>-->
   <!--用户查询层over-->
</div>
<!--top说明层over-->

<!--页面主体层-->
  <!--表单-->
  <div class="form_box" style="overflow:hidden;">
        <div class="form_con" >
           <ul>
               <li class="form_con_lil"><font color="#F00000">*</font>井号：</li>
               <li class="form_con_lir"><input maxLength="64" size="40%" name="wellNo" value="${wellNo}" class="InputCssblur" onFocus="this.className='InputCssfocus';" onBlur="this.className='InputCssblur';" /></li>
           </ul>
           <ul>
               <li class="form_con_lil">井描述：</li>
               <li class="form_con_lir"><input maxLength="64" size="40%" name="wellName" value="${wellName}" class="InputCssblur" onFocus="this.className='InputCssfocus';" onBlur="this.className='InputCssblur';" /></li>
           </ul>
           <ul>
               <li class="form_con_lil"><font color="#F00000"></font>井指标信息：</li>
               <li style="text-align:right;"><input type="button" name="insertButton" value="增加" class="button75" onclick="addNode();"/></li>
           </ul>
        	<s:iterator value="indexList" status="s" var="i">
        	<ul id="${s.count}">
        		<li class='form_tit'></font>指标名称：</li>
        		<input type="hidden" name="indexIds" value="${i.id}" />
        		<li class='form_in'><input name='indexNames' value='${i.indexName}' /></li>
        		<li class='form_tit'>指标编码：</li>
        		<li class='form_in'><input name='indexCodes' value='${i.indexCode}' /></li>
        		<li class='form_tit'>单位：</li>
        		<li class='form_in'><input name='units' value='${i.unit}'  /></li>
        		<li class='form_tit'>报警选择:</li>
        		<li class='form_in1'>
        		<select id="statusList" name='statusList' >
        		<option value=0 <s:if test='#i.status==0'>selected='true'</s:if>>报警指标</option>
        		<option value=1 <s:if test='#i.status==1'>selected='true'</s:if>>非报警指标</option>
        		</select></li>
        		<li class='form_tit'>最大值：</li>
        		<li class='form_in1'><input name='maxs' value='${i.max}' /></li>
        		<li class='form_tit'>最小值：</li>
        		<li class='form_in1'><input name='mins' value='${i.min}' /></li>
        		<li class='form_tit'>最高上限：</li>
        		<li class='form_in1'><input name='maxLimitList' value='${i.maxLimit}'  /></li>
        		<li class='form_tit'>最低下限：</li>
        		<li class='form_in1'><input name='minLimitList' value='${i.minLimit}' /></li>
		        <li class='form_but'><input type="button" value="删除" onclick="delNode(${s.count});" /></li>
		    </ul>
		    </s:iterator>
        </div>
  </div>
  </form>
  <!--表单over-->
<!--页面主体层over-->
	</body>
</html>