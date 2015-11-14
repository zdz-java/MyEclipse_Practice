<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>

<title>Java|Java世界_中文论坛|ChinaJavaWorld技术论坛 : Java语言*初级版</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">

<!-- this is the ckeditor coding -->
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="script/regcheckdata.js" >
</script>
<link rel="stylesheet" type="text/css" href="images/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS" href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript" src="images/common.js"></script>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="140"><a href="http://bbs.chinajavaworld.com/index.jspa"><img src="images/header-left.gif" alt="Java|Java世界_中文论坛|ChinaJavaWorld技术论坛" border="0"></a></td>
      <td><img src="images/header-stretch.gif" alt="" border="0" height="57" width="100%"></td>
      <td width="1%"><img src="images/header-right.gif" alt="" border="0"></td>
    </tr>
  </tbody>
</table>
<br>
<div id="jive-forumpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="98%"><p class="jive-breadcrumbs">论坛: Java语言web开发练习</p>
          <p class="jive-description"> 这个是个打酱油的简易论坛，大家可以随意吐槽... </p>
              <p><a href="articleFlat"><img src="images/arrow-left-16x16.gif" alt="返回到主题列表" border="0" height="16" hspace="6" width="16"></a> 
               <a href="articleFlat">返回到主题列表</a> </p>
         
          </td>                     
      </tr>
    </tbody>
  </table>
  <br>
  <form action="replyDeal!replyDeal" name="form" method="post" >
    <input type="hidden" name="pid" value="<s:property value="id"/>">
    <input type="hidden" name="rootid" value="<s:property value="rootid"/>">
    
   <td>发帖昵称：<input type="text" name="username" style="height: 20px; width: 155px" onBlur="checkUserName(this.value.toLowerCase())"><br><span id="usernameErr"></span><td>
    <br>
    <input type="hidden" name="post" value="1">
          标 题：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="title" style="height: 20px; width: 155px"><br>
  	<br>
  	内容：<textarea class="ckeditor" name="cont" rows="20" cols="100"></textarea><br>
  	<input type="submit" name="submit" id="submit" value="提交">
  </form>
  
<!-- this is the ckeditor coding -->  
<script type="text/javascript">
 CKEDITOR.replace( 'editor1',//editor1是你文本域的ID
  {
   skin : 'kama'//想要使用的皮肤
  });
</script>
  
  
</div>
</body>
</html>