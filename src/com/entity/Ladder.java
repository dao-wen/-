package com.entity;

import com.util.VeDate;

public class Ladder {
	private String ladderid = "L" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 发布人
	private String title;// 标题
	private String addtime;// 日期
	private String username;// 映射数据

	public String getLadderid() {
		return ladderid;
	}

	public void setLadderid(String ladderid) {
		this.ladderid = ladderid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Ladder [ladderid=" + this.ladderid + ", usersid=" + this.usersid + ", title=" + this.title
				+ ", addtime=" + this.addtime + ", username=" + this.username + "]";
	}

}
