<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="js/tab.js" charset="utf-8"></script>
</head>
<body>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg" id="tblData">
			<thead>
				<tr class="text-c">
					<th>标题</th>
					<th>文件</th>
					<th>
						<button id="btnAdd" class="btn btn-secondary radius" type="button">
							<i class="Hui-iconfont">&#xe600;</i>
						</button>
					</th>
				</tr>
			</thead>
			<tr class="text-c" id="tRow0">
				<td>
					<div style="display: block" >
						<input type="text" name="picname" class="input-text" id="picname" placeholder="请输入标题"/>
					</div>
				</td>
				<td>
					<div style="display: block" class="updForm">
						<form id="head-img" enctype="multipart/form-data">
							<input type="file" name="image" class="layui-input" accept="image/jpeg,image/png,image/gif" id="image" class="m0" />
						</form>
					</div>
					<div style="display: none" class="updText">
						<span class="m1"></span> <input type="hidden" value="" class="m2">
					</div>
				</td>
				<td><input type="hidden" name="galleryid" id="galleryid" value="${gno }" class="m3"> <input type="hidden" id="hidNum"
					name="hidNum" value="0" /> <input type="hidden" id="basepath" name="basepath" value="<%=basePath%>" />
					<div style="display: none" class="btns">
						<button id="btnSave" class="btn btn-secondary radius" type="button">
							<i class="Hui-iconfont">&#xe632;</i>保存
						</button>
					</div>
					<div style="display: block" class="btnu">
						<button id="btnUpload" class="btn btn-primary upload-btn" type="button">
							<i class="Hui-iconfont">&#xe642;</i>上传
						</button>
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>

