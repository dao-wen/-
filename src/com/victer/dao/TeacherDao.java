package com.victer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import com.victer.entity.Teacher;
import com.victer.utils.PageInfo;
import com.victer.utils.PropertiesUtils;

public class TeacherDao {
	public void add(Teacher teacher) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into teacher(tname , userName , pwd ) values(?,?,?)";
		queryRunner.update(sql, teacher.gettName() , teacher.getUserName() , teacher.getPwd());
	}

	public void delete(Integer tid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from teacher where id = ?";
		queryRunner.update(sql, tid);
	}

	public void update(Teacher teacher) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update teacher set tName = ? , username = ? where tid = ?";
		queryRunner.update(sql, teacher.gettName() , teacher.getUserName() , teacher.gettId());
	}

	public void update(String pwd , Integer stuId) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update teacher set pwd = ? where stuId = ?";
		queryRunner.update(sql, pwd , stuId);
	}
	
	public PageInfo<Teacher> list(Teacher teacher , PageInfo<Teacher> pageInfo) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if(teacher != null && teacher.gettId() != null) {
			sql += " and TID = ?";
			list.add(teacher.gettId());
		}
		if(teacher != null && StringUtils.isNoneBlank(teacher.gettName())) {
			sql += " and tname like ?";
			list.add("%"+teacher.gettName()+"%");
		}
		if(teacher != null && StringUtils.isNoneBlank(teacher.getUserName())) {
			sql += " and username like ?";
			list.add("%"+teacher.getUserName()+"%");
		}
		Object[] arr = new Object[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr[i] = list.get(i);
		}
		String sql1 = "select * from teacher where 1=1"
				+ sql+" limit "+(pageInfo.getPageNo() - 1) * pageInfo.getPageSize() +" , "+pageInfo.getPageSize();
		List<Teacher> list1 = queryRunner.query(sql1, new BeanListHandler<>(Teacher.class), arr);
		pageInfo.setList(list1);
		pageInfo.setTotalCount(this.count(teacher));
		return pageInfo;
		
	}
	
	public Long count(Teacher teacher) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if(teacher != null && teacher.gettId() != null) {
			sql += " and TID = ?";
			list.add(teacher.gettId());
		}
		if(teacher != null && StringUtils.isNoneBlank(teacher.gettName())) {
			sql += " and tname like ?";
			list.add("%"+teacher.gettName()+"%");
		}
		if(teacher != null && StringUtils.isNoneBlank(teacher.getUserName())) {
			sql += " and username like ?";
			list.add("%"+teacher.getUserName()+"%");
		}
		
		Object[] arr = new Object[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr[i] = list.get(i);
		}
		String sql1 = "select count(*) from teacher where 1=1" + sql;
		Long count = (Long) queryRunner.query(sql1, new ScalarHandler(), arr);
		return count;
	}
	
	public Teacher findById(Integer tid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from teacher where tid = ?";
		Teacher teacher = queryRunner.query(sql, new BeanHandler<>(Teacher.class), tid);
		return teacher;
	}

	public Teacher login(String userName , String pwd) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from teacher where username = ? and pwd = ?";
		Teacher teacher = queryRunner.query(sql, new BeanHandler<>(Teacher.class), userName , pwd);
		return teacher;
	}

}
