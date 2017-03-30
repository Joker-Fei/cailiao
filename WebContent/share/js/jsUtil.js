/* 自动适应窗体高度  */
function resizeWindows(id){
	var obj = $(id);
	var mainHeight = obj.height();
	//-parseInt($("#"+id).css("margin-top"))*2
	//获取主题的边框高度
	var boderWidth = isNaN(parseInt(obj.css("border-width")))? 0:parseInt(obj.css("border-width"));
	//获取~上外边距
	var marginTop = isNaN(parseInt(obj.css("margin-top")))? 0:parseInt(obj.css("margin-top"));
	//获取~下外边距
	var marginBottom =isNaN(parseInt(obj.css("margin-bottom")))? 0:parseInt(obj.css("margin-bottom"));
	var lastHeight = $(window).height()-boderWidth-marginTop-marginBottom;
	if(mainHeight>=lastHeight){
		lastHeight = mainHeight;
	}
	obj.height(lastHeight);
}