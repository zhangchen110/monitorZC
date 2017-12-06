//id 是初始化的文件框的id   
//callback是回调函数,response后台传过来的上传成功的附件id,如果上传失败,id为0  
//image是要显示的上传按钮的图片路径
//action是如果默认的上传action处理类不能满足你的业务要求,你自己定义的action请求路径,为空就是使用默认的上传的action类。
function initUploadify(id, callback, image, action, isMulti) {
	if (action == null || action == '') {
		action = 'attachment_upload.do?jsessionid=${pageContext.session.id}';
	}
	if(isMulti == null || isMulti == ''){
		isMulti = false;
	}
	$("#" + id).uploadify({
		'uploader' : 'js/uploadify/scripts/uploadify.swf',
		'script' : action+'?jsessionid=${pageContext.session.id}',
		'fileDataName' : 'att',
		'folder' : 'uploads',
		'queueID' : 'fileQueue',
		'cancelImg' : 'js/uploadify/cancel.png',
		'buttonImg' : image,
		'height' : '16',
		'width' : '16',
		'auto' : true,
		'multi' : isMulti,
		'onComplete' : function(event, queueID, fileObj, response, data) {
			callback(response);
		}
	});
}
