<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>修改注册资料</title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/jsonrpc.js"></script>
<script type="text/javascript" src="JS/checkform.js"></script>
</head>
<body class="body">
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:1px; border-style:solid; border-color:#888888">
  <tr>
    <td width="20">&nbsp;</td>
    <TD height="50" align="right" valign="bottom">
		<IMG src="images/icon_login.gif" align=absMiddle> 
		<INPUT id="qKey" name="qKey" value="商品关键字" onClick="this.value=''"> 
		<SELECT id="category" name="category">
			<option value="0">所有商品</option>
		</SELECT>
		<A href="javascript:QuickSearch()"><IMG src="images/icon_search.gif" align="absMiddle" border="0"></A>
    </TD>
    <td width="20">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TR align="center">
          <TD valign="top" width="9"><IMG src="images/icon02.gif"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="default"><span class="whiteTitle">商城首页</span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="cart.do?method=browseCart"><span class="whiteTitle">购物车管理</span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="order.do?method=browseOrder"><span class="whiteTitle">订单管理</span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mem.do?method=browseWord"><span class="whiteTitle">顾客留言</span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="loadMember"><span class="whiteTitle">修改注册资料</span></A>
		  </TD>
          <TD vAlign=top width=7><IMG src="images/icon07.gif"></TD>
        </TR>
    </TABLE></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<sf:form action="modiReg" style="margin:0px;"
					onsubmit="return validateMemberForm(this);" commandName="memberToModi">
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#FFFFFF">
						<tr>
							<td height="80" colspan="2"><IMG
								src="images/EditUser_01.gif"></td>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">会员级别：</td>
							<%-- <td height="26"><sf:select path="memberlevel.id">
									<option value="1">普通会员</option>
									<option value="2">黄金会员</option>
									<option value="3">白金会员</option>
									<option value="4">钻石会员</option>
							</sf:select></td> --%>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">真实姓名：</td>
							<td height="26"><sf:input type="text" path="memberName"
								size="30" class="textBox"/></td>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">登录帐号：</td>
							<td height="26"><sf:input type="text" path="loginName"
								size="30" onblur="checkLoginName()" class="textBox"/></td>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">登录密码：</td>
							<td height="26"><sf:input type="password" path="loginPwd"
								size="30" value="" class="textBox"/></td>
						</tr>
						<%-- <tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">核对密码：</td>
							<td height="26"><sf:input type="password" path="reLoginPwd"
								size="30" class="textBox" onblur="checkPwd()" /></td>
						</tr> --%>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">联系电话：</td>
							<td height="26"><sf:input type="text" path="phone" size="30"
								value="" class="textBox"/></td>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">联系地址：</td>
							<td height="26"><sf:input type="text" path="address" size="30"
								value="" class="textBox"/></td>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">邮政编码：</td>
							<td height="26"><sf:input type="text" path="zip" size="30"
								value="" class="textBox"/></td>
						</tr>
						<tr bgcolor="#F7F3F7">
							<td width="260" height="26" class="text" align="right">电子邮箱：</td>
							<td height="26"><sf:input type="text" path="email" size="30"
								value="" class="textBox"/></td>
						</tr>
						<tr>
							<td height="40" colspan="2" align="center"><input
								type="submit" name="C_Input" value="注册" class="C_Input"><br>
								<span class="redText"></span></td>
						</tr>
					</table>

				</sf:form>
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30" bgcolor="#4282CE" class="whiteText" align="center">
		<bean:message key="website.foot"/>	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="20">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<script language="javascript">
	//构造商品分类下拉列表
	jsonrpc = new JSONRpcClient("JSON-RPC");
	var result = jsonrpc.ajax.getCategory();
	for (var i=0;i<result.length;i++){
		option =document.createElement("OPTION");
		option.value = result[i][0];
		option.text = result[i][1];
		document.all.category.options.add(option);
	}
	
	//密码核对
	function checkPwd(){
		if (document.all.loginPwd.value != document.all.reLoginPwd.value){
			alert('对不起，两次输入的密码不一致，请重新输入！');
			document.all.loginPwd.value = "";
			document.all.reLoginPwd.value ="";
			document.all.loginPwd.focus();
		}
	}
	
	//搜索商品
	function QuickSearch(){
		var url = "mer.do?method=searchMer&cateid="+document.all.category.value;
		var key = document.all.qKey.value;
		if (key !=null && key!="商品关键字" && key.length>0)url = url+"&key="+key;
		window.location = url;
	}
</script>
<logic:messagesPresent property="modiMemberStatus">
	<script language="javascript">
		alert('<html:errors property="modiMemberStatus"/>');
	</script>
</logic:messagesPresent>	
</body>
</html>