<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ�ճ��������ϵͳ-��������Ϣ</title>
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/channel.css" type="text/css" rel="stylesheet"
	media="all" />
<script src="js/menu.js" type="text/javascript"></script>
</head>

<body>
	<div id="topexplain">��ҵ�ճ��������ϵͳ��Ϊ��ҵ�ڲ�ͨ���ṩ����ķ���</div>
	<div id="topmenu">
		<img src="images/banner.jpg" width="970" height="147" />
	</div>
	<div id="bookmunu">
		<div class="jsmenu" id="jsmenu"></div>
		<div>
			<ul>
				<li><a href="index">��ҳ</a></li>
				<li><a href="GetMessageList">��Ϣ�б�</a></li>
				<li><a href="publishNewMsg">��������Ϣ</a></li>
				<li><a href="statusRecognise">���ʶ��</a></li>
			</ul>
		</div>
	</div>
	<div id="conmenu"></div>
	<div id="place">
		��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [��������Ϣ]
	</div>
	<div id="channelcont">
		<div id="channelleft">
			<div class="channelinleft">
				<div id="messageBox">
					<p>
						<font color="red">${error}</font>
					</p>
					<sf:form action="publishNewMsg" method="post" commandName="message">
						<p>
							��Ϣ���⣺ <sf:input type="text" path="messageTitle" size="50" />
						</p>
						<p>��Ϣ���ݣ� <sf:textarea path="messageContent"/>
						</p>
						<p></p>
						<p align="center">
							<input type="submit" value="�ύ" /> <input type="reset"
								value="����" />
						</p>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<div class="copyright">
		<ul>
			<li></li>
			<li>��ҵ�ճ��������ϵͳ &nbsp;&copy;2009-2010</li>
		</ul>
	</div>
	<div class="end"></div>
	<script type=text/javascript>
		startajaxtabs("jsmenu");

		var iTab = GetCookie("nets_jsmenu");
		iTab = iTab ? parseInt(iTab) : parseInt(Math.random() * 5);
		if (iTab != 0)
			getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
		iTab++;
		if (iTab > 4)
			iTab = 0;
		SetCookie("nets_jsmenu", iTab, 365);
		function getElement(aID) {
			return (document.getElementById) ? document.getElementById(aID)
					: document.all[aID];
		}
	</script>
</body>
</html>



