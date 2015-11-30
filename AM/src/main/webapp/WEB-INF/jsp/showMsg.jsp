<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ�ճ��������ϵͳ-�鿴������Ϣ</title>
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/channel.css" type="text/css" rel="stylesheet"
	media="all" />
<script src="js/menu.js" type="text/javascript"></script>
<style type="text/css">
<!--
.STYLE2 {
	color: #CCCCCC;
	font-size: 14px;
}
-->
</style>
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
		��ǰλ�ã�[<a href="index">��ҳ</a>] - [��Ϣ�б�] - [�鿴������Ϣ]
	</div>
	<div id="channelcont">
		<div id="channelleft">
			<div class="channelinleft">
				<br />
				<h2 align="center">${message.messageTitle}</h2>
				<br /> ${message.messageContent}
				<div align="right">������ID��${message.employeeID}
					����ʱ�䣺${message.publishTime}</div>
				<!--����-->
				<div>
					<h5 style="color:red">�쵼����:${empty criticism ? "����":criticism.criticismContent}</h5>
				</div>
				<hr />
				<!--�ظ�-->
				<c:forEach items="${replyList}" var="reply">
					<div>
						${reply.replyContent}
						<div align="right">�ظ���ID��${reply.employeeID}
							�ظ�ʱ�䣺${reply.replyTime}</div>
						<hr />
					</div>
				</c:forEach>
				<div align="center">
					��
					<c:forEach varStatus="stat" begin="1" end="${page.totalPage}">
						<a
							href="GetMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a>
					</c:forEach>
					ҳ
				</div>
				<div>
					<div align="left">
						<p>�ظ�:</p>
						<p>
							<font color="red">${error }</font>
						</p>
						<sf:form action="CommitReply" method="post" commandName="reply">
							<sf:textarea path="replyContent" height="100" width="100%" />
							<sf:input type="hidden" path="messageID" value="${messageID}" />
							<sf:input type="hidden" path="employeeID" value="${employeeID}" />
							<input type="submit" value="�ύ" />
							<input type="reset" value="����" />
						</sf:form>
					</div>

					<c:if test="${sessionScope.employee.lead}">
						<div align="left">
							<p>����:</p>
							<p>
								<font color="red">${error }</font>
							</p>
							<sf:form action="CommitCriticism" method="post" commandName="criticismToAdd">
								<sf:textarea path="criticismContent" height="100" width="100%" />
								<sf:input type="hidden" path="messageID"
									value="${messageID}" />
								<input type="submit" value="�ύ" />
								<input type="reset" value="����" />
							</sf:form>
						</div>
					</c:if>
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


