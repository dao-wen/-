package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Ladder;
import com.service.LadderService;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ladder" , produces = "text/plain;charset=utf-8")
public class LadderController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private LadderService ladderService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createLadder.action")
	public String createLadder() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addladder";
	}
	// 添加数据
	@RequestMapping("addLadder.action")
	public String addLadder(Ladder ladder) {
		ladder.setAddtime(VeDate.getStringDateShort());
		this.ladderService.insertLadder(ladder);
		return "redirect:/ladder/createLadder.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteLadder.action")
	public String deleteLadder(String id) {
		this.ladderService.deleteLadder(id);
		return "redirect:/ladder/getAllLadder.action";
	}

	// 批量删除数据
	@RequestMapping("deleteLadderByIds.action")
	public String deleteLadderByIds() {
		String[] ids = this.getRequest().getParameterValues("ladderid");
		for (String ladderid : ids) {
			this.ladderService.deleteLadder(ladderid);
		}
		return "redirect:/ladder/getAllLadder.action";
	}

	// 更新数据
	@RequestMapping("updateLadder.action")
	public String updateLadder(Ladder ladder) {
		this.ladderService.updateLadder(ladder);
		return "redirect:/ladder/getAllLadder.action";
	}

	// 显示全部数据
	@RequestMapping("getAllLadder.action")
	public String getAllLadder(String number) {
		List<Ladder> ladderList = this.ladderService.getAllLadder();
		PageHelper.getPage(ladderList, "ladder", null, null, 10, number, this.getRequest(), null);
		return "admin/listladder";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryLadderByCond.action")
	public String queryLadderByCond(String cond, String name, String number) {
		Ladder ladder = new Ladder();
		if(cond != null){
			if ("usersid".equals(cond)) {
				ladder.setUsersid(name);
			}
			if ("title".equals(cond)) {
				ladder.setTitle(name);
			}
			if ("addtime".equals(cond)) {
				ladder.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ladderService.getLadderByLike(ladder), "ladder", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryladder";
	}

	// 按主键查询数据
	@RequestMapping("getLadderById.action")
	public String getLadderById(String id) {
		Ladder ladder = this.ladderService.getLadderById(id);
		this.getRequest().setAttribute("ladder", ladder);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editladder";
	}


}
