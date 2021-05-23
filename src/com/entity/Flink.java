package com.entity;

import com.util.VeDate;

public class Flink {
	private String flinkid = "F" + VeDate.getStringId();// 生成主键编号
	private String flinkname;// 名称
	private String url;// 地址
	private String addtime;// 创建日期
	private String memo;// 备注

	public String getFlinkid() {
		return flinkid;
	}

	public void setFlinkid(String flinkid) {
		this.flinkid = flinkid;
	}

	public String getFlinkname() {
		return this.flinkname;
	}

	public void setFlinkname(String flinkname) {
		this.flinkname = flinkname;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Flink [flinkid=" + this.flinkid + ", flinkname=" + this.flinkname + ", url=" + this.url + ", addtime="
				+ this.addtime + ", memo=" + this.memo + "]";
	}

}
