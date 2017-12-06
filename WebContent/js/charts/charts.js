/* type是图标的类型(1-曲线图 2-柱状图 3-饼状图), divContent是要显是的区域的id, settingUrl是请求配置xml文件的url, dataUrl请求数据xml文件的url*/
function charts(type, divContent, width, height, settingUrl, dataUrl) {
	var amchartsSwf;
	if (type == 1) {
		amchartsSwf = "amcharts/flash/amline.swf";
	} else if (type == 2) {
		amchartsSwf = "amcharts/flash/amcolumn.swf";
	} else if (type == 3) {
		amchartsSwf = "amcharts/flash/ampie.swf";
	}
	var params = {
		bgcolor : "#FFFFFF"
	};
	var flashVars = {
		path : "amcharts/flash/",
		settings_file : encodeURIComponent(settingUrl),
		data_file : encodeURIComponent(dataUrl)
	};
	swfobject.embedSWF(amchartsSwf, divContent, width, height, "8.0.0", "amcharts/flash/expressInstall.swf", flashVars, params);
}