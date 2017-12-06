function flashingBorder(divid,begincolor,endcolor){
	this.interval = null;
	
	this.begincolor = "#D6DEFA";
	this.endcolor = "#FF0000";
	
	this.showbegin = 1;
	
	this.go = function(){
		if(this.interval == null){
			this.interval = setInterval(this.changeColor,1000);
		}
		
	};
	this.stop = function(){
		$( "#"+divid ).css("borderColor","#D6DEFA");
		window.clearInterval(this.interval);
		this.interval = null;
	};
	this.changeColor = function(){
		if(this.showbegin == 1){
			$( "#"+divid ).animate({
				borderColor:"#FF0000"
			}, 1000 );
			this.showbegin = 0;
		}else{
			$( "#"+divid ).animate({
				borderColor:"#D6DEFA"
				
			}, 1000 );
			this.showbegin = 1;
		}
	};
	
	
}