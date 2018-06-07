<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
<html>
<head>
<title>注册新用户</title>
<script type="text/javascript">
	function check(form) {
		if (form.name.value == "") {
			alert("用户名不能为空");
			return false;
		}
		if (form.password1.value == "") {
			alert("密码不能为空");
			return false;
		}
		if (form.password2.value == "") {
			alert("确认密码不能为空");
			return false;
		}
		if (form.password1.value != form.password2.value) {
			alert("两次输入密码不一致");
		return false;
		}
		if (form.password1.value == form.password2.value) {
			alert("注册成功");
		return false;
		}
		return true;
	}
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #66FFCC;
	font-weight: bold;
	font-size: 36px;
	font-family: "楷体_GB2312";
}
.STYLE2 {
	font-family: "Courier New", Courier, monospace;
	font-size: 16px;
	font-weight: bold;
	color: #FFCCFF;
}
-->
</style>
</head>
<body>
	<p align="center" class="STYLE1">网上购物</p>
	<p align="center" class="STYLE2">注册页面</p>
	<%
		if (request.getAttribute("error") != null) {
	%>
	<center>
		<h3>
			<font color="red"><%=request.getAttribute("error")%></font>
		</h3>
	</center>
	<%
		}
	%>
	<form id="form1" name="form1" method="post" onsubmit=" return check(this)" action="RegistServlet">
		<table width="337" height="124" border="1" align="center">
			<tr>
				<td width="77">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
				<td width="107"><label> <input name="name" type="text"
						id="name" size="20" maxlength="20" />
				</label></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><label> <input name="password1" type="password"
						id="password1" size="20" maxlength="20" />
				</label></td>
			</tr>
			<tr>
				<td>重复密码：</td>
				<td><label> <input name="password2" type="password"
						id="password2" size="20" maxlength="20" />
				</label></td>
			</tr>
			<tr>
				<td>
				<label>  <input type="reset" name="register" id="register" value="登录"
				onclick="javascript:document.location.href='index.jsp';">
				</label></td>
				<td><label> <input type="submit" name="reset" id="reset"
						value="注册" />
				</label></td>
			</tr>
		</table>
	</form>
</body>
</html>