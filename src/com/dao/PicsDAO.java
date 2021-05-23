package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Pics;

@Repository("picsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface PicsDAO {

	/**
* PicsDAO 接口 可以按名称直接调用pics.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包pics.xml里的insertPics配置 返回值0(失败),1(成功)
	public int insertPics(Pics pics);

	// 更新数据 调用entity包pics.xml里的updatePics配置 返回值0(失败),1(成功)
	public int updatePics(Pics pics);

	// 删除数据 调用entity包pics.xml里的deletePics配置 返回值0(失败),1(成功)
	public int deletePics(String picsid);

	// 查询全部数据 调用entity包pics.xml里的getAllPics配置 返回List类型的数据
	public List<Pics> getAllPics();

	// 按照Pics类里面的值精确查询 调用entity包pics.xml里的getPicsByCond配置 返回List类型的数据
	public List<Pics> getPicsByCond(Pics pics);

	// 按照Pics类里面的值模糊查询 调用entity包pics.xml里的getPicsByLike配置 返回List类型的数据
	public List<Pics> getPicsByLike(Pics pics);

	// 按主键查询表返回单一的Pics实例 调用entity包pics.xml里的getPicsById配置
	public Pics getPicsById(String picsid);

}


