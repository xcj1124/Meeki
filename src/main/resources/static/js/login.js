$(function() {
	// 检查用户登陆信息
	var idBo = true;
	var pwdBo = true;
	$("#User_ID").change(checkId);
	$("#Pwd").change(checkPwd);
	$("#userSubmit").click(function() {
		checkId();
		checkPwd();
		if (idBo && pwdBo) {
			login();
		}
	});
	function checkId() { // 账号文本框判断
		var User_ID = $("#User_ID").val();
		$("#sp1").text("");
		if (User_ID == "") {
			$("#idMsg").text("账号不能为空");
			idBo = false;
		} else if (User_ID.length < 6) {
			$("#idMsg").text("账号不能少于6位");
			idBo = false;
		} else if (User_ID.length > 16) {
			$("#idMsg").text("账号过长");
			idBo = false;
		} else {
			$("#idMsg").text("");
			idBo = true;
		}
	}

	function checkPwd() { // 密码文本框判断
		var Pwd = $("#Pwd").val();
		$("#sp1").text("");
		if (Pwd.length == 0) {
			$("#pwdMsg").text("密码不能为空");
			pwdBo = false;
		} else if (Pwd.length < 6) {
			$("#pwdMsg").text("密码不能少于6位");
			pwdBo = false;

		} else if (Pwd.length > 16) {
			$("#pwdMsg").text("密码过长");
			pwdBo = false;
		} else {
			$("#pwdMsg").text("");
			pwdBo = true;
		}
	}

	function login() {
		$.post("/login", $("#loginForm").serialize(), function(msg) {
			if (msg == "ok") {
			window.location.href ="/index.html";
			} else if (msg == "no") {
				$("#sp1").text("账号密码错误");
			}
		});
	}
});
