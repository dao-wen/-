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
<link rel="stylesheet" href="css/style.css">

</head>

<body>
	<div id="drag-container">
		<div id="spin-container">
			<img src="${graphs.image}" alt="${graphs.title}">
			<c:forEach items="${picsList}" var="pics">
				<img src="${pics.image }" alt="${pic.picname }">
			</c:forEach>
			<p>3D旋转木马</p>
		</div>
		<div id="ground"></div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
