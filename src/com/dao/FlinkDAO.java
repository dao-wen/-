package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Flink;

@Repository("flinkDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface FlinkDAO {

	/**
* FlinkDAO 接口 可以按名称直接调用flink.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包flink.xml里的insertFlink配置 返回值0(失败),1(成功)
	public int insertFlink(Flink flink);

	// 更新数据 调用entity包flink.xml里的updateFlink配置 返回值0(失败),1(成功)
	public int updateFlink(Flink flink);

	// 删除数据 调用entity包flink.xml里的deleteFlink配置 返回值0(失败),1(成功)
	public int deleteFlink(String flinkid);

	// 查询全部数据 调用entity包flink.xml里的getAllFlink配置 返回List类型的数据
	public List<Flink> getAllFlink();

	// 按照Flink类里面的值精确查询 调用entity包flink.xml里的getFlinkByCond配置 返回List类型的数据
	public List<Flink> getFlinkByCond(Flink flink);

	// 按照Flink类里面的值模糊查询 调用entity包flink.xml里的getFlinkByLike配置 返回List类型的数据
	public List<Flink> getFlinkByLike(Flink flink);

	// 按主键查询表返回单一的Flink实例 调用entity包flink.xml里的getFlinkById配置
	public Flink getFlinkById(String flinkid);

}


