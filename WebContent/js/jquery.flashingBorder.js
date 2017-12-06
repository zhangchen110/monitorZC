var flashingMap = new Map();
(function($){
	
	$.fn.flashingBorder = function(options) {
		var defaults = { 
				
		  	};
		
		var opts = $.extend(defaults, options);
		var id = $(this).attr("id");
		if(id==null||id==""){
			return;
		}
		var flashingObj = flashingMap.get(id);
		if(flashingObj == null){
			flashingObj = new flashingBorder(id);
			flashingMap.put(id, flashingObj);
		}
		return flashingObj;
	};
})(jQuery); 
