package com.victer.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.victer.dao.DaoFactory;
import com.victer.entity.Course;
import com.victer.entity.Teacher;
import com.victer.utils.PageInfo;
import com.victer.utils.PathUtils;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)) {
			this.list(request, response);
		}else if("add".equals(method)) {
			this.add(request, response);
		}else if("v_add".equals(method)){
			this.v_add(request, response);
		}
		else if("edit".equals(method)){
			this.findById(request, response);
		}
		else if("editsubmit".equals(method)){
			this.editsubmit(request, response);
		}
		else if("delete".equals(method)){
			this.delete(request, response);
		}
	}
	
	private void delete(HttpServletRequest request , HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			DaoFactory.getInstance().getCourseDao().delete(Integer.parseInt(id));
			response.sendRedirect(PathUtils.getBasePath(request)+"course?method=list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void editsubmit(HttpServletRequest request , HttpServletResponse response) {
		Integer cId = Integer.parseInt(request.getParameter("cId"));
		String cName = request.getParameter("cName");
		
		Integer tId = Integer.parseInt(request.getParameter("tId"));
		Course course = new Course();
		course.setcId(cId);
		course.setcName(cName);
		
		Teacher teacher = new Teacher();
		teacher.settId(tId);
		
		course.setTeacher(teacher);
		try {
			DaoFactory.getInstance().getCourseDao().update(course);
			response.sendRedirect(PathUtils.getBasePath(request)+"course?method=list");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void findById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		PageInfo<Teacher> pageInfo = new PageInfo<>(1);
		pageInfo.setPageSize(1000);
		try {
			Course course = DaoFactory.getInstance().getCourseDao().findById(Integer.parseInt(id));
			pageInfo = DaoFactory.getInstance().getTeacherDao().list(null, pageInfo);
			request.setAttribute("course", course);
			request.getRequestDispatcher("page/course/update.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void v_add(HttpServletRequest request , HttpServletResponse response) {
		PageInfo<Teacher> pageInfo = new PageInfo<>(1);
		pageInfo.setPageSize(1000);
		try {
			pageInfo = DaoFactory.getInstance().getTeacherDao().list(null, pageInfo);
			request.setAttribute("teachers", pageInfo.getList());
			request.getRequestDispatcher("page/course/add.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(ServletException e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request , HttpServletResponse response) {
		String cName = request.getParameter("cName");
		
		Integer tId = Integer.parseInt(request.getParameter("tId"));
		Course course = new Course();
		course.setcName(cName);
		
		Teacher teacher = new Teacher();
		teacher.settId(tId);
		course.setTeacher(teacher);
		try {
			DaoFactory.getInstance().getCourseDao().add(course);
			response.sendRedirect(PathUtils.getBasePath(request)+"course?method=list");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void list(HttpServletRequest request , HttpServletResponse response) {
		Integer pageNoInteger = getIntParameter(request, "pageNo");
		Integer cId = getIntParameter(request , "cId");
		String cName = request.getParameter("cName");
		String tName = request.getParameter("tName");
		String userName = request.getParameter("userName");
		
		Course course = new Course();
		course.setcId(cId);
		course.setcName(cName);
		
		Teacher teacher = new Teacher();
		teacher.setUserName(userName);
		teacher.settName(tName);
		course.setTeacher(teacher);
		
		
		PageInfo<Course> pageInfo = new PageInfo<>(pageNoInteger);
		try {
			pageInfo = DaoFactory.getInstance().getCourseDao().list(course, pageInfo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("course", course);
			request.getRequestDispatcher("page/course/list.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Integer getIntParameter(HttpServletRequest request , String name) {
		if(StringUtils.isNoneBlank(request.getParameter(name))) {
			return Integer.parseInt(request.getParameter(name));
		}else {
			return null;
		}
	}
}
