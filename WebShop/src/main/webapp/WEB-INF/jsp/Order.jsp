<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>查看订单</title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/jsonrpc.js"></script>
<script type="text/javascript" src="JS/jquery-1.12.0.js"></script>
<script type="text/javascript" src="JS/order.js"></script>
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
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="60"><img src="images/icon_order.gif" /></td>
					</tr>

					<tr>
						<td align="center">
							<table cellspacing="1" cellpadding="0" width="94%" border="0"
								bgcolor="#F7F3F7">
								<tr height="26">
									<td class="blackTitle" align="center">订单号</td>
									<td class="blackTitle" align="center">订单总价</td>
									<td class="blackTitle" align="center">订单日期</td>
									<td class="blackTitle" align="center">订单状态</td>
									<td class="blackTitle" align="center">订单操作</td>
								</tr>
								<c:forEach items="${orders}" var="order">
									<tr height="26" class="text" align="center" bgcolor="#FFFFFF">
										<td>${order.orderNo}</td>
										<td class="redText">￥${order.cart.money}</td>
										<td>
										<fmt:formatDate value="${order.orderDate}" type="both"/></td>
										<td><c:if test="${order.orderStatus==1}">
						已提交
					</c:if> <c:if test="${order.orderStatus==2}">
						已查阅
					</c:if> <c:if test="${order.orderStatus==3}">
						已完成
					</c:if></td>
										<td><a href="viewOrder?oid=${order.id}"><span
												class="blueText">查看订单详情</span></a>
											&nbsp; 
											<a onClick="deleteOrder(${order.id})">
												<span class="blueText">删除订单</span>
											</a></td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="5">&nbsp;</td>
								</tr>

							</table>
						</td>
					</tr>
					<tr height="20">
						<td colspan="5"></td>
					</tr>

					<tr align="right">
						<td height="20">&nbsp;</td>
					</tr>
				</table></td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td height="30" bgcolor="#4282CE" class="whiteText" align="center">
			</td>
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
		for (var i = 0; i < result.length; i++) {
			option = document.createElement("OPTION");
			option.value = result[i][0];
			option.text = result[i][1];
			document.all.category.options.add(option);
		}

		//搜索商品
		function QuickSearch(){
		var url = "searchMer?cateid="+document.all.category.value;
		var key = document.all.qKey.value;
		if (key !=null && key!="商品关键字" && key.length>0)url = url+"&key="+key;
		window.location = url;
	}
	</script>
</body>
</html>