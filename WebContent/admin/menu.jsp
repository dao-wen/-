<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>管理员<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/createAdmin.action" data-title="新增管理员" href="javascript:void(0)">新增管理员</a></li>
					<li><a data-href="admin/getAllAdmin.action" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
					<li><a data-href="admin/queryAdminByCond.action" data-title="管理员查询" href="javascript:void(0)">管理员查询</a></li>
					<li><a data-href="admin/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站用户<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="users/getAllUsers.action" data-title="网站用户列表" href="javascript:void(0)">网站用户列表</a></li>
					<li><a data-href="users/queryUsersByCond.action" data-title="网站用户查询" href="javascript:void(0)">网站用户查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站栏目<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="banner/createBanner.action" data-title="新增网站栏目" href="javascript:void(0)">新增网站栏目</a></li>
					<li><a data-href="banner/getAllBanner.action" data-title="网站栏目列表" href="javascript:void(0)">网站栏目列表</a></li>
					<li><a data-href="banner/queryBannerByCond.action" data-title="网站栏目查询" href="javascript:void(0)">网站栏目查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站内容<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="article/createArticle.action" data-title="新增网站内容" href="javascript:void(0)">新增网站内容</a></li>
					<li><a data-href="article/getAllArticle.action" data-title="网站内容列表" href="javascript:void(0)">网站内容列表</a></li>
					<li><a data-href="article/queryArticleByCond.action" data-title="网站内容查询" href="javascript:void(0)">网站内容查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>家庭相册<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="graphs/getAllGraphs.action" data-title="家庭相册列表" href="javascript:void(0)">家庭相册列表</a></li>
					<li><a data-href="graphs/queryGraphsByCond.action" data-title="家庭相册查询" href="javascript:void(0)">家庭相册查询</a></li>
					<li><a data-href="pics/getAllPics.action" data-title="图片文件列表" href="javascript:void(0)">图片文件列表</a></li>
					<li><a data-href="pics/queryPicsByCond.action" data-title="图片文件查询" href="javascript:void(0)">图片文件查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>成长记录<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="vedio/getAllVedio.action" data-title="成长MV列表" href="javascript:void(0)">成长记录列表</a></li>
					<li><a data-href="vedio/queryVedioByCond.action" data-title="成长MV查询" href="javascript:void(0)">成长记录查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>成长纪念<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="ladder/getAllLadder.action" data-title="成长阶梯列表" href="javascript:void(0)">成长纪念列表</a></li>
					<li><a data-href="ladder/queryLadderByCond.action" data-title="成长阶梯查询" href="javascript:void(0)">成长纪念查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>交流信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="board/createBoard.action" data-title="新增交流版块" href="javascript:void(0)">新增交流版块</a></li>
					<li><a data-href="board/getAllBoard.action" data-title="交流版块列表" href="javascript:void(0)">交流版块列表</a></li>
					<li><a data-href="board/queryBoardByCond.action" data-title="交流版块查询" href="javascript:void(0)">交流版块查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>留言信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="bbs/getAllBbs.action" data-title="留言交流列表" href="javascript:void(0)">留言交流列表</a></li>
					<li><a data-href="bbs/queryBbsByCond.action" data-title="留言交流查询" href="javascript:void(0)">留言交流查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>留言回复<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="rebbs/getAllRebbs.action" data-title="留言回复列表" href="javascript:void(0)">留言回复列表</a></li>
					<li><a data-href="rebbs/queryRebbsByCond.action" data-title="留言回复查询" href="javascript:void(0)">留言回复查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>友情链接<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="flink/createFlink.action" data-title="新增友情链接" href="javascript:void(0)">新增友情链接</a></li>
					<li><a data-href="flink/getAllFlink.action" data-title="友情链接列表" href="javascript:void(0)">友情链接列表</a></li>
					<li><a data-href="flink/queryFlinkByCond.action" data-title="友情链接查询" href="javascript:void(0)">友情链接查询</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>


