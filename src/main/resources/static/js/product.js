function addGoods() {
	var Good_name = $("#Good_name1").val().length;
	var Good_num = $("#Good_num1").val().length;
	var Good_price = $("#Good_price1").val().length;
	var Good_type = $("#Good_type1").val().length;
	if (0 != Good_name && 0 != Good_num && 0 != Good_price && 0 != Good_type) {
		$.post(url + "/addGoods", $("#update_customer_form").serialize(),
				function(msg) {
					if (msg == "ok") {
						alert("添加成功");
						window.location.reload();
					} else {
						window.location.reload();
					}
				});
	} else {
		alert("字段不能为空");
	}

}

// 修改商品名字
function alterGoodName(id) {
	$(".gname").dblclick(function() {
		var tt = $(this); // 获得备注表格对象
		var text = tt.text(); // 获取备注表格文本内容
		var inputIns = $("<input type='text'/>"); // 设置文本框
		inputIns.width(tt.width); // 设置文本框的宽度
		inputIns.attr("value", text); // 设置文本框默认值
		tt.text(""); // 表格文本清空
		tt.append(inputIns); // 添加文本框
		inputIns.focus(); // 文本框获得焦点
		inputIns.blur(function() {
			var newText = inputIns.val();
			$.ajax({
				type : "post",
				url : url + "/alterGoodName",
				data : {
					"id" : id,
					"Good_name" : newText,
				},
				success : function(msg) {
					if ("ok" == msg) {
						window.location.reload();
					} else {
						alert("修改失败");
						window.location.reload();
					}
				}
			});
		});
	});
}

// 修改商品库存
function altergetGoodNum(id) {
	$(".gnum").dblclick(function() {
		var tt = $(this); // 获得备注表格对象
		var text = tt.text(); // 获取备注表格文本内容
		var inputIns = $("<input type='text'/>"); // 设置文本框
		inputIns.width(tt.width); // 设置文本框的宽度
		inputIns.attr("value", text); // 设置文本框默认值
		tt.text(""); // 表格文本清空
		tt.append(inputIns); // 添加文本框
		inputIns.focus(); // 文本框获得焦点
		inputIns.blur(function() {
			var newText = inputIns.val();
			$.ajax({
				type : "post",
				url : url + "/alterGoodNum",
				data : {
					"id" : id,
					"Good_num" : newText,
				},
				success : function(msg) {
					if ("ok" == msg) {
						window.location.reload();
					} else {
						alert("修改失败");
						window.location.reload();
					}
				}
			});
		});
	});
}

// 修改商品价格
function altergetGoodPrice(id) {
	$(".gprice").dblclick(function() {
		var tt = $(this); // 获得备注表格对象
		var text = tt.text(); // 获取备注表格文本内容
		var inputIns = $("<input type='text'/>"); // 设置文本框
		inputIns.width(tt.width); // 设置文本框的宽度
		inputIns.attr("value", text); // 设置文本框默认值
		tt.text(""); // 表格文本清空
		tt.append(inputIns); // 添加文本框
		inputIns.focus(); // 文本框获得焦点
		inputIns.blur(function() {
			var newText = inputIns.val();
			$.ajax({
				type : "post",
				url : url + "/alterGoodPrice",
				data : {
					"id" : id,
					"Good_price" : newText,
				},
				success : function(msg) {
					if ("ok" == msg) {
						window.location.reload();
					} else {
						alert("修改失败");
						window.location.reload();
					}
				}
			});
		});
	});
}

// 修改商品类型
function altergetGoodType(id) {
	$(".gtype").dblclick(function() {
		var tt = $(this); // 获得备注表格对象
		var text = tt.text(); // 获取备注表格文本内容
		var inputIns = $("<input type='text'/>"); // 设置文本框
		inputIns.width(tt.width); // 设置文本框的宽度
		inputIns.attr("value", text); // 设置文本框默认值
		tt.text(""); // 表格文本清空
		tt.append(inputIns); // 添加文本框
		inputIns.focus(); // 文本框获得焦点
		inputIns.blur(function() {
			var newText = inputIns.val();
			$.ajax({
				type : "post",
				url : url + "/alterGoodType",
				data : {
					"id" : id,
					"Good_type" : newText,
				},
				success : function(msg) {
					if ("ok" == msg) {
						window.location.reload();
					} else {
						alert("修改失败");
						window.location.reload();
					}
				}
			});
		});
	});
}

function deleteGoods(id) {
	if (confirm("确认删除吗？")) {
		$.ajax({
			url : url + "/deleteGoods",
			type : "post",
			data : {
				"id" : id
			},
			success : function(msg) {
				if ("ok" == msg) {
					alert("删除成功");
					window.location.reload();
				} else {
					alert("删除失败");
					window.location.reload();
				}
			}

		});
	}
}