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
.STYLE2 {font-size: 9pt}
.STYLE4 {font-size: 9pt; color: #FFFFFF; }
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
		if (document.f1.file.value == "" || document.f1.file.value == null) {
			alert("�û�ͷ����Ϊ��");
			document.f1.file.focus();
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
					<span class="STYLE4">��ǰλ��-&gt;�������û�</span>				</td>
			</tr>
		</table>
		<br><br>
		<form name="f1" action="userOperation.html?method=insertUser"
			method="post" enctype="multipart/form-data" onSubmit="return check()">
			<table style="position:relative;top:20px;left:70px;" width="540px" border="0" cellspacing="1" bgcolor="#999999">
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  ��¼�ʺţ�					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="id" id="id">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  6-10λӢ����ĸ������					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  ��¼���룺					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="pwd" id="pwd">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  6-10λӢ����ĸ������					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  �û�������					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="name" id="name">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  10λ��������					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  �û��Ա�					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">
						<input type="radio" value="��" name="sex">
						��
						<input type="radio" value="Ů" name="sex">
				  Ů		          </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  ѡ���û��Ա�					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  �������ڣ�					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="birthday">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  ��ʽ��YYYY-MM-DD					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  ��ְ���ڣ�					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="come">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  ��ʽ��YYYY-MM-DD					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  �������ţ�					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<select name="dept">
						  <option value="0">
						    ѡ����...					      </option>
						  <c:forEach items="${map}" var="item" varStatus="i">
						    <option value="${item.number}">
						      ${item.name}					        </option>
					      </c:forEach>
					    </select>
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  ѡ�����ڲ���					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  �û���Ƭ��					</span></div></td>
					<td colspan="2" bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="file" name="file" onChange="testFileType(this)">
				        </span></td>
				</tr>
				<tr>
					<td bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  ���˼�飺					</span></div></td>
					<td colspan="2" bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<textarea name="remark" cols="40" rows="5" id="remark"></textarea>
				        </span></td>
				</tr>
				<tr>
					<td height="32" colspan="3" align="center" bgcolor="#F0F4FF">
						<span class="STYLE2">
                        <input type="submit" value="ȷ��">
&nbsp;&nbsp;
						<input type="reset" value="����">
		          </span></td>
				</tr>
		  </table>
		</form>
	</body>
</html>
