package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Graphs;

@Repository("graphsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface GraphsDAO {

	/**
	 * GraphsDAO 接口 可以按名称直接调用graphs.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包graphs.xml里的insertGraphs配置 返回值0(失败),1(成功)
	public int insertGraphs(Graphs graphs);

	// 更新数据 调用entity包graphs.xml里的updateGraphs配置 返回值0(失败),1(成功)
	public int updateGraphs(Graphs graphs);

	// 删除数据 调用entity包graphs.xml里的deleteGraphs配置 返回值0(失败),1(成功)
	public int deleteGraphs(String graphsid);

	// 查询全部数据 调用entity包graphs.xml里的getAllGraphs配置 返回List类型的数据
	public List<Graphs> getAllGraphs();

	public List<Graphs> getHotGraphs();

	public List<Graphs> getFrontGraphs();

	// 按照Graphs类里面的值精确查询 调用entity包graphs.xml里的getGraphsByCond配置 返回List类型的数据
	public List<Graphs> getGraphsByCond(Graphs graphs);

	// 按照Graphs类里面的值模糊查询 调用entity包graphs.xml里的getGraphsByLike配置 返回List类型的数据
	public List<Graphs> getGraphsByLike(Graphs graphs);

	// 按主键查询表返回单一的Graphs实例 调用entity包graphs.xml里的getGraphsById配置
	public Graphs getGraphsById(String graphsid);

}
