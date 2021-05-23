package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.FlinkDAO;
import com.entity.Flink;
import com.service.FlinkService;

@Service("flinkService")
public class FlinkServiceImpl implements FlinkService {
	@Autowired
	private FlinkDAO flinkDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertFlink(Flink flink) {
		return this.flinkDAO.insertFlink(flink);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateFlink(Flink flink) {
		return this.flinkDAO.updateFlink(flink);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteFlink(String flinkid) {
		return this.flinkDAO.deleteFlink(flinkid);
	}

	@Override // 继承接口的查询全部
	public List<Flink> getAllFlink() {
		return this.flinkDAO.getAllFlink();
	}

	@Override // 继承接口的按条件精确查询
	public List<Flink> getFlinkByCond(Flink flink) {
		return this.flinkDAO.getFlinkByCond(flink);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Flink> getFlinkByLike(Flink flink) {
		return this.flinkDAO.getFlinkByLike(flink);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Flink getFlinkById(String flinkid) {
		return this.flinkDAO.getFlinkById(flinkid);
	}

}

