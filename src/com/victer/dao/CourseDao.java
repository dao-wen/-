package com.victer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import com.victer.entity.Course;
import com.victer.entity.Teacher;
import com.victer.utils.PageInfo;
import com.victer.utils.PropertiesUtils;

public class CourseDao {
	
	public void add(Course course) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into course(cname , tid) values(? , ?)";
		queryRunner.update(sql, course.getcName() , course.getTeacher().gettId());
	}

	public void delete(Integer cid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from course where cid = ?";
		queryRunner.update(sql, cid);
	}

	public void update(Course course) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update course set cname = ? , tid = ? where cid = ?";
		queryRunner.update(sql, course.getcName() , course.getTeacher().gettId() , course.getcId());
	}
	public PageInfo<Course> list(Course course, PageInfo<Course> pageInfo) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if(course != null && course.getcId() != null) {
			sql += " and CID = ?";
			list.add(course.getcId());
		}
		if(course != null && StringUtils.isNoneBlank(course.getcName())) {
			sql += " and cname like ?";
			list.add("%"+course.getcName()+"%");
		}
		if(course != null && StringUtils.isNoneBlank(course.getTeacher().gettName())) {
			sql += " and tname like ?";
			list.add("%"+course.getTeacher().gettName()+"%");
		}
		if(course != null && StringUtils.isNoneBlank(course.getTeacher().getUserName())) {
			sql += " and username like ?";
			list.add("%"+course.getTeacher().getUserName()+"%");
		}
		if(course != null && course.getTeacher().gettId() != null) {
			sql += " and course.tid like ?";
			list.add(course.getTeacher().gettId());
		}
		
		Object[] arr = new Object[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr[i] = list.get(i);
		}
		
		String sql1 = "select course.* , teacher.tname , teacher.userName from course , teacher where course.tid = teacher.tId "
				+ sql+" limit " + (pageInfo.getPageNo() - 1) * pageInfo.getPageSize() + " , "
				+pageInfo.getPageSize();
		List<Map<String , Object>> mapList = queryRunner.query(sql1, new MapListHandler(), arr);
		List<Course> list1 = new ArrayList<>();
		for(Map<?, ?> map : mapList) {
			Course entity = new Course();
			entity.setcId(Integer.parseInt(map.get("cId")+""));
			entity.setcName(map.get("cName")+"");
			Teacher teacher = new Teacher();
			teacher.settId(Integer.parseInt(map.get("tId")+""));
			teacher.settName(map.get("tName")+"");
			teacher.setUserName(map.get("userName")+"");
			entity.setTeacher(teacher);
			list1.add(course);
		}
		pageInfo.setList(list1);
		pageInfo.setTotalCount(this.count(course));
		return pageInfo;
	}
	
	public Long count(Course course) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if(course != null && course.getcId() != null) {
			sql += " and CID = ?";
			list.add(course.getcId());
		}
		if(course != null && StringUtils.isNoneBlank(course.getcName())) {
			sql += " and cname like ?";
			list.add("%"+course.getcName()+"%");
		}
		if(course != null && course.getTeacher().gettName() != null) {
			sql += " and tname = ?";
			list.add(course.getTeacher().gettName());
		}
		if(course != null && course.getTeacher().gettId() != null) {
			sql += " and course.tid = ?";
			list.add(course.getTeacher().gettId());
		}
		Object[] arr = new Object[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr[i] = list.get(i);
		}
		String sql1 = "select count(*) from course,teacher where course.tid = teacher.tId" + sql;
		Long count = (Long) queryRunner.query(sql1, new ScalarHandler(), arr);
		return count;
	}
	
	public Course findById(Integer cid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from course where cid = ?";
		Map<String , Object> map = queryRunner.query(sql, new MapHandler(), cid);
		Course course = new Course();
		course.setcId(Integer.parseInt(map.get("cId")+""));
		course.setcName(map.get("cName")+"");
		
		Integer tid = Integer.parseInt(map.get("tId")+"");
		Teacher teacher = DaoFactory.getInstance().getTeacherDao().findById(tid);
		course.setTeacher(teacher);
		return course;
	}
}
