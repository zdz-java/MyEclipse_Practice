<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>试题管理页面</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	#manageSubject table  td{
		font-size:12px;
	}
	-->
	</style>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">管理试题</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="53%" valign="top">&nbsp;</td>
        </tr>
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="manageSubject" align="center"><!--管理试题-->
			<table width="95%" cellspacing="10">
				  <tr align="center">
					<td>试题编号</td>
					<td>试题标题</td>
					<td>正确答案</td>
					<td>查看试题</td>
					<td>更新试题</td>
					<td>删除试题</td>
				  </tr>
				  <c:forEach items="${pageResult.list}" var="subject">
				  	 <tr align="center">
							<td>${subject.subjectID}</td>
							<td align="left">${subject.subjectTitle}</td>
							<td>${subject.subjectAnswer}</td>
							<!-- 这三个超链接明天实现,暂留 -->
							<td><a href="subjectParticular?subjectID=${subject.subjectID}">查看</a></td>
							<td><a href="subjectUpadateBefore?subjectID=${subject.subjectID}">更新</a></td>
							<td><a href="subjectDelete?subjectID=${subject.subjectID}">删除</a></td>
					  </tr>
   				</c:forEach>
				  <tr>
				  	<td colspan="6" align="center">
				  		共${pageResult.page.totalCount}条纪录，当前第${pageResult.page.currentPage}/${pageResult.page.totalPage}页，每页${pageResult.page.everyPage}条纪录
				  	<c:choose>
				  	<c:when test="pageResult.page.hasNextPage">
                		<a href="subjectManage?currentPage=1">首页</a> | 
                		<a href="subjectManage?currentPage=${pageResult.page.currentPage + 1}">下一页</a> | 
               		</c:when>
					<c:otherwise>
               		首页 
					</c:otherwise>
               		</c:choose>
               		<!-- 因为是重复的，进行省略 -->
               	<%-- 	<s:if test="#request.page.hasNextPage">
                		<a href="subjectQuery.action?currentPage=${page.currentPage + 1}">下一页</a> | 
                		<a href="subjectQuery.action?currentPage=${page.totalPage}">尾页</a>
               		</s:if>
               		<s:else>
               		下一页 | 尾页
               		</s:else> --%>
               		
				  	</td>
				  </tr>	  
			</table>	
			</div>
		</td>
        </tr>
      
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>
