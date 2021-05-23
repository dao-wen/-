package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Pics;
@Service("picsService")
public interface PicsService {
	// 插入数据 调用picsDAO里的insertPics配置
	public int insertPics(Pics pics);

	// 更新数据 调用picsDAO里的updatePics配置
	public int updatePics(Pics pics);

	// 删除数据 调用picsDAO里的deletePics配置
	public int deletePics(String picsid);

	// 查询全部数据 调用picsDAO里的getAllPics配置
	public List<Pics> getAllPics();

	// 按照Pics类里面的字段名称精确查询 调用picsDAO里的getPicsByCond配置
	public List<Pics> getPicsByCond(Pics pics);

	// 按照Pics类里面的字段名称模糊查询 调用picsDAO里的getPicsByLike配置
	public List<Pics> getPicsByLike(Pics pics);

	// 按主键查询表返回单一的Pics实例 调用picsDAO里的getPicsById配置
	public Pics getPicsById(String picsid);

}

