<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>商品详情</title>
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
        <td valign="top"><br>
		<TABLE width="96%" border=0 align="center" cellPadding=0 cellSpacing=0 class="C_Goods_Title">			
			<TR>
			  <TD><IMG hspace=5 src="images/NewGoods_05.gif"></TD>
			  </TR>
          </TABLE>
          <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#F7F3F7">
            <tr bgcolor="#F7F3F7" valign="middle" align="center">
              <td height="30" class="blackTitle"><bean:message key="mer.picture"/></td>
              <td height="30" class="blackTitle"><bean:message key="mer.base.info"/></td>
              <td height="30" class="blackTitle"><bean:message key="mer.desc"/></td>
              <td height="30" class="blackTitle"><bean:message key="mer.base.option"/></td>
            </tr>
			<logic:notPresent name="smerList">
				<tr>
				  <td colspan="4" height="26" class="redText">&nbsp;<bean:message key="mer.notExist"/></td>
				</tr>
			</logic:notPresent>
			<logic:present name="smerList">
				<logic:iterate id="mer" name="smerList" type="com.ORM.Merchandise">
					<tr valign="middle" bgcolor="#FFFFFF">
					  <td width="100" align="center" >
						<a href="mer.do?method=showMer&id=${mer.id}" target=_blank> <img src=".${mer.picture}" width="60" height="60" border="1"> </a>
					  </td>
					  <td width="160" class="text">
						  <a href="mer.do?method=showMer&id=${mer.id}" target=_blank><span  class="blueText">${mer.merName}</span></a><br>
						  <bean:message key="mer.price"/>： ￥${mer.price}<br>
						  <bean:message key="mer.sprice"/>： ￥${mer.sprice}<br>
						  <bean:message key="mer.manufacturer"/>：${mer.manufacturer}<br>
					  </td>
					  <td class="text">${mer.merDesc}</td>
					  <td width="100">
						<a href="mer.do?method=showMer&id=${mer.id}"><img src="images/icon_car.gif" border=0></a><br>
						<a href="cart.do?method=addCart&id=${mer.id}"><img alt="" src="images/icon_buy.gif" border=0></a>
					  </td>
					</tr>
					<tr>
					  <td colspan="4" height="2" bgcolor="#F7F3F7"></td>
					</tr>				
				</logic:iterate>
			</logic:present>
            <tr>
              <td colspan="4" height="30" bgcolor="#F7F3F7" class="text" align="center">
				<a href="<%=action%>pageNo=1" class="blueText"><span class="blueText">首页</span></a>&nbsp;
				<%if (preOk==1){%>
					<a href="<%=action%>pageNo=<%=prePageNo%>" class="blueText"><span class="blueText">上一页</span></a>&nbsp;
				<%}else{%>
					<span class="grayText">上一页</span>&nbsp;
				<%}%>
				<%if (nextOk==1){%>
					<a href="<%=action%>pageNo=<%=nextPageNo%>" class="blueText"><span class="blueText">下一页</span></a>&nbsp;
				<%}else{%>
					<span class="grayText">下一页</span>&nbsp;
				<%}%>
					<a href="<%=action%>pageNo=<%=totalPages%>" class="blueText"><span class="blueText">末页</span></a>　
				去第<input type="text" id="willGoPage" name="willGoPage" class="control" size="2" onKeyPress="return isNumber()">
				页<input type="button" class="button" id="go" value="GO" name="go" onClick="goPage()">   　
				第<span class="redText"><%=pageNo%></span>页/共<span class="redText"><%=totalPages%></span>页　
			总数<span class="redText"><%=totals%></span>			  
			  </td>
            </tr>
          </table></td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30" bgcolor="#4282CE" class="whiteText" align="center">
		<bean:message key="website.foot"/>	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="20" colspan="3">&nbsp;</td>
  </tr>
</table>
<script type="text/javascript">
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
	function goPage(goPageNo){
		var maxPageNo = <%=totalPages%>;
		var goPageNo = document.all.willGoPage.value;
		var url = "<%=action%>pageNo="+goPageNo;
		if (goPageNo<1 || goPageNo>maxPageNo || goPageNo==''){
			alert("对不起，您输入的页号无效，请您核对后重新输入！");
			return ;
		}else
		{
			window.location = url;
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
</body>
</html>