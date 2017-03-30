//左边菜单插件。
(function($){   
$.fn.leftMenu=function(options){
var defaults = {
	sibling:'h4',
	nextSibling:'ul',
	};
	var opt = $.extend(defaults,options);
	var $currentThis = $(this);
	return $currentThis.find(opt.sibling).each(function(){
		var $this = $(this);
		$this.click(function(e){
			e.preventDefault();
			$currentThis.find(opt.sibling).removeClass('on');
			$currentThis.find(opt.nextSibling).slideUp();
			$this.addClass("on");
			$this.next().slideDown();
			//$("#cleft").mCustomScrollbar("destroy");
			//$("#cleft").mCustomScrollbar("update"); //update scrollbar according to newly loaded content
		   // $("#cleft").mCustomScrollbar("scrollTo","h2:last",{scrollInertia:2500,scrollEasing:"easeInOutQuad"}); //scroll to appended content
		});
		$this.next().find('a').click(function(){
				$this.next().find('li').removeClass('on');
				$(this).parent().addClass('on');
		});
	});
};
})(jQuery); 
  
$(function() {
	var browser=navigator.appName;
	$("#cleft-id").leftMenu();
	resizeWindows('#bezel-id');
});
function outLogin(){
	location.href='login.html';
}
