<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>仿制版BBS by zdz</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<script language="JavaScript" type="text/javascript"
	src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS"
	href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript"
	src="images/common.js"></script>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td width="140"><a
					href="http://bbs.chinajavaworld.com/index.jspa"><img
						src="images/header-left.gif"
						alt="Java|Java世界_中文论坛|ChinaJavaWorld技术论坛" border="0"></a></td>
				<td><img src="images/header-stretch.gif" alt="" border="0"
					height="57" width="100%"></td>
				<td width="1%"><img src="images/header-right.gif" alt=""
					border="0"></td>
			</tr>
		</tbody>
	</table>
	<br>
	<div id="jive-forumpage">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="98%"><p class="jive-breadcrumbs">论坛:
							Java语言web开发练习</p>
						<p class="jive-description">这个是个打酱油的简易论坛，大家可以随意吐槽...</p>
						<p class="jive-description">作者邮箱：424486138@qq.com</p></td>
				</tr>
			</tbody>
		</table>
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a href="newArticle"><img
								src="images/post-16x16.gif" alt="发表新主题" border="0" height="16"
								width="16"></a></td>
						<td class="jive-icon-label"><a id="jive-post-thread"
							href="newArticle">发表新主题</a> <a href="reply"></a></td>
					</tr>
					<td></td>
					<td class="jive-icon-label"><a id="jive-post-thread"
						href="login">管理员登录</a>
					<tr>

					</tr>
				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td><span class="nobreak"> 共 <s:property
								value="totalPageNumber" /> 页 <span class="jive-paginator">
								[ <a
								href="articleFlat?pageNumber=<s:property value='lastPageNumber'/>">上一页</a>
								]第 <s:property value="pageNumber" /> 页 [ <a
								href="articleFlat?pageNumber=<s:property value='nextPageNumber'/>">下一页</a>
								]
						</span>
					</span></td>
				</tr>
			</tbody>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><div class="jive-thread-list">
							<div class="jive-table">
								<table summary="List of threads" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th class="jive-first" colspan="3">主题</th>
											<th class="jive-author"><nobr> 作者 &nbsp; </nobr></th>
											<th class="jive-view-count"><nobr> 浏览 &nbsp; </nobr></th>
											<th class="jive-msg-count" nowrap="nowrap">回复</th>
											<th class="jive-last" nowrap="nowrap">最新帖子</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="articles" status="status">
											<tr
												<s:if test="#status.odd">
											    class="jive-even" 
												</s:if>
												<s:else>
												class="jive-odd"
												</s:else>>
												<td class="jive-first" nowrap="nowrap" width="1%"><div
														class="jive-bullet">
														<img src="images/read-16x16.gif" alt="已读" border="0"
															height="16" width="16">
														<!-- div-->
													</div></td>

												<td nowrap="nowrap" width="1%"></td>

												<td class="jive-thread-name" width="95%"><a
													id="jive-thread-1"
													href="articleFlatDetail?id=<s:property value="id"/>&rootId=<s:property value="rootId"/>"><s:property
															value="title" /></a></td>
												<td class="jive-author" nowrap="nowrap" width="1%"><span
													class=""> <a href=""><s:property
																value="username" /></a>
												</span></td>
												<td class="jive-view-count" width="1%">104</td>
												<td class="jive-msg-count" width="1%">5</td>
												<td class="jive-last" nowrap="nowrap" width="1%"><div
														class="jive-last-post">
														<s:property value="pdate" />
														<br>
													</div></td>
											</tr>

										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						<div class="jive-legend"></div></td>
				</tr>
			</tbody>
		</table>
		<br> <br>
	</div>
</body>
</html>