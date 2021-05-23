package com.victer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import com.victer.entity.Student;
import com.victer.utils.PageInfo;
import com.victer.utils.PropertiesUtils;

public class StudentDao {
	public void add(Student student) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "insert into student(stuname , stuno , stupwd ) values(?,?,?)";
		queryRunner.update(sql, student.getStuName() , student.getStuNo() , student.getStuPwd());
	}

	public void delete(Integer stuId) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "delete from student where stuId = ?";
		queryRunner.update(sql, stuId);
	}

	public void update(Student student) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update student set stuName = ? , stuNo = ? where stuId = ?";
		queryRunner.update(sql, student.getStuName() , student.getStuNo() , student.getStuId());
	}
	
	public PageInfo<Student> list(Student student , PageInfo<Student> pageInfo) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if( student.getStuId() != null) {
			sql += " and STUID = ?";
			list.add(student.getStuId());
		}
		if( StringUtils.isNoneBlank(student.getStuName())) {
			sql += " and stuname like ?";
			list.add("%"+student.getStuName()+"%");
		}
		if( StringUtils.isNoneBlank(student.getStuNo())) {
			sql += " and stuno like ?";
			list.add("%"+student.getStuNo()+"%");
		}
		Object[] arr = new Object[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr[i] = list.get(i);
		}
		String sql1 = "select * from student where 1=1"
				+ sql+" limit "+(pageInfo.getPageNo() - 1) * pageInfo.getPageSize() +" , "+pageInfo.getPageSize();
		List<Student> list1 = queryRunner.query(sql1, new BeanListHandler<>(Student.class), arr);
		pageInfo.setList(list1);
		pageInfo.setTotalCount(this.count(student));
		return pageInfo;
		
	}
	
	public Long count(Student student) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if(student.getStuId() != null) {
			sql += " and STUID = ?";
			list.add(student.getStuId());
		}
		if( StringUtils.isNoneBlank(student.getStuName())) {
			sql += " and stuname like ?";
			list.add("%"+student.getStuName()+"%");
		}
		if( StringUtils.isNoneBlank(student.getStuNo())) {
			sql += " and stuno like ?";
			list.add("%"+student.getStuNo()+"%");
		}
		
		Object[] arr = new Object[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr[i] = list.get(i);
		}
		String sql1 = "select count(*) from student where 1=1" + sql;
		Long count = (Long) queryRunner.query(sql1, new ScalarHandler(), arr);
		return count;
	}
	
	public Student findById(Integer sId) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from student where stuid = ?";
		Student student = queryRunner.query(sql, new BeanHandler<>(Student.class), sId);
		return student;
	}

	public Student login(String stuNo , String stuPwd) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "select * from student where stuNo = ? and stuPwd = ?";
		Student student = queryRunner.query(sql, new BeanHandler<>(Student.class), stuNo , stuPwd);
		return student;
	}

	public void update(String pwd , Integer stuId) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
		String sql = "update student set stuPwd = ? where stuId = ?";
		queryRunner.update(sql, pwd , stuId);
	}
}
