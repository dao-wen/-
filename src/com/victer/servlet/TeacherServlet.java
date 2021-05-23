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
import com.victer.entity.Teacher;
import com.victer.utils.PageInfo;
import com.victer.utils.PathUtils;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
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
	}
	
	private void delete(HttpServletRequest request , HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			DaoFactory.getInstance().getTeacherDao().delete(Integer.parseInt(id));
			response.sendRedirect(PathUtils.getBasePath(request)+"teacher?method=list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void editsubmit(HttpServletRequest request , HttpServletResponse response) {
		Integer tId = Integer.parseInt(request.getParameter("tId"));
		String tName = request.getParameter("tName");
		String userName = request.getParameter("userName");
		Teacher teacher = new Teacher();
		teacher.settId(tId);
		teacher.settName(tName);
		teacher.setUserName(userName);
		try {
			DaoFactory.getInstance().getTeacherDao().update(teacher);
			response.sendRedirect(PathUtils.getBasePath(request)+"teacher?method=list");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void findById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			Teacher teacher = DaoFactory.getInstance().getTeacherDao().findById(Integer.parseInt(id));
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("page/teacher/update.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void add(HttpServletRequest request , HttpServletResponse response) {
		String tName = request.getParameter("tName");
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		Teacher teacher = new Teacher();
		teacher.setUserName(userName);
		teacher.settName(tName);
		teacher.setPwd(pwd);
		try {
			DaoFactory.getInstance().getTeacherDao().add(teacher);
			response.sendRedirect(PathUtils.getBasePath(request)+"teacher?method=list");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void list(HttpServletRequest request , HttpServletResponse response) {
		Integer pageNoInteger = getIntParameter(request, "pageNo");
		Integer tId = getIntParameter(request , "tId");
		String tName = request.getParameter("tName");
		String userName = request.getParameter("userName");
		
		Teacher teacher = new Teacher();
		teacher.setUserName(userName);
		teacher.settName(tName);
		teacher.settId(tId);
		
		PageInfo<Teacher> pageInfo = new PageInfo<>(pageNoInteger);
		try {
			pageInfo = DaoFactory.getInstance().getTeacherDao().list(teacher, pageInfo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("page/teacher/list.jsp").forward(request, response);
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
