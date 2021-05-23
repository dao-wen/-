package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Ladder;

@Repository("ladderDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface LadderDAO {

	/**
* LadderDAO 接口 可以按名称直接调用ladder.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包ladder.xml里的insertLadder配置 返回值0(失败),1(成功)
	public int insertLadder(Ladder ladder);

	// 更新数据 调用entity包ladder.xml里的updateLadder配置 返回值0(失败),1(成功)
	public int updateLadder(Ladder ladder);

	// 删除数据 调用entity包ladder.xml里的deleteLadder配置 返回值0(失败),1(成功)
	public int deleteLadder(String ladderid);

	// 查询全部数据 调用entity包ladder.xml里的getAllLadder配置 返回List类型的数据
	public List<Ladder> getAllLadder();

	// 按照Ladder类里面的值精确查询 调用entity包ladder.xml里的getLadderByCond配置 返回List类型的数据
	public List<Ladder> getLadderByCond(Ladder ladder);

	// 按照Ladder类里面的值模糊查询 调用entity包ladder.xml里的getLadderByLike配置 返回List类型的数据
	public List<Ladder> getLadderByLike(Ladder ladder);

	// 按主键查询表返回单一的Ladder实例 调用entity包ladder.xml里的getLadderById配置
	public Ladder getLadderById(String ladderid);

}


