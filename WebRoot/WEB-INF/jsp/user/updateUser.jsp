<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>'insertUser.jsp'</title>
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
		<script type="text/javascript">
	function testFileType(file) {
		var fileName = file.value.substr(file.value.lastIndexOf("."))
				.toUpperCase();
		if (fileName != ".JPG" && fileName != ".BMP" && fileName != ".GIF") {
			alert("�ϴ���ͼƬֻ֧��BMP,JPG,GIF��ʽ");
			file.outerHTML = file.outerHTML;
		}
	}
	function check() {
		if (document.f1.id.value == "" || document.f1.id.value == null) {
			alert("��¼�ʺŲ���Ϊ��");
			document.f1.id.focus();
			return false;
		}
		if (document.f1.pwd.value == "" || document.f1.pwd.value == null) {
			alert("��¼���벻��Ϊ��");
			document.f1.pwd.focus();
			return false;
		}
		if (document.f1.name.value == "" || document.f1.name.value == null) {
			alert("�û���������Ϊ��");
			document.f1.name.focus();
			return false;
		}
		if (!document.f1.sex[0].checked && !document.f1.sex[1].checked) {
			alert("�û��Ա���Ϊ��");
			return false;
		}
		if (document.f1.birthday.value == ""
				|| document.f1.birthday.value == null) {
			alert("�������ڲ���Ϊ��");
			document.f1.birthday.focus();
			return false;
		}
		if (document.f1.come.value == "" || document.f1.come.value == null) {
			alert("��ְ���ڲ���Ϊ��");
			document.f1.come.focus();
			return false;
		}
		if (document.f1.dept.value == "0") {
			alert("��ѡ����������");
			document.f1.dept.focus();
			return false;
		}
		if (document.f1.remark.value == "" || document.f1.remark.value == null) {
			alert("�û���鲻��Ϊ��");
			document.f1.remark.focus();
			return false;
		}
		return true;
	}
</script>
	</head>

	<body>
	<table background="images/23_03.gif" width="755px" height="27px"
			border="0" align="left" cellpadding="0" cellspacing="0">
			<tr>
				<td width="20px">&nbsp;
					
			  </td>
				<td>
					<span class="STYLE4 STYLE1">��ǰλ��-&gt;�޸��û���Ϣ</span>				</td>
			</tr>
		</table>
		<br><br>
		<form name="f1" action="userOperation.html?method=updateUser"
			method="post" enctype="multipart/form-data" onSubmit="return check()">
			<table width="540px" cellspacing="1" bgcolor="#999999" style="position:relative; top:20px; left:40px">
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">��¼�ʺţ�					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
						<input type="text" name="id" id="id" value="${map.user.id}"
							readonly="readonly">
						<input type="hidden" name="number" value="${map.user.number}">
				  <input type="hidden" name="face" value="${map.user.face}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						��������޸�					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">��¼���룺					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="pwd" id="pwd" value="${map.user.pwd}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						6-10λӢ����ĸ������					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">�û�������					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="name" id="name" value="${map.user.name}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						10λ��������					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">�û��Ա�					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						<input type="radio" value="��" name="sex">
						��
						<input type="radio" value="Ů" name="sex">
						Ů
				  <script type="text/javascript">
	if ("��" == "${map.user.sex}") {
		document.f1.sex[0].checked = 'checked';
	} else {
		document.f1.sex[1].checked = 'checked';
	}
</script>					</td>
					<td height="32" bgcolor="#F0F4FF">
						ѡ���û��Ա�					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">�������ڣ�					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="birthday" value="${map.user.birthday}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						��ʽ��YYYY-MM-DD					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">��ְ���ڣ�					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="come" value="${map.user.come}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						��ʽ��YYYY-MM-DD					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">�������ţ�					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
						<select name="dept">
							<option value="0">
								ѡ����...							</option>
							<c:forEach items="${map.list}" var="item" varStatus="i">
								<option value="${item.number}">
									${item.name}								</option>
							</c:forEach>
						</select>
				  <script type="text/javascript">
	document.f1.dept.value = "${map.user.dept}";
</script>					</td>
					<td height="32" bgcolor="#F0F4FF">
						ѡ�����ڲ���					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">�û���Ƭ��					</div></td>
					<td height="32" colspan="2" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="file" name="file" onChange="testFileType(this)"
							value="${map.user.face}">					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">���˼�飺</div></td>
					<td height="32" colspan="2" bgcolor="#F0F4FF">&nbsp;
				  <textarea name="remark" cols="40" rows="5" id="remark">${map.user.remark}</textarea>					</td>
				</tr>
				<tr>
					<td height="32" colspan="3" align="center" bgcolor="#F0F4FF">
						<input type="submit" value="ȷ��">&nbsp;&nbsp;
				  		<input type="reset" value="����">
				    </td>
				</tr>
		  </table>
		</form>
	</body>
</html>
