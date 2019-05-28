$(function() {
	var flagid = false;
	var flagpwd = false;
	var flagpwds = false;
	var flagtel = false;
	checkId();
	checkPwd();
	checkPwds();
	checkTel();
	$("#register").click(function() {
		if (flagid && flagpwd && flagpwds && flagtel) {
			reguser();
		}
	});

	function checkId() {
		$("#User_ID").change(function() {
			var s = $(this).val();
			if (s == "") {
				$(".spanid").text("账号不能为空");
				flagid = false;
			} else if (s.length < 6) {
				$(".spanid").text("账号不能少于6位");
				flagid = false;
			} else if (s.length > 16) {
				$(".spanid").text("注册账号不能超过16位");
				flagid = false;
			} else {
				$.post("/checkId", {
					"id" : s
				}, function(msg) {
					if (msg == "ok") {
						$(".spanid").text("");
						flagid = true;
					} else {
						$(".spanid").text("该账号已存在，重新输入");
						flagid = false;
					}
					;
				});
			}
			;
		});
	}

	// 注册密码检查
	function checkPwd() {
		$("#Pwd").change(function() {
			var Pwd = $("#Pwd").val();
			var Pwds = $("#Pwds").val();
			if (Pwds == Pwd) {
				$(".spanpwds").text("");
			}
			if (Pwd == "") {
				$(".spanpwd").text("密码不能为空");
				flagpwd = false;
			} else if (Pwd.length < 6) {
				$(".spanpwd").text("密码不能少于6位");
				flagpwd = false;
			} else if (Pwd.length > 16) {
				$(".spanpwd").text("密码不能超过16位");
				flagpwd = false;
			} else {
				$(".spanpwd").text("");
				flagpwd = true;
			}
			;
		});
	}

	// 注册确认密码检查
	function checkPwds() {
		$("#Pwds").change(function() {
			var Pwd = $("#Pwd").val();
			var Pwds = $("#Pwds").val();
			if (Pwd != Pwds) {
				$(".spanpwds").text("两次密码不一致");
				flagpwds = false;
			} else {
				$(".spanpwds").text("");
				flagpwds = true;
			}
		});
	}

	// 注册手机号检查
	function checkTel() {
		$("#Tel").change(function() {
			var tel = $(this).val();
			telOne = tel.substr(0, 1);
			if (telOne != 1) {
				$(".spantel").text("手机号格式错误");
				flagtel = false;
			} else if (tel.length == 11) {
				$(".spantel").text("");
				flagtel = true;
			} else {
				$(".spantel").text("手机号格式错误");
				flagtel = false;
			}
		});
	}

	function reguser() {
		$.post( "/regUser", $("#regform").serialize(), function(msg) {
			if (msg == "ok") {
				alert("注册成功！");
				window.location.reload();
			} else {
				alert("注册失败！");
				window.location.reload();
			}
		});
	}
	;
});
