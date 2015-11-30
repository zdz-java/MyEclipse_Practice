<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>企业日常事务管理系统-发布新消息</title>
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/channel.css" type="text/css" rel="stylesheet"
	media="all" />
<script src="js/menu.js" type="text/javascript"></script>
</head>

<body>
	<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
	<div id="topmenu">
		<img src="images/banner.jpg" width="970" height="147" />
	</div>
	<div id="bookmunu">
		<div class="jsmenu" id="jsmenu"></div>
		<div>
			<ul>
				<li><a href="index">首页</a></li>
				<li><a href="GetMessageList">消息列表</a></li>
				<li><a href="publishNewMsg">发布新消息</a></li>
				<li><a href="statusRecognise">身份识别</a></li>
			</ul>
		</div>
	</div>
	<div id="conmenu"></div>
	<div id="place">
		当前位置：[<a href="index.jsp">首页</a>] - [发布新消息]
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
							消息标题： <sf:input type="text" path="messageTitle" size="50" />
						</p>
						<p>消息内容： <sf:textarea path="messageContent"/>
						</p>
						<p></p>
						<p align="center">
							<input type="submit" value="提交" /> <input type="reset"
								value="重置" />
						</p>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<div class="copyright">
		<ul>
			<li></li>
			<li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
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



