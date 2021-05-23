package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LadderDAO;
import com.entity.Ladder;
import com.service.LadderService;

@Service("ladderService")
public class LadderServiceImpl implements LadderService {
	@Autowired
	private LadderDAO ladderDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertLadder(Ladder ladder) {
		return this.ladderDAO.insertLadder(ladder);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateLadder(Ladder ladder) {
		return this.ladderDAO.updateLadder(ladder);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteLadder(String ladderid) {
		return this.ladderDAO.deleteLadder(ladderid);
	}

	@Override // 继承接口的查询全部
	public List<Ladder> getAllLadder() {
		return this.ladderDAO.getAllLadder();
	}

	@Override // 继承接口的按条件精确查询
	public List<Ladder> getLadderByCond(Ladder ladder) {
		return this.ladderDAO.getLadderByCond(ladder);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Ladder> getLadderByLike(Ladder ladder) {
		return this.ladderDAO.getLadderByLike(ladder);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Ladder getLadderById(String ladderid) {
		return this.ladderDAO.getLadderById(ladderid);
	}

}

