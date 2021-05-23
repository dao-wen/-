package com.entity;

import com.util.VeDate;

public class Vedio {
	private String vedioid = "V" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 发布人
	private String title;// 标题
	private String image;// 封面
	private String fileurl;// 文件
	private String contents;// 内容
	private String addtime;// 发布日期
	private String hits;// 点击数
	private String username;// 映射数据

	public String getVedioid() {
		return vedioid;
	}

	public void setVedioid(String vedioid) {
		this.vedioid = vedioid;
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

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFileurl() {
		return this.fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
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
		return "Vedio [vedioid=" + this.vedioid + ", usersid=" + this.usersid + ", title=" + this.title + ", image="
				+ this.image + ", fileurl=" + this.fileurl + ", contents=" + this.contents + ", addtime=" + this.addtime
				+ ", hits=" + this.hits + ", username=" + this.username + "]";
	}

}
