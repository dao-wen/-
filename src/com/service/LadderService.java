package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Ladder;
@Service("ladderService")
public interface LadderService {
	// 插入数据 调用ladderDAO里的insertLadder配置
	public int insertLadder(Ladder ladder);

	// 更新数据 调用ladderDAO里的updateLadder配置
	public int updateLadder(Ladder ladder);

	// 删除数据 调用ladderDAO里的deleteLadder配置
	public int deleteLadder(String ladderid);

	// 查询全部数据 调用ladderDAO里的getAllLadder配置
	public List<Ladder> getAllLadder();

	// 按照Ladder类里面的字段名称精确查询 调用ladderDAO里的getLadderByCond配置
	public List<Ladder> getLadderByCond(Ladder ladder);

	// 按照Ladder类里面的字段名称模糊查询 调用ladderDAO里的getLadderByLike配置
	public List<Ladder> getLadderByLike(Ladder ladder);

	// 按主键查询表返回单一的Ladder实例 调用ladderDAO里的getLadderById配置
	public Ladder getLadderById(String ladderid);

}

