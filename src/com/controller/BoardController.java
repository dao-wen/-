package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Board;
import com.service.BoardService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/board" , produces = "text/plain;charset=utf-8")
public class BoardController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private BoardService boardService;

	// 准备添加数据
	@RequestMapping("createBoard.action")
	public String createBoard() {
		return "admin/addboard";
	}
	// 添加数据
	@RequestMapping("addBoard.action")
	public String addBoard(Board board) {
		board.setAddtime(VeDate.getStringDateShort());
		this.boardService.insertBoard(board);
		return "redirect:/board/createBoard.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBoard.action")
	public String deleteBoard(String id) {
		this.boardService.deleteBoard(id);
		return "redirect:/board/getAllBoard.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBoardByIds.action")
	public String deleteBoardByIds() {
		String[] ids = this.getRequest().getParameterValues("boardid");
		for (String boardid : ids) {
			this.boardService.deleteBoard(boardid);
		}
		return "redirect:/board/getAllBoard.action";
	}

	// 更新数据
	@RequestMapping("updateBoard.action")
	public String updateBoard(Board board) {
		this.boardService.updateBoard(board);
		return "redirect:/board/getAllBoard.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBoard.action")
	public String getAllBoard(String number) {
		List<Board> boardList = this.boardService.getAllBoard();
		PageHelper.getPage(boardList, "board", null, null, 10, number, this.getRequest(), null);
		return "admin/listboard";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBoardByCond.action")
	public String queryBoardByCond(String cond, String name, String number) {
		Board board = new Board();
		if(cond != null){
			if ("boardname".equals(cond)) {
				board.setBoardname(name);
			}
			if ("addtime".equals(cond)) {
				board.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				board.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.boardService.getBoardByLike(board), "board", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryboard";
	}

	// 按主键查询数据
	@RequestMapping("getBoardById.action")
	public String getBoardById(String id) {
		Board board = this.boardService.getBoardById(id);
		this.getRequest().setAttribute("board", board);
		return "admin/editboard";
	}


}
