$(function() {
	/**
	 * 退出 1.获取退出按钮并且添加点击事件 2.调用退出接口实现退出功能
	 */

	$('.login_out_bot').click(function() {
		if (confirm("确定要退出吗?")) {
			$.ajax({
				url : url + '/endLogin',
				type : 'get',
				success : function(msg) {
					if (msg == "ok") {
						alert("注销成功");
						window.location.href = url + "/login.jsp";
					}
				},
				error : function() {
					alert("无法注销");
				}
			});
		}
	});

	var navLi = $('.navs li')

	navLi.on('click', function() {

		$(this).find('ul').slideToggle();

	});

});


function result(){
    var count=0;
    var value="";
    var res="";
    var radio=$(".Option");
    var result=$(".result");
    for(var i=0;i<radio.length;i++){
    if(radio[i].checked==true){
    value=radio[i].value;
    var j=parseInt(i/5)
    res=result[j].value;
    if(value==res){
    count=count+20;
    }
    }
    }
     alert("分数："+count);
     window.location.reload();
}
