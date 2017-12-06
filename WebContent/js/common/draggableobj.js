/**
 * 
 */
function DraggableObj(id, parentbox, pos ,sortable) {
	
	this.id = "#" + id;
	this.pos = pos;
	this.parentbox = "#" + parentbox;
	this.sortable = sortable;
	
	this.goPostion = function(pos) {
		this.pos = pos;
		this.postion();
	};
	this.postion = function(using) {
		
		$(this.id).position({
			of : $(this.parentbox),
			my : "left" + " " + "top",
			at : "left" + " " + "top",
			offset : this.pos,
			using : using,
			collision : "flip" + ' ' + "flip"
		});
	
		
	};

	this.drag = function(handle) {
		$(this.id).draggable({
			start : function(event, ui) {
			},
			drag : function(event, ui) {
				handle.postion(function(result) {
					handle.pos = ui.offset.left + " " + ui.offset.top;

				});
			},
			stop : function(event, ui) {

			},
			cursor : "move",
			connectToSortable: this.sortable,
			containment :this.parentbox,
			scroll : false,
			snap : true,
			opacity: 0.6

		});
	};

	this.drag(this);
	this.postion();
}
