package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Pics;
import com.service.PicsService;
import com.entity.Graphs;
import com.service.GraphsService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/pics", produces = "text/plain;charset=utf-8")
public class PicsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private PicsService picsService;
	@Autowired
	private GraphsService graphsService;

	// 准备添加数据
	@RequestMapping("createPics.action")
	public String createPics(String gno) {
		this.getRequest().setAttribute("gno", gno);
		return "admin/addpics";
	}

	// 添加数据
	@RequestMapping("addPics.action")
	public String addPics(Pics pics) {
		this.picsService.insertPics(pics);
		return "redirect:/pics/createPics.action";
	}

	// 通过主键删除数据
	@RequestMapping("deletePics.action")
	public String deletePics(String id) {
		this.picsService.deletePics(id);
		return "redirect:/pics/getAllPics.action";
	}

	// 批量删除数据
	@RequestMapping("deletePicsByIds.action")
	public String deletePicsByIds() {
		String[] ids = this.getRequest().getParameterValues("picsid");
		for (String picsid : ids) {
			this.picsService.deletePics(picsid);
		}
		return "redirect:/pics/getAllPics.action";
	}

	// 更新数据
	@RequestMapping("updatePics.action")
	public String updatePics(Pics pics) {
		this.picsService.updatePics(pics);
		return "redirect:/pics/getAllPics.action";
	}

	// 显示全部数据
	@RequestMapping("getAllPics.action")
	public String getAllPics(String number) {
		List<Pics> picsList = this.picsService.getAllPics();
		PageHelper.getPage(picsList, "pics", null, null, 10, number, this.getRequest(), null);
		return "admin/listpics";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryPicsByCond.action")
	public String queryPicsByCond(String cond, String name, String number) {
		Pics pics = new Pics();
		if (cond != null) {
			if ("picname".equals(cond)) {
				pics.setPicname(name);
			}
			if ("image".equals(cond)) {
				pics.setImage(name);
			}
			if ("graphsid".equals(cond)) {
				pics.setGraphsid(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.picsService.getPicsByLike(pics), "pics", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querypics";
	}

	// 按主键查询数据
	@RequestMapping("getPicsById.action")
	public String getPicsById(String id) {
		Pics pics = this.picsService.getPicsById(id);
		this.getRequest().setAttribute("pics", pics);
		List<Graphs> graphsList = this.graphsService.getAllGraphs();
		this.getRequest().setAttribute("graphsList", graphsList);
		return "admin/editpics";
	}

}
