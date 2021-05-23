<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			成长MV
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">

						<h5>
							<span>成长MV</span>
						</h5>
						<div class="blank"></div>
						<form action="index/addVedio.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="20%" align="right" bgcolor="#FFFFFF">标题：</td>
									<td width="80%" align="left" bgcolor="#FFFFFF"><input name="title" type="text" size="25" class="inputBg" id="title"
										placeholder="请输入标题" /></td>
								</tr>
								<tr>
									<td width="20%" align="right" bgcolor="#FFFFFF">封面：</td>
									<td width="80%" align="left" bgcolor="#FFFFFF"><input type="text" size="25" class="inputBg" name="image" id="image"
										onclick="selimage();" placeholder="请选择图片" readonly="readonly" /></td>
								</tr>
								<tr>
									<td width="20%" align="right" bgcolor="#FFFFFF">MV文件：</td>
									<td width="80%" align="left" bgcolor="#FFFFFF"><input type="text" size="25" class="inputBg" name="fileurl" id="fileurl"
										onclick="savefile();" placeholder="请选择MV文件" readonly="readonly" /></td>
								</tr>
								<tr>
									<td width="20%" align="right" bgcolor="#FFFFFF">内容：</td>
									<td width="80%" align="left" bgcolor="#FFFFFF"><script type="text/javascript" src="ckeditor/ckeditor.js"></script> <textarea
											class="textarea" name="contents" id="contents" placeholder="请输入内容"> </textarea> <script type="text/javascript">
												CKEDITOR.replace('contents', {
													language : 'zh-cn'
												});
											</script></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="hidden" name="graphsid" value="${gno }" id="graphsid"> <input
										type="submit" class="bnt_blue_1" style="border: none;" value="确认提交" /></td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
