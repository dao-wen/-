package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Graphs;
import com.service.GraphsService;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/graphs" , produces = "text/plain;charset=utf-8")
public class GraphsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private GraphsService graphsService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createGraphs.action")
	public String createGraphs() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addgraphs";
	}
	// 添加数据
	@RequestMapping("addGraphs.action")
	public String addGraphs(Graphs graphs) {
		graphs.setUsersid("");
		graphs.setAddtime(VeDate.getStringDateShort());
		graphs.setHits("0");
		this.graphsService.insertGraphs(graphs);
		return "redirect:/graphs/createGraphs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteGraphs.action")
	public String deleteGraphs(String id) {
		this.graphsService.deleteGraphs(id);
		return "redirect:/graphs/getAllGraphs.action";
	}

	// 批量删除数据
	@RequestMapping("deleteGraphsByIds.action")
	public String deleteGraphsByIds() {
		String[] ids = this.getRequest().getParameterValues("graphsid");
		for (String graphsid : ids) {
			this.graphsService.deleteGraphs(graphsid);
		}
		return "redirect:/graphs/getAllGraphs.action";
	}

	// 更新数据
	@RequestMapping("updateGraphs.action")
	public String updateGraphs(Graphs graphs) {
		this.graphsService.updateGraphs(graphs);
		return "redirect:/graphs/getAllGraphs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllGraphs.action")
	public String getAllGraphs(String number) {
		List<Graphs> graphsList = this.graphsService.getAllGraphs();
		PageHelper.getPage(graphsList, "graphs", null, null, 10, number, this.getRequest(), null);
		return "admin/listgraphs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryGraphsByCond.action")
	public String queryGraphsByCond(String cond, String name, String number) {
		Graphs graphs = new Graphs();
		if(cond != null){
			if ("usersid".equals(cond)) {
				graphs.setUsersid(name);
			}
			if ("title".equals(cond)) {
				graphs.setTitle(name);
			}
			if ("image".equals(cond)) {
				graphs.setImage(name);
			}
			if ("contents".equals(cond)) {
				graphs.setContents(name);
			}
			if ("addtime".equals(cond)) {
				graphs.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				graphs.setHits(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.graphsService.getGraphsByLike(graphs), "graphs", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querygraphs";
	}

	// 按主键查询数据
	@RequestMapping("getGraphsById.action")
	public String getGraphsById(String id) {
		Graphs graphs = this.graphsService.getGraphsById(id);
		this.getRequest().setAttribute("graphs", graphs);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editgraphs";
	}


}
