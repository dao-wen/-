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
<link href="themes/ladder.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			用户中心
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
			<ul class="timeline">
				<c:forEach items="${ladderList}" var="ladder">
					<li>
						<div class="time">${ladder.addtime }</div>
						<div class="number"></div>
						<div class="content">
							<pre>${ladder.title }</pre>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="blank"></div>
	<script>
		$(function() {
			var nextDataNumber = 5;

			var ulNode = $('ul.timeline');

			function initLiNodes() {
				var liNodes = ulNode.find('li'), count = liNodes.length, i, liNode, leftCount = nextDataNumber * 20;
				for (i = 0; i < count; i++) {
					liNode = $(liNodes.get(i));
					if (i % 2 !== 0) {
						liNode.addClass('alt');
					} else {
						liNode.removeClass('alt');
					}
					liNode.find('.number').text(leftCount + count - i);
				}
			}

			$('#fetchNextData').click(
					function() {
						var $this = $(this);
						$this.addClass('disabled').text('......');

						$.get('./version_data_' + nextDataNumber + '.txt',
								function(data) {
									ulNode.append(data);
									$this.removeClass('disabled')
											.text('后二十条数据');
									nextDataNumber--;

									if (nextDataNumber === 0) {
										$this.hide();
									}

									initLiNodes();
								});

					});

			initLiNodes();

		});
	</script>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
