package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BoardDAO;
import com.entity.Board;
import com.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBoard(Board board) {
		return this.boardDAO.insertBoard(board);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBoard(Board board) {
		return this.boardDAO.updateBoard(board);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBoard(String boardid) {
		return this.boardDAO.deleteBoard(boardid);
	}

	@Override // 继承接口的查询全部
	public List<Board> getAllBoard() {
		return this.boardDAO.getAllBoard();
	}

	@Override // 继承接口的按条件精确查询
	public List<Board> getBoardByCond(Board board) {
		return this.boardDAO.getBoardByCond(board);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Board> getBoardByLike(Board board) {
		return this.boardDAO.getBoardByLike(board);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Board getBoardById(String boardid) {
		return this.boardDAO.getBoardById(boardid);
	}

}

