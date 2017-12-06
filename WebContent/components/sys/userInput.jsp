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
			$("#mainForm").validate({
				rules: {
					"loginName": {
						required: true,
						remote: "user_checkLoginName.do?oldLoginName=" + encodeURIComponent('${loginName}')
					},
					"name": "required",
					"password": {
						required: true,
						minlength:3
					},
					"passwordConfirm": {
						equalTo:"#password"
					}
				},
				messages: {
					loginName: {
						remote: "用户登录名已存在"
					},
					passwordConfirm: {
						equalTo: "输入与上面相同的密码"
					}
				}
			});
			
		});
		function save(){
			$("#mainForm").submit();
		}
		function goback(){
			location.href = "${ctx}/user.do";
		}
		</script>
	</head>
	<body style="text-align:center;">
		<form id="mainForm" name="mainForm" action="user_save.do" method="post">
			<input type="hidden" id="id" name="id" value="${id}" />
			<!--top说明层-->
			<div class="top_box">
				<!--位置-->
				<div class="position_box">
					<div class="pos_tit">
						<span>新增修改用户</span>
					</div>
					<div class="sa_box">
						<input class="button75" onmouseover="this.className='button75_over'" onmouseout="this.className='button75'"
							onmousedown="this.className='button75_down'" onclick=save(); value="保 存" type=button name=button1>
						<input class="button75" onmouseover="this.className='button75_over'" onmouseout="this.className='button75'"
							onmousedown="this.className='button75_down'" onclick=goback(); value="返 回" type=button name=button1>
					</div>
				</div>
				<!--位置over-->
				<!--用户查询层over-->
			</div>
			<!--top说明层over-->

			<!--页面主体层-->
			<!--表单-->
			<div class="form_box">
				<div class="form_con">
					<ul>
						<li class="form_con_lil">
							<font color="#F00000">*</font>姓名：
						</li>
						<li class="form_con_lir">
							<input type="text" id="name" name="name" value="${name}" />
						</li>
					</ul>
					<ul>
						<li class="form_con_lil">
							<font color="#F00000">*</font>用户名：
						</li>
						<li class="form_con_lir">
							<input type="text" id="loginName" name="loginName" value="${loginName}" />
						</li>
					</ul>
					<ul>
						<li class="form_con_lil">
							<font color="#F00000">*</font>密码：
						</li>
						<li class="form_con_lir">
							<input type="text" id="password" name="password" value="${password}" />
						</li>
					</ul>
					<ul>
						<li class="form_con_lil">
							<font color="#F00000">*</font>确认密码：
						</li>
						<li class="form_con_lir">
							<input type="text" id="passwordConfirm" name="passwordConfirm" value="${passwordConfirm}" />
						</li>
					</ul>
				</div>
			</div>
			<!--表单over-->
			<!--页面主体层over-->
		</form>
	</body>
</html>