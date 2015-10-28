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

<title>My JSP 'workInfo.jsp' starting page</title>

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
		所在城市：<select name="workInfo.city">
			<c:forEach items="${cityList }" var="city">
				<option value="${city }"
					<c:if test="${user.workInfo.city eq city}">selected="selected"</c:if>>
					${city}</option>
			</c:forEach>
		</select><br /> 职位：<input type="text" name="workInfo.job"
			value="${user.workInfo.job}" /><br /> 工作年限：<input type="text"
			name="workInfo.year" value="${user.workInfo.year}" /><br /> <input
			type="submit" name="_target1" value="上一步" /> <input type="submit"
			name="_finish" value="完成" /> <input type="submit" name="_cancel"
			value="取消" />
	</form>
</body>
</html>
