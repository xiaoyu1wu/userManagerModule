<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>���������û�</title>
		<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F0F4FF;
}
.STYLE1 {
	color: #FFFFFF;
	font-size: 9pt;
}
</style>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	</head>
	<body>
		<table background="images/23_03.gif" width="755px" height="27px"
			border="0" align="left" cellpadding="0" cellspacing="0">
			<tr>
				<td width="20px">&nbsp;</td>
				<td>
					<span class="STYLE1">��ǰλ��-&gt;�û�������ҳ</span>
				</td>
			</tr>
		</table>
		<br>
		<br>
		<table width="755px" height="48">
			<tr>
				<td align="center">
					<a href="userOperation.html?method=findById">�������û�</a>
				</td>
			</tr>
		</table>

		<table width="730" border="0" cellspacing="1" bgcolor="#999999">
			<c:forEach items="${list}" var="item" varStatus="i">
				<tr>
					<td width="128" height="128" rowspan="5" align="center"
						valign="middle" bgcolor="#F0F4FF">
						<img src="face/${item[0].face}">
					</td>
					<td height="23" colspan="3" align="right" bgcolor="#F0F4FF">
						<a href="userOperation.html?method=findById&number=${item[0].number}">�޸�</a>
						&nbsp;&nbsp;
						<a href="userOperation.html?method=deleteUser&number=${item[0].number}">ɾ��</a>
						&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td height="23" bgcolor="#F0F4FF">
						�û���ţ�
						<c:out value="${item[0].number}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						��¼�˺ţ�
						<c:out value="${item[0].id}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						��¼���룺
						<c:out value="${item[0].pwd}" />
					</td>
				</tr>
				<tr>
					<td height="23" bgcolor="#F0F4FF">
						�û�������
						<c:out value="${item[0].name}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						�û��Ա�
						<c:out value="${item[0].sex}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						�������ڣ�
						<c:out value="${item[0].birthday}" />
					</td>
				</tr>
				<tr>
					<td height="23" bgcolor="#F0F4FF">
						��ְ���ڣ�
						<c:out value="${item[0].come}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						�������ţ�
						<c:out value="${item[1].name}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="23" colspan="3" bgcolor="#F0F4FF">
						���˽��ܣ�
						<c:out value="${item[0].remark}" />
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>