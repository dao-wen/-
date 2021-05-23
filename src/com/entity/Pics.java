package com.entity;

import com.util.VeDate;

public class Pics {
	private String picsid = "P" + VeDate.getStringId();// 生成主键编号
	private String picname;// 标题
	private String image;// 图片
	private String graphsid;// 相册
	private String title;// 映射数据

	public String getPicsid() {
		return picsid;
	}

	public void setPicsid(String picsid) {
		this.picsid = picsid;
	}

	public String getPicname() {
		return this.picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGraphsid() {
		return this.graphsid;
	}

	public void setGraphsid(String graphsid) {
		this.graphsid = graphsid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Pics [picsid=" + this.picsid + ", picname=" + this.picname + ", image=" + this.image + ", graphsid="
				+ this.graphsid + ", title=" + this.title + "]";
	}

}
