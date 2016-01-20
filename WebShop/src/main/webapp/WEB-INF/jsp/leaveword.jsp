<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>用户留言</title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/jsonrpc.js"></script>
</head>
<body class="body">
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:1px; border-style:solid; border-color:#888888">
  <tr>
    <td width="20">&nbsp;</td>
    <TD height="50" align="right" valign="bottom">
		<IMG src="images/icon_login.gif" align="absmiddle"> 
		<INPUT id="qKey" name="qKey" value="商品关键字" onClick="this.value=''"> 
        <select id="category">
       	<option value="0">所有商品</option>
		  <c:forEach items="${cateList}" var="cate">
		  		<option value="${cate.id}">${cate.cateName}</option>
		  </c:forEach>
        </select>		
		<A href="javascript:QuickSearch()"><IMG src="images/icon_search.gif" align="absmiddle" border="0"></A>    	
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
		  	<A href="cartManage"><span class="whiteTitle">购物车管理</span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="browseOrder"><span class="whiteTitle">订单管理</span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="leaveword"><span class="whiteTitle">顾客留言</span></A>
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
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
          <tr>
            <td height="40"><img src="images/icon_liuyan.gif" /></td>
          </tr>
          <tr>
            <td height="26" align="center">
			  <c:forEach items="${words}" var="word">
				<table width="90%" border="0" cellpadding="4" cellspacing="0" style="border:1px; border-color:black; border-style:solid;">
				  <tr bgcolor="#F7F3F7">
					<td class="text"><span class="blackTitle">标题</span>：${word.title}</td>
					<td align="right" class="text">
						<span class="blackTitle">
						用户</span>：${word.member.memberName}&nbsp;
						<span class="blackTitle">评论时间</span>：${word.leaveDate}</td>
				  </tr>
				  <tr>
					<td class="text" colspan="2">${word.content}</td>
				  </tr>
				  <tr>
					<td colspan="2" bgcolor="#F7F3F7" class="blackTitle">答复内容：</td>
				  </tr>
				  <tr>
					<td class="text" colspan="2">${word.answerContent}</td>
				  </tr>
				</table>
				<table cellpadding="0" cellspacing="0"><tr height="10"><td></td></tr></table>
				</c:forEach>
		</td>
          </tr>
          <tr bgcolor="#F7F3F7">
            <td height="26" bgcolor="#FFFFFF">
			<form name="form1" action="addWord" method="post" style="margin:0px;">
			   <table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td colspan="2"><img src="images/icon_LeaveWord.gif" width="140" height="45" /></td>
                  </tr>
                  <tr>
                    <td colspan="2">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right" class="blackTitle">评论标题：</td>
                    <td height="30"><input type="text" id="wordTitle" name="wordTitle" class="textBox" size="61"/></td>
                  </tr>
                  <tr>
                    <td align="right" class="blackTitle">评论内容：</td>
                    <td><textarea id="content" name="content" rows="4" cols="60" class="textBox"></textarea></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td height="35"><input type="button" class="C_Input" onClick="checkForm()" value="提交留言"/></td>
                  </tr>
            </table>
			</form>
			</td>
          </tr>
        </table></td>
      </tr>
	  <tr height="20"><td colspan="5"></td></tr>      
      <tr align="right">
        <td height="20">&nbsp;</td>
      </tr>
    </table>
	</td>
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
	
	//是否输入数字
	function isNumber(){
		return ((event.keyCode>47)&&(event.keyCode<58));
	}
	
	//响应“GO”按钮
	
	//搜索商品
	function QuickSearch(){
		var url = "searchMer?cateid="+document.all.category.value;
		var key = document.all.qKey.value;
		if (key !=null && key!="商品关键字" && key.length>0)url = url+"&key="+key;
		window.location = url;
	}
	
	//检测留言表单
	function checkForm(){
		if (document.all.wordTitle.value==''){
			alert("对不起，留言标题不能为空！");
		}else if (document.all.content.value==''){
			alert("对不起，留言内容不能为空！");
		}else{
			document.all.form1.submit();
		}
	}
</script>
<logic:messagesPresent property="addWordStatus">
	<script language="javascript">
		alert('<html:errors property="addWordStatus"/>');
	</script>
</logic:messagesPresent>
</body>
</html>