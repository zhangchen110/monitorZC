/** type是选择的类型,1-选择部门 2-选择人员 3-选择部门和人员;mode是选择的方式,1-单选 2-多选; checkType是选择的关系配置* */
function config(type, mode, checkType, idContent, nameContent, typeContent) {
	var url = "select_toSelect.do?type=" + type + "&mode=" + mode + "&checkType=" + checkType;
	//var retValue = window.showModalDialog(url,window,"dialogWidth:700px;dialogHeight:700px;dialogLeft:300px;dialogTop:200px;center:yes;help:no;resizable:no;status:no;");
	parent.showModalWindow("", url, "bodydiv", 500, 300,function(){
		var retValue = parent.dialogValue;
		if (typeof (retValue) != "undefined" && retValue != "") {
			var str = retValue.split(";");
			$("#" + idContent).val(str[0]);
			$("#" + nameContent).val(str[1]);
			$("#" + typeContent).val(str[2]);
		}
	});
}

/** type是选择的类型,1-选择部门 2-选择人员 3-选择角色;mode是选择的方式,1-单选 2-多选; checkType是选择的关系配置* */
function config1(type, mode, checkType,callback) {
	var url = "select_toSelect.do?type=" + type + "&mode=" + mode + "&checkType=" + checkType;
	//var retValue = window.showModalDialog(url,window,"dialogWidth:700px;dialogHeight:700px;dialogLeft:300px;dialogTop:200px;center:yes;help:no;resizable:no;status:no;");
	parent.showModalWindow("", url, "bodydiv", 500, 300,function(){
		var retValue = parent.dialogValue;
		if (typeof (retValue) != "undefined" && retValue != "") {
			var str = retValue.split(";");
			var ids = str[0];
			var names = str[1];
			var types = str[2];
			callback(ids, names, types);
		}
	});
	
}

/** groupNo是代码组的编码,idContent是初始化的下拉框的id checkValue是要选中的值**/
function showCode(groupNo, idContent, checkValue) {
	$.get("${ctx}/code_select.do", {
		groupNo : encodeURIComponent(groupNo)
	}, function(data, status) {
		var sel = $("#" + idContent);
		var str = data.split(";");
		for ( var i = 0; i < str.length; i++) {
			var s = str[i].split(",");
			if(checkValue==s[0]){
				var opt = "<option value='" + s[0] + "' selected='selected'>" + s[1] + "</option>";
			}else{
				var opt = "<option value='" + s[0] + "'>" + s[1] + "</option>";
			}		
			sel.append(opt);
		}
	});
}