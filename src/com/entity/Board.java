package com.entity;

import com.util.VeDate;

public class Board {
	private String boardid = "B" + VeDate.getStringId();// 生成主键编号
	private String boardname;// 板块名称
	private String addtime;// 创建日期
	private String memo;// 备注

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getBoardname() {
		return this.boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
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
		return "Board [boardid=" + this.boardid + ", boardname=" + this.boardname + ", addtime=" + this.addtime
				+ ", memo=" + this.memo + "]";
	}

}
