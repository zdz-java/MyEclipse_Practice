<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
    <a href="${pageContext.request.contextPath}/user/create">用户新增</a><br/>  
<table border="1" width="50%">  
   <tr>  
      <th>用户名</th>  
      <th>真实姓名</th>  
      <th>操作</th>  
   </tr>   
   <c:forEach items="${userList}" var="user">  
   <tr>  
      <td>${user.username }</td>  
      <td>${user.realname }</td>  
      <td>  
          <a href="${pageContext.request.contextPath}/user/update?username=${user.username}">更新</a>  
          |  
          <a href="${pageContext.request.contextPath}/user/delete?username=${user.username}">删除</a>  
      </td>  
   </tr>  
   </c:forEach>     
</table>  
  </body>
</html>
