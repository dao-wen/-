package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PicsDAO;
import com.entity.Pics;
import com.service.PicsService;

@Service("picsService")
public class PicsServiceImpl implements PicsService {
	@Autowired
	private PicsDAO picsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertPics(Pics pics) {
		return this.picsDAO.insertPics(pics);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updatePics(Pics pics) {
		return this.picsDAO.updatePics(pics);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deletePics(String picsid) {
		return this.picsDAO.deletePics(picsid);
	}

	@Override // 继承接口的查询全部
	public List<Pics> getAllPics() {
		return this.picsDAO.getAllPics();
	}

	@Override // 继承接口的按条件精确查询
	public List<Pics> getPicsByCond(Pics pics) {
		return this.picsDAO.getPicsByCond(pics);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Pics> getPicsByLike(Pics pics) {
		return this.picsDAO.getPicsByLike(pics);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Pics getPicsById(String picsid) {
		return this.picsDAO.getPicsById(picsid);
	}

}

