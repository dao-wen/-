<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index.jsp">首页</a>
			<code> &gt; </code>
			<a href="index/vedio.action">成长记录</a>
			<code> &gt; </code>
			${vedio.title }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>${vedio.title }</span>
				</h3>
				<div class="boxCenterList" align="center">
					<video controls autoplay class="bg_qc">
						<source src="${vedio.fileurl}" type="video/mp4">
					</video>
					<br /> ${vedio.contents }
				</div>
			</div>
		</div>
		<div class="blank5"></div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
