<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String name = "";
String action = request.getParameter("action");
if(action!=null&&action.equalsIgnoreCase("post"))
{
	name = request.getParameter("name");
	String password = request.getParameter("password");
	if(name==null||!name.equalsIgnoreCase("admin"))
	{
%>
<Script Language="JavaScript">
alert("The Username is wrong");
</Script>
<%
	}
	else if(password==null||!password.equalsIgnoreCase("zdz"))
	{
	System.out.println("password wrong");
%>
<Script Language="JavaScript">
alert("The Password is wrong");
</Script>
<%	
	}
	else
	{
	System.out.println("login work");
%>
<Script Language="JavaScript">
alert("登录成功");
</Script>
<%
	session.setAttribute("adminLogined", "true");
	response.sendRedirect("backgroundAdmin");
	}
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0033)http://bm.e21cn.com/log/login.asp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META content="IE=7.0000" http-equiv="X-UA-Compatible">
<TITLE>用户登录</TITLE>
<META content=IE=EmulateIE7 http-equiv=X-UA-Compatible>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px
}

TD {
	FONT-SIZE: 12px
}

TH {
	FONT-SIZE: 12px
}

.STYLE1 {
	COLOR: #0000ff
}

.STYLE2 {
	FONT-WEIGHT: bold;
	COLOR: #999999
}

.STYLE3 {
	FONT-WEIGHT: bold;
	COLOR: #ff0000
}
</STYLE>

<SCRIPT type=text/javascript src="用户登录_files/jquery-1.9.1.min.js"></SCRIPT>

<SCRIPT type=text/javascript src="用户登录_files/reg.js"></SCRIPT>

<SCRIPT type=text/javascript charset=gb2312 src="用户登录_files/ChkUrl.js"></SCRIPT>

<META name=GENERATOR content="MSHTML 10.00.9200.16736">
</HEAD>
<BODY onload="document.getElementById('UserName').focus()">
	<BR>
	<BR>
	<TABLE cellSpacing=0 cellPadding=7 width="70%" align=center border=0>
		<TBODY>
			<TR>
				<TD bgColor=#cccccc width="50%"></TD>
				<TD bgColor=#cccccc><STRONG>管理员登录</STRONG></TD>
			</TR>
			<TR>
				<TD colSpan=2></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE id=ShowRInfo style="DISPLAY: none" cellSpacing=0 cellPadding=7
		width="70%" align=center border=0>
		<TBODY>
			<TR>
				<TD align=center><SPAN id=RInfo class=STYLE3></SPAN><BR>
				<BR></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=7 width="70%" align=center border=0>
		<FORM id=Form name=Form method="post">
			<TBODY>
				<TR>
					<TD rowSpan=4 width="50%">&nbsp;</TD>
					<TD>用户名： <INPUT id=UserName style="WIDTH: 40%" name=name value=<%=name %>>
						<SPAN id=SInfo0></SPAN></TD>
				</TR>
				<TR>
					<input type="hidden" name="action" value="post">
					<TD>密&nbsp; 码： <INPUT id=Password style="WIDTH: 40%"
						type=password name=password> <SPAN id=SInfo2></SPAN></TD>
				</TR>

				<TR>
					<TD align=center><BR>
					<a href="articleFlat" >返回</a>
						<INPUT 
						style="CURSOR: pointer; COLOR: #ffffff; BACKGROUND-COLOR: #ff6600"
						type="submit" value=登录 name=Submit> &nbsp; <BR>
					<BR>
						<HR> <BR></TD>
				</TR>
				
		</FORM>
		</TBODY>
	</TABLE>
	<BR>
	<BR>
	<HR>
</BODY>
</HTML>
