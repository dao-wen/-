package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Flink;
import com.service.FlinkService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/flink" , produces = "text/plain;charset=utf-8")
public class FlinkController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private FlinkService flinkService;

	// 准备添加数据
	@RequestMapping("createFlink.action")
	public String createFlink() {
		return "admin/addflink";
	}
	// 添加数据
	@RequestMapping("addFlink.action")
	public String addFlink(Flink flink) {
		flink.setAddtime(VeDate.getStringDateShort());
		this.flinkService.insertFlink(flink);
		return "redirect:/flink/createFlink.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteFlink.action")
	public String deleteFlink(String id) {
		this.flinkService.deleteFlink(id);
		return "redirect:/flink/getAllFlink.action";
	}

	// 批量删除数据
	@RequestMapping("deleteFlinkByIds.action")
	public String deleteFlinkByIds() {
		String[] ids = this.getRequest().getParameterValues("flinkid");
		for (String flinkid : ids) {
			this.flinkService.deleteFlink(flinkid);
		}
		return "redirect:/flink/getAllFlink.action";
	}

	// 更新数据
	@RequestMapping("updateFlink.action")
	public String updateFlink(Flink flink) {
		this.flinkService.updateFlink(flink);
		return "redirect:/flink/getAllFlink.action";
	}

	// 显示全部数据
	@RequestMapping("getAllFlink.action")
	public String getAllFlink(String number) {
		List<Flink> flinkList = this.flinkService.getAllFlink();
		PageHelper.getPage(flinkList, "flink", null, null, 10, number, this.getRequest(), null);
		return "admin/listflink";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryFlinkByCond.action")
	public String queryFlinkByCond(String cond, String name, String number) {
		Flink flink = new Flink();
		if(cond != null){
			if ("flinkname".equals(cond)) {
				flink.setFlinkname(name);
			}
			if ("url".equals(cond)) {
				flink.setUrl(name);
			}
			if ("addtime".equals(cond)) {
				flink.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				flink.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.flinkService.getFlinkByLike(flink), "flink", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryflink";
	}

	// 按主键查询数据
	@RequestMapping("getFlinkById.action")
	public String getFlinkById(String id) {
		Flink flink = this.flinkService.getFlinkById(id);
		this.getRequest().setAttribute("flink", flink);
		return "admin/editflink";
	}


}
