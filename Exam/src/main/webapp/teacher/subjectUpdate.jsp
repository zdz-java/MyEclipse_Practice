<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>试题更新页面</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	#updateSubjectForm table  td{
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
        <td height="31"><div class="titlebt">更新试题</div></td>
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
			<div id="updateSubjectForm" align="center"><!--更新试题表单-->
				<sf:form action="subjectUpdate" commandName="subjectToUpdate" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
					<tr>
						<td colspan="2"></td>
					</tr>
				  <tr>
					<td>试题题目:</td>
					<td>
						<sf:input path="subjectID" type="hidden"/>
						<sf:input path="subjectTitle" type="text" size="80"/>
					</td>
				  </tr>
				  <tr>
					<td>选项A:</td>
					<td><sf:input type="text" path="subjectOptionA" size="20"/></td>
				  </tr>
				   <tr>
					<td>选项B:</td>
					<td><sf:input type="text" path="subjectOptionB" size="20"/></td>
				  </tr>
				   <tr>
					<td>选项C:</td>
					<td><sf:input type="text" path="subjectOptionC" size="20"/></td>
				  </tr>
				   <tr>
					<td>选项D:</td>
					<td><sf:input type="text" path="subjectOptionD" size="20"/></td>
				  </tr>
				   <tr>
					<td>答案:</td>
					<td>
						<sf:input path="subjectAnswer" type="text"/>
						<%-- <sf:input path="subjectAnswer" type="radio" value="A" 
							${subject.subjectAnswer == "A" ? "checked " : ""}/>A
						<sf:input path="subjectAnswer" type="radio" value="B"
							${subject.subjectAnswer == "B" ? "checked " : ""}/>B
						<sf:input path="subjectAnswer" type="radio" value="C"
							${subject.subjectAnswer == "C" ? "checked " : ""}/>C
						<sf:input path="subjectAnswer" type="radio" value="D"
							${subject.subjectAnswer == "D" ? "checked " : ""}/>D --%>
					</td>
				  </tr>
				  <tr>
					<td valign="top">答案解析:</td>
					<td>
						<sf:textarea path="subjectParse" cols="76" rows="10"/>
					</td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="录入">				  	  
				  	  <input type="reset" value="重置">
			  	  </div>
				</td>
				  </tr>
			</table>
			</sf:form>	
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
