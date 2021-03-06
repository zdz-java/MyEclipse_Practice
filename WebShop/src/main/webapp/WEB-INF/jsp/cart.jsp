<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>购物车管理</title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/jquery-1.12.0.js"></script>
<script type="text/javascript" src="JS/jsonrpc.js"></script>
<script type="text/javascript" src="JS/cart.js"></script>
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
        <td height="60"><img src="images/Car_icon_04.gif" /></td>
      </tr>
      <tr>
        <td><table cellspacing="0" cellpadding="0" border="0">
            <tr valign="center">
              <td><img hspace="5" src="images/Car_07.gif" /></td>
              <td class="C_Carbg_Current">查看购物车</td>
              <td><img height="39" src="images/Car_15.gif" width="1" /></td>
              <td align="middle"><img hspace="5" src="images/Car_09.gif" /></td>
              <td class="C_Carbg_Default">检查订单</td>
              <td><img height="39" src="images/Car_15.gif" width="1" /></td>
              <td align="middle"><img hspace="5" src="images/Car_11.gif" /></td>
              <td class="C_Carbg_Default">提交订单</td>
              <td><img height="39" src="images/Car_15.gif" width="1" /></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">
			<table id="cartlist" cellspacing="1" cellpadding="0" width="94%" border="0" bgcolor="#F7F3F7">
              <tr height="26">
                <td class="blackTitle" align="center">商品名称</td>
                <td class="blackTitle" align="center">商品原价</td>
                <td class="blackTitle" align="center">售价</td>
                <td class="blackTitle" align="center">数量</td>
                <td class="blackTitle" align="center">总价</td>
                <td class="blackTitle" align="center">删除</td>
              </tr>
				<c:forEach items="${rows}" var="row">
				  <tr class="text" align="center" bgcolor="#FFFFFF">
					<td>
						&nbsp;<a href="showMer?id=${row.value.id}" target="_blank"> 
						  <span class="blueText">${row.value.merName}</span>
						</a>					</td>
					<td>￥${row.value.price}</td>
					<td>￥<span id="price${row.key.id}">${row.key.price}</span></td>
					<td><input type="text" class="textBox" onChange="changeNum(${row.key.id},this.value)" value="${row.key.number}" size="4"/></td>
					<td>￥<span id="money${row.key.id}">${row.key.money}</span></td>
					<td><input onClick="delCart(${row.key.id})" type="image" src="images/delete_01.gif" border="0"/></td>
				  </tr>
				  </c:forEach>
              <tr>
                <td colspan="6" class="Order_Total"><img hspace="5" src="images/me03.gif" align="absmiddle" /> 
				购物车总金额<span id="totalMoney">${totalMoney}</span><bean:message key="cart.memo"/>				</td>
              </tr>				
        </table></td>
      </tr>
	  <tr height="20"><td colspan="5"></td></tr>	  
      <tr align="right">
        <td>
			<input id="deleteButton" type="image" src="images/Car_icon_01.gif" style="BORDER: 0px;WIDTH: 126px; HEIGHT: 39px;">
			<a href="searchMer?cateid=0&key="><img style="CURSOR: hand" onClick="continueBuy()" src="images/Car_icon_02.gif" /></a>
			<a href="checkOrder"><img src="images/Car_icon_03.gif" onClick="next()" border="0" style="CURSOR: hand"/></a>
		</td>
      </tr>
      <tr align="right">
        <td height="20">&nbsp;</td>
      </tr>
    </table>	</td>
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
<!-- <script language="javascript">
	//构造商品分类下拉列表
	for (var i=0;i<result.length;i++){
		option =document.createElement("OPTION");
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
	
	//修改选购数量
	function modiNum(selid,newNum){
		if (jsonrpc.ajax.modiCart(selid,newNum)){
			var oldMoney = document.getElementById("money"+selid).innerText;
			var newMoney = newNum*document.getElementById("price"+selid).innerText;
			var diffMoney = newMoney - oldMoney;
			var newTotal = document.all.totalMoney.innerText*1+diffMoney;
			document.getElementById("money"+selid).innerText = Math.round(newMoney*100)/100;
			document.all.totalMoney.innerText = Math.round(newTotal*100)/100;
			alert("<bean:message key="cart.modi.suc"/>");
		}else{
			alert("<bean:message key="cart.modi.fail"/>");
		}
	}
	
	//删除选购记录
	function delCart(selid){
		var url = "cart.do?method=delCart&id="+selid;
		window.location = url;
	}
	
	//清空购物车
	function clearCart(){
		var url = "cart.do?method=clearCart";
		window.location = url;
	}
	
	//继续购物
	function continueBuy(){
		var url = "searchMer?cateid=0";
		window.location = url;
	}

	//进入下一步
	function next(){
		var url = "checkOrder";
		window.location = url;
	}		
</script> -->
</body>
</html>