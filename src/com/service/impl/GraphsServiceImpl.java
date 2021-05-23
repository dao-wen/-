package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.GraphsDAO;
import com.entity.Graphs;
import com.service.GraphsService;

@Service("graphsService")
public class GraphsServiceImpl implements GraphsService {
	@Autowired
	private GraphsDAO graphsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertGraphs(Graphs graphs) {
		return this.graphsDAO.insertGraphs(graphs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateGraphs(Graphs graphs) {
		return this.graphsDAO.updateGraphs(graphs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteGraphs(String graphsid) {
		return this.graphsDAO.deleteGraphs(graphsid);
	}

	@Override // 继承接口的查询全部
	public List<Graphs> getAllGraphs() {
		return this.graphsDAO.getAllGraphs();
	}

	@Override // 继承接口的查询全部
	public List<Graphs> getHotGraphs() {
		return this.graphsDAO.getHotGraphs();
	}

	@Override // 继承接口的查询全部
	public List<Graphs> getFrontGraphs() {
		return this.graphsDAO.getFrontGraphs();
	}

	@Override // 继承接口的按条件精确查询
	public List<Graphs> getGraphsByCond(Graphs graphs) {
		return this.graphsDAO.getGraphsByCond(graphs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Graphs> getGraphsByLike(Graphs graphs) {
		return this.graphsDAO.getGraphsByLike(graphs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Graphs getGraphsById(String graphsid) {
		return this.graphsDAO.getGraphsById(graphsid);
	}

}
