package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Banner;
import com.entity.Bbs;
import com.entity.Board;
import com.entity.Flink;
import com.entity.Graphs;
import com.entity.Ladder;
import com.entity.Pics;
import com.entity.Rebbs;
import com.entity.Users;
import com.entity.Vedio;
import com.service.ArticleService;
import com.service.BannerService;
import com.service.BbsService;
import com.service.BoardService;
import com.service.FlinkService;
import com.service.GraphsService;
import com.service.LadderService;
import com.service.PicsService;
import com.service.RebbsService;
import com.service.UsersService;
import com.service.VedioService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private GraphsService graphsService;
	@Autowired
	private PicsService picsService;
	@Autowired
	private VedioService vedioService;
	@Autowired
	private LadderService ladderService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private BbsService bbsService;
	@Autowired
	private RebbsService rebbsService;
	@Autowired
	private FlinkService flinkService;

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "育儿亲子平台");
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
		List<Board> boardList = this.boardService.getAllBoard();
		this.getRequest().setAttribute("boardList", boardList);
		List<Flink> flinkList = this.flinkService.getAllFlink();
		this.getRequest().setAttribute("flinkList", flinkList);
		List<Graphs> hotList = this.graphsService.getHotGraphs();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Graphs> graphsList = this.graphsService.getFrontGraphs();
		this.getRequest().setAttribute("graphsList", graphsList);
		List<Vedio> vedioList = this.vedioService.getFrontVedio();
		this.getRequest().setAttribute("vedioList", vedioList);
		return "users/index";
	}

	// 新闻公告
	@RequestMapping("article.action")
	public String article(String id, String number) {
		this.front();
		Article article = new Article();
		article.setBannerid(id);
		List<Article> articleList = this.articleService.getArticleByCond(article);
		PageHelper.getIndexPage(articleList, "article", "article", id, 10, number, this.getRequest());
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	@RequestMapping("graphs.action")
	public String graphs(String number) {
		this.front();
		List<Graphs> graphsList = this.graphsService.getAllGraphs();
		PageHelper.getIndexPage(graphsList, "graphs", "graphs", null, 12, number, this.getRequest());
		return "users/graphs";
	}

	// 阅读公告
	@RequestMapping("graphsdetail.action")
	public String graphsdetail(String id) {
		this.front();
		Graphs graphs = this.graphsService.getGraphsById(id);
		graphs.setHits("" + (Integer.parseInt(graphs.getHits()) + 1));
		this.graphsService.updateGraphs(graphs);
		this.getRequest().setAttribute("graphs", graphs);
		Pics pics = new Pics();
		pics.setGraphsid(id);
		List<Pics> picsList = this.picsService.getPicsByCond(pics);
		this.getRequest().setAttribute("picsList", picsList);
		return "users/graphsdetail";
	}

	@RequestMapping("vedio.action")
	public String vedio(String number) {
		this.front();
		List<Vedio> vedioList = this.vedioService.getAllVedio();
		PageHelper.getIndexPage(vedioList, "vedio", "vedio", null, 12, number, this.getRequest());
		return "users/vedio";
	}

	// 阅读公告
	@RequestMapping("vediodetail.action")
	public String vediodetail(String id) {
		this.front();
		Vedio vedio = this.vedioService.getVedioById(id);
		vedio.setHits("" + (Integer.parseInt(vedio.getHits()) + 1));
		this.vedioService.updateVedio(vedio);
		this.getRequest().setAttribute("vedio", vedio);
		return "users/vediodetail";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	// 留言板
	@RequestMapping("bbs.action")
	public String bbs(String id) {
		this.front();
		Bbs bbs = new Bbs();
		bbs.setBoardid(id);
		List<Bbs> bbsList = this.bbsService.getBbsByCond(bbs);
		this.getRequest().setAttribute("bbsList", bbsList);
		this.getRequest().setAttribute("id", id);
		return "users/bbs";
	}

	// 发布留言
	@RequestMapping("addbbs.action")
	public String addbbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Bbs bbs = new Bbs();
		bbs.setAddtime(VeDate.getStringDate());
		bbs.setContents(getRequest().getParameter("contents"));
		bbs.setBoardid(this.getRequest().getParameter("boardid"));
		bbs.setHits("0");
		bbs.setRepnum("0");
		bbs.setTitle(getRequest().getParameter("title"));
		bbs.setUsersid(userid);
		this.bbsService.insertBbs(bbs);
		return "redirect:/index/bbs.action?id=" + bbs.getBoardid();
	}

	// 查看留言
	@RequestMapping("readbbs.action")
	public String readbbs() {
		this.front();
		Bbs bbs = this.bbsService.getBbsById(getRequest().getParameter("id"));
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsService.updateBbs(bbs);
		this.getRequest().setAttribute("bbs", bbs);
		Rebbs rebbs = new Rebbs();
		rebbs.setBbsid(bbs.getBbsid());
		List<Rebbs> rebbsList = this.rebbsService.getRebbsByCond(rebbs);
		this.getRequest().setAttribute("rebbsList", rebbsList);
		return "users/readbbs";
	}

	// 回复留言
	@RequestMapping("rebbs.action")
	public String rebbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Rebbs rebbs = new Rebbs();
		rebbs.setAddtime(VeDate.getStringDate());
		rebbs.setContents(getRequest().getParameter("contents"));
		rebbs.setBbsid(getRequest().getParameter("bbsid"));
		rebbs.setUsersid(userid);
		this.rebbsService.insertRebbs(rebbs);
		Bbs bbs = this.bbsService.getBbsById(rebbs.getBbsid());
		bbs.setRepnum("" + (Integer.parseInt(bbs.getRepnum()) + 1));
		this.bbsService.updateBbs(bbs);
		String path = "redirect:/index/readbbs.action?id=" + bbs.getBbsid();
		return path;
	}

	@RequestMapping("preLadder.action")
	public String preLadder() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addLadder";
	}

	@RequestMapping("addLadder.action")
	public String addLadder(Ladder ladder) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		ladder.setAddtime(VeDate.getStringDate());
		ladder.setUsersid(userid);
		this.ladderService.insertLadder(ladder);
		return "redirect:/index/preLadder.action";
	}

	@RequestMapping("myLadder.action")
	public String myLadder(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Ladder ladder = new Ladder();
		ladder.setUsersid(userid);
		List<Ladder> ladderList = this.ladderService.getLadderByCond(ladder);
		this.getRequest().setAttribute("ladderList", ladderList);
		return "users/myLadder";
	}

	@RequestMapping("preGraphs.action")
	public String preGraphs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("gno", "G" + VeDate.getStringId());
		return "users/addGraphs";
	}

	@RequestMapping("addGraphs.action")
	public String addGraphs(Graphs graphs) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		graphs.setAddtime(VeDate.getStringDate());
		graphs.setUsersid(userid);
		graphs.setHits("0");
		this.graphsService.insertGraphs(graphs);
		return "redirect:/index/preGraphs.action";
	}

	@RequestMapping("myGraphs.action")
	public String myGraphs(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Graphs graphs = new Graphs();
		graphs.setUsersid(userid);
		List<Graphs> graphsList = this.graphsService.getGraphsByCond(graphs);
		PageHelper.getIndexPage(graphsList, "graphs", "myGraphs", null, 10, number, this.getRequest());
		return "users/myGraphs";
	}

	@RequestMapping("deletegraphs.action")
	public String deletegraphs(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.graphsService.deleteGraphs(id);
		return "redirect:/index/myGraphs.action";
	}

	// Vedio
	@RequestMapping("preVedio.action")
	public String preVedio() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addVedio";
	}

	@RequestMapping("addVedio.action")
	public String addVedio(Vedio vedio) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		vedio.setAddtime(VeDate.getStringDate());
		vedio.setUsersid(userid);
		vedio.setHits("0");
		this.vedioService.insertVedio(vedio);
		return "redirect:/index/preVedio.action";
	}

	@RequestMapping("myVedio.action")
	public String myVedio(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Vedio vedio = new Vedio();
		vedio.setUsersid(userid);
		List<Vedio> vedioList = this.vedioService.getVedioByCond(vedio);
		PageHelper.getIndexPage(vedioList, "vedio", "myVedio", null, 10, number, this.getRequest());
		return "users/myVedio";
	}

	@RequestMapping("deletevedio.action")
	public String deletevedio(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.vedioService.deleteVedio(id);
		return "redirect:/index/myVedio.action";
	}
}
