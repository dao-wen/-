package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Board;
@Service("boardService")
public interface BoardService {
	// 插入数据 调用boardDAO里的insertBoard配置
	public int insertBoard(Board board);

	// 更新数据 调用boardDAO里的updateBoard配置
	public int updateBoard(Board board);

	// 删除数据 调用boardDAO里的deleteBoard配置
	public int deleteBoard(String boardid);

	// 查询全部数据 调用boardDAO里的getAllBoard配置
	public List<Board> getAllBoard();

	// 按照Board类里面的字段名称精确查询 调用boardDAO里的getBoardByCond配置
	public List<Board> getBoardByCond(Board board);

	// 按照Board类里面的字段名称模糊查询 调用boardDAO里的getBoardByLike配置
	public List<Board> getBoardByLike(Board board);

	// 按主键查询表返回单一的Board实例 调用boardDAO里的getBoardById配置
	public Board getBoardById(String boardid);

}

