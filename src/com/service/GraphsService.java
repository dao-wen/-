package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Graphs;

@Service("graphsService")
public interface GraphsService {
	// 插入数据 调用graphsDAO里的insertGraphs配置
	public int insertGraphs(Graphs graphs);

	// 更新数据 调用graphsDAO里的updateGraphs配置
	public int updateGraphs(Graphs graphs);

	// 删除数据 调用graphsDAO里的deleteGraphs配置
	public int deleteGraphs(String graphsid);

	// 查询全部数据 调用graphsDAO里的getAllGraphs配置
	public List<Graphs> getAllGraphs();

	public List<Graphs> getHotGraphs();

	public List<Graphs> getFrontGraphs();

	// 按照Graphs类里面的字段名称精确查询 调用graphsDAO里的getGraphsByCond配置
	public List<Graphs> getGraphsByCond(Graphs graphs);

	// 按照Graphs类里面的字段名称模糊查询 调用graphsDAO里的getGraphsByLike配置
	public List<Graphs> getGraphsByLike(Graphs graphs);

	// 按主键查询表返回单一的Graphs实例 调用graphsDAO里的getGraphsById配置
	public Graphs getGraphsById(String graphsid);

}
