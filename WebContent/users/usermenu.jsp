<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="userMenu">
	
	<a href="index/usercenter.action"><img src="themes/ecmoban_dangdang/images/u2.gif" />用户中心</a> 
	<a href="index/userinfo.action"><img src="themes/ecmoban_dangdang/images/u2.gif" />用户信息</a> 
	<a href="index/prePwd.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />修改密码</a> 
	<a href="index/preGraphs.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />发布家庭相册</a> 
	<a href="index/myGraphs.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的家庭相册</a>
	<a href="index/preVedio.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />发布成长MV</a> 
	<a href="index/myVedio.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的成长MV</a>
	<a href="index/preLadder.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />发布成长阶梯</a> 
	<a href="index/myLadder.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的成长阶梯</a> 
	<a href="index/exit.action" style="background: none; text-align: right; margin-right: 10px;"> <img
		src="themes/ecmoban_dangdang/images/bnt_sign.gif" /></a>
</div>
