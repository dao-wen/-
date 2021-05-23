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
	<div style="clear: both"></div>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			<a href="index.jsp">首页</a>
			<code> &gt; </code>
			家庭相册
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>家庭相册</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="graphs">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/graphsdetail.action?id=${graphs.graphsid }" target="_blank"><img src="${graphs.image }"
										alt="" class="B_blue" /> </a></li>
								<li><a href="index/graphsdetail.action?id=${graphs.graphsid }" target="_blank" title="">${graphs.title }</a> <br /></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>家庭相册</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none; padding: 11px 0 10px 0px;">
						<c:forEach items="${graphsList}" var="graphs">
							<div class="goodsItem">
								<a href="index/graphsdetail.action?id=${graphs.graphsid }" target="_blank"><img src="${graphs.image }" alt="" class="goodsimg" /></a><br />
								<p>
									<a href="index/graphsdetail.action?id=${graphs.graphsid }" title="" target="_blank">${graphs.title }</a>
								</p>
							</div>
						</c:forEach>
					</div>

				</div>
			</div>
			<div class="blank5"></div>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
				<tr>
					<td align="center" bgcolor="#ffffff">${html}</td>
				</tr>
			</table>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
