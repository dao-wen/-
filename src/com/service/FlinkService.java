package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Flink;
@Service("flinkService")
public interface FlinkService {
	// 插入数据 调用flinkDAO里的insertFlink配置
	public int insertFlink(Flink flink);

	// 更新数据 调用flinkDAO里的updateFlink配置
	public int updateFlink(Flink flink);

	// 删除数据 调用flinkDAO里的deleteFlink配置
	public int deleteFlink(String flinkid);

	// 查询全部数据 调用flinkDAO里的getAllFlink配置
	public List<Flink> getAllFlink();

	// 按照Flink类里面的字段名称精确查询 调用flinkDAO里的getFlinkByCond配置
	public List<Flink> getFlinkByCond(Flink flink);

	// 按照Flink类里面的字段名称模糊查询 调用flinkDAO里的getFlinkByLike配置
	public List<Flink> getFlinkByLike(Flink flink);

	// 按主键查询表返回单一的Flink实例 调用flinkDAO里的getFlinkById配置
	public Flink getFlinkById(String flinkid);

}

