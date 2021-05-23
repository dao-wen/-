package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Vedio;
import com.service.VedioService;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/vedio" , produces = "text/plain;charset=utf-8")
public class VedioController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private VedioService vedioService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createVedio.action")
	public String createVedio() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addvedio";
	}
	// 添加数据
	@RequestMapping("addVedio.action")
	public String addVedio(Vedio vedio) {
		vedio.setUsersid("");
		vedio.setAddtime(VeDate.getStringDateShort());
		vedio.setHits("0");
		this.vedioService.insertVedio(vedio);
		return "redirect:/vedio/createVedio.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteVedio.action")
	public String deleteVedio(String id) {
		this.vedioService.deleteVedio(id);
		return "redirect:/vedio/getAllVedio.action";
	}

	// 批量删除数据
	@RequestMapping("deleteVedioByIds.action")
	public String deleteVedioByIds() {
		String[] ids = this.getRequest().getParameterValues("vedioid");
		for (String vedioid : ids) {
			this.vedioService.deleteVedio(vedioid);
		}
		return "redirect:/vedio/getAllVedio.action";
	}

	// 更新数据
	@RequestMapping("updateVedio.action")
	public String updateVedio(Vedio vedio) {
		this.vedioService.updateVedio(vedio);
		return "redirect:/vedio/getAllVedio.action";
	}

	// 显示全部数据
	@RequestMapping("getAllVedio.action")
	public String getAllVedio(String number) {
		List<Vedio> vedioList = this.vedioService.getAllVedio();
		PageHelper.getPage(vedioList, "vedio", null, null, 10, number, this.getRequest(), null);
		return "admin/listvedio";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryVedioByCond.action")
	public String queryVedioByCond(String cond, String name, String number) {
		Vedio vedio = new Vedio();
		if(cond != null){
			if ("usersid".equals(cond)) {
				vedio.setUsersid(name);
			}
			if ("title".equals(cond)) {
				vedio.setTitle(name);
			}
			if ("image".equals(cond)) {
				vedio.setImage(name);
			}
			if ("fileurl".equals(cond)) {
				vedio.setFileurl(name);
			}
			if ("contents".equals(cond)) {
				vedio.setContents(name);
			}
			if ("addtime".equals(cond)) {
				vedio.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				vedio.setHits(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.vedioService.getVedioByLike(vedio), "vedio", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryvedio";
	}

	// 按主键查询数据
	@RequestMapping("getVedioById.action")
	public String getVedioById(String id) {
		Vedio vedio = this.vedioService.getVedioById(id);
		this.getRequest().setAttribute("vedio", vedio);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editvedio";
	}


}
