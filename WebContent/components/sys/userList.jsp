<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<%@ include file="/common/meta.jsp"%>
		<script type="text/javascript">
		function jumpPage(pageNo){
		    $("#pageNo").val(pageNo);
		    $("#mainForm").submit();
		}
		
		function jumpAppointed(){
			$("#pageNo").val($("#appionted").attr("value"));
		    $("#mainForm").submit();
		}
		
		function search(){
		    $("#mainForm").submit();
		}
		
		function add() {
			location.href = "${ctx}/user_input.do";
		}
		function edit() {
			var len = $("input[type=checkbox][name=ids]:checked").length;
			if(len==0||len>1){
				alert("请您选择一个用工需求进行编辑");
				return;
			}
			var id = $("input[type=checkbox][name=ids]:checked").val();
			location.href = "${ctx}/user_input.do?id="+id;
		}
		function del() {
			var isDelOrg = confirm("确认删除吗？");
			if(isDelOrg==false){
				return;				
			}
			$("#mainForm")[0].action="${ctx}/user_delete.do";
			$("#mainForm").submit();
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
		<form id="mainForm" action="${ctx}/user.do" method="post">
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>用户管理</span>
					</div>
					<div class="sa_box"></div>
				</div>
				<!--位置over-->

				<!--用户查询层-->
				<div class="searlist_box">
					<label>
						姓名：
						<input type="text" name="filter_LIKES_name" value="${param['filter_LIKES_name']}" />
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
					<div class="choose_box">
						<input name="allCheck" type="checkbox" onclick="javascript:checkAll('allCheck');"/>全选&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="${ctx}/images/view.png" width="16" height="16" title="新增" onclick="add();" />
						<a href="javascript:add();">新增</a> &nbsp;
						<img src="${ctx}/images/modify.png" width="16" height="16" title="编辑" onclick="edit();" />
						<a href="javascript:edit();">编辑</a> &nbsp;
						<img src="${ctx}/images/delete.png" width="16" height="16" title="删除" onclick="del();" />
						<a href="javascript:del();">删除</a>
					</div>
					<div class="page">
					<%@ include file="/common/page.jsp"%>
					</div>
				</div>
				<div class="userinfo_title">
	             	<span>用户列表</span>
	          	</div>
				<div class="userinfo_box">
					<table cellspacing="1" cellpadding="3" width="100%" bgcolor="#C4DDE1" border="0">
						<tbody>
							<tr bgcolor="#D0E6EA">
								<td align="left" width="5%" nowrap>
								</td>
								<td align="left" width="5%" nowrap>
									<strong>序号</strong>
								</td>
								<td align="left" width="15%" nowrap>
									<strong>姓名</strong>
								</td>
								<td align="left" width="10%" nowrap>
									<strong>用户名</strong>
								</td>
							</tr>
							<s:iterator value="page.result" status="s">
							<tr bgcolor="#ffffff" onmouseover="this.className='row_over'" onmouseout="this.className='row_out'">
								<td align="left">
									<input name="ids" type="checkbox" value="${id}" />
								</td>
								<td align="left">${s.count}</td>
								<td align="left">${name}</td>
								<td align="left">${loginName}</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="page_box">
					<div class="choose_box">
						<input name="allCheck" type="checkbox" onclick="javascript:checkAll('allCheck');"/>全选&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="${ctx}/images/view.png" width="16" height="16" title="新增" onclick="add();" />
						<a href="javascript:add();">新增</a> &nbsp;
						<img src="${ctx}/images/modify.png" width="16" height="16" title="编辑" onclick="edit();" />
						<a href="javascript:edit();">编辑</a> &nbsp;
						<img src="${ctx}/images/delete.png" width="16" height="16" title="删除" onclick="del();" />
						<a href="javascript:del();">删除</a>
					</div>
					<div class="page">
					<%@ include file="/common/page.jsp"%>
					</div>
				</div>
				<div class="new_user">					
					<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
					<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
					<input type="hidden" name="page.order" id="order" value="${page.order}" />
				</div>
			</div>
		</form>
	</body>
</html>