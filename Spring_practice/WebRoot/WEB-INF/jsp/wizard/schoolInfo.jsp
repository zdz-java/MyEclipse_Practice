<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'schoolInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form method="post">
		学校类型：<select name="schoolInfo.schoolType">
			<c:forEach items="${schoolTypeList }" var="schoolType">
				<option value="${schoolType }"
					<c:if test="${user.schoolInfo.schoolType eq schoolType}">  
           selected="selected"  
       </c:if>>
					${schoolType}</option>
			</c:forEach>
		</select><br /> 学校名称：<input type="text" name="schoolInfo.schoolName"
			value="${user.schoolInfo.schoolName}" /><br /> 专业：<input type="text"
			name="schoolInfo.specialty" value="${user.schoolInfo.specialty}" /><br />
		<input type="submit" name="_target0" value="上一步" /> <input
			type="submit" name="_target2" value="下一步" />
	</form>
</body>
</html>
