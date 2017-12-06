//checkboxName要全选的checkbox的name值
function checkAll(checkboxName) {
	$("[name=" + checkboxName + "]").click(function() {
		if (this.checked) { // 如果当前点击的多选框被选中
			$("input[type=checkbox]").attr("checked", true);
		} else {
			$("input[type=checkbox]").attr("checked", false);
		}
	});
}

//msg要显示的提示信息
function showMessage(msg) {
	var $tbody = $("body");
	var $div = $("#dialog-message"); 
	if($div.length>0){
		$div.remove();
	}
	$div = "<div id='dialog-message' title='消息提示'><p>"
			+ "<span class='ui-icon ui-icon-circle-check' style='float:left; margin:0 7px 20px 0;'></span>"
			+ msg + "</p></div>";
	$tbody.append($div);
	$("#dialog:ui-dialog").dialog("destroy");
	$("#dialog-message").dialog({
		modal : true,
		buttons : {
			Ok : function() {
				$(this).dialog("close");
			}
		}
	});
}

//msg要显示的提示信息
function showAlarm(msg) {
	
	var id = generateMixed();
	
	var $tbody = $("body");
	var $div = $("#"+id); 
	if($div.length>0){
		$div.remove();
		$div.parent.removeChild($div);
	}
	$div = "<div id='"+id+"' title='报警信息'><p>"
			+ "<span class='ui-icon ui-icon-circle-check' style='float:left; margin:0 7px 20px 0;'></span>"
			+ msg + "</p></div>";
	$tbody.append($div);
	$("#dialog:ui-dialog").dialog("destroy");
	if(currentMsgId!=null&&$("#"+currentMsgId)!=null&&$("#"+currentMsgId)!=""){
		var pos = $("#"+currentMsgId).dialog().offset();
		var pleft = pos.left;
		var ptop = pos.top;
		
		if(ptop>500){
			ptop = 300;
		}
		if(pleft>1200){
			pleft = 650;
		}
		
		$("#"+id).dialog({
			position:[pleft+10,ptop-15],
			//modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("destroy");
					currentMsgId = null;
				}
			}
		});
		
	}else{
		$("#"+id).dialog({
			//modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("destroy");
					currentMsgId = null;
				}
			}
		});
	}
	
	currentMsgId = id;
	
	
}
var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];  
var currentMsgId;

generateMixed = function() {  
    var res = "";  
    for(var i = 0; i < 10 ; i ++) {  
        var id = Math.ceil(Math.random()*35);  
        res += chars[id];  
    }  
    return res;  
};  