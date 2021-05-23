package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Pics;
import com.service.PicsService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ajax", produces = "text/plain;charset=utf-8")
public class AjaxController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private PicsService picsService;

	@RequestMapping("save.action")
	@ResponseBody
	public void save() {
		String str = this.getRequest().getParameter("str");
		System.out.println(str);
		String[] s = str.split(",");// 接收参数并转化成数组
		Pics pics = new Pics();
		pics.setGraphsid(s[0]);
		pics.setPicname(s[1]);
		pics.setImage("upfiles/" + s[2]);
		this.picsService.insertPics(pics);
	}
}
