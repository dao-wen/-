package com.victer.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.victer.dao.DaoFactory;
import com.victer.entity.Course;
import com.victer.entity.Sc;
import com.victer.entity.Student;
import com.victer.utils.PageInfo;
import com.victer.utils.PathUtils;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
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
		}else if("edit".equals(method)){
			this.findById(request, response);
		}
		else if("editsubmit".equals(method)){
			this.editsubmit(request, response);
		}
		else if("delete".equals(method)){
			this.delete(request, response);
		}
		else if("detail".equals(method)){
			this.detail(request, response);
		}
	}
	
	private void delete(HttpServletRequest request , HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			DaoFactory.getInstance().getStudentDao().delete(Integer.parseInt(id));
			response.sendRedirect(PathUtils.getBasePath(request)+"student?method=list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	  
	private void editsubmit(HttpServletRequest request , HttpServletResponse response) {
		Integer stuId = Integer.parseInt(request.getParameter("stuId"));
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		Student student = new Student();
		student.setStuName(stuName);
		student.setStuNo(stuNo);
		student.setStuId(stuId);
		try {
			DaoFactory.getInstance().getStudentDao().update(student);
			response.sendRedirect(PathUtils.getBasePath(request)+"student?method=list");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void findById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			Student student = DaoFactory.getInstance().getStudentDao().findById(Integer.parseInt(id));
			request.setAttribute("student", student);
			request.getRequestDispatcher("page/student/update.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void detail(HttpServletRequest request , HttpServletResponse response) {
		Student student = (Student) request.getSession().getAttribute("user");
		try {
			Student student1 = DaoFactory.getInstance().getStudentDao().findById(student.getStuId());
			List<Sc> list = DaoFactory.getInstance().getScDao().listByStuId(student1.getStuId());
			request.setAttribute("student", student);
			for(Sc sc:list) {
				Course c = DaoFactory.getInstance().getCourseDao().findById(sc.getcId());
				sc.setcName(c.getcName());
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("page/student/detail.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void add(HttpServletRequest request , HttpServletResponse response) {
		String stuNo = request.getParameter("stuNO");
		String stuName = request.getParameter("stuName");
		String stuPwd = request.getParameter("stuPwd");
		Student student = new Student();
		student.setStuName(stuName);
		student.setStuNo(stuNo);
		student.setStuPwd(stuPwd);
		try {
			DaoFactory.getInstance().getStudentDao().add(student);
			response.sendRedirect(PathUtils.getBasePath(request)+"student?method=list");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void list(HttpServletRequest request , HttpServletResponse response) {
		Integer pageNoInteger = getIntParameter(request, "pageNo");
		Integer stuId = getIntParameter(request , "stuId");
		String stuName = request.getParameter("stuName");
		String stuNo = request.getParameter("stuNo");
		
		Student student = new Student();
		student.setStuId(stuId);
		student.setStuName(stuName);
		student.setStuNo(stuNo);
		
		PageInfo<Student> pageInfo = new PageInfo<>(pageNoInteger);
		try {
			pageInfo = DaoFactory.getInstance().getStudentDao().list(student, pageInfo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("student", student);
			request.getRequestDispatcher("page/student/list.jsp").forward(request, response);
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
