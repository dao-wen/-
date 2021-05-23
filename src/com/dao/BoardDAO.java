package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Board;

@Repository("boardDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface BoardDAO {

	/**
* BoardDAO 接口 可以按名称直接调用board.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包board.xml里的insertBoard配置 返回值0(失败),1(成功)
	public int insertBoard(Board board);

	// 更新数据 调用entity包board.xml里的updateBoard配置 返回值0(失败),1(成功)
	public int updateBoard(Board board);

	// 删除数据 调用entity包board.xml里的deleteBoard配置 返回值0(失败),1(成功)
	public int deleteBoard(String boardid);

	// 查询全部数据 调用entity包board.xml里的getAllBoard配置 返回List类型的数据
	public List<Board> getAllBoard();

	// 按照Board类里面的值精确查询 调用entity包board.xml里的getBoardByCond配置 返回List类型的数据
	public List<Board> getBoardByCond(Board board);

	// 按照Board类里面的值模糊查询 调用entity包board.xml里的getBoardByLike配置 返回List类型的数据
	public List<Board> getBoardByLike(Board board);

	// 按主键查询表返回单一的Board实例 调用entity包board.xml里的getBoardById配置
	public Board getBoardById(String boardid);

}


