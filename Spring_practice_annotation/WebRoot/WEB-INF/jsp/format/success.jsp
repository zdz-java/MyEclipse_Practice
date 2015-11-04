<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>

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
	totalCount:
	<spring:bind path="modeltt.totalCount">${status.value}</spring:bind>
	<br /> discount:
	<spring:bind path="modeltt.discount">${status.value}</spring:bind>
	<br /> sumMoney:
	<spring:bind path="modeltt.sumMoney">${status.value}</spring:bind>
	<br /> phoneNumber:
	<spring:bind path="modeltt.phoneNumber">${status.value}</spring:bind>
	<br />
	<!-- 如果没有配置org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor将会报错 -->
	phoneNumber:
	<spring:eval expression="modeltt.phoneNumber"></spring:eval>
	<br />

	<br />
	<br />
	<form:form commandName="modeltt">
		<form:input path="phoneNumber" />
		<br />
		<form:input path="sumMoney" />
	</form:form>
</body>
</html>
