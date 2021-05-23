package com.victer.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.victer.dao.DaoFactory;
import com.victer.entity.Teacher;

@WebServlet("/scquery")
public class SCQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("query_range".equals(method)) {
			this.query_range(request, response);
		}
		else if("query_jgl".equals(method)) {
			this.query_jgl(request, response);
		}
		else if("query_teacher".equals(method)) {
			this.query_teacher(request, response);
		}
	}
	
	public void query_teacher(HttpServletRequest request, HttpServletResponse response) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		try {
			List<Map<String , Object>> list = DaoFactory.getInstance().getScDao().query_rangByTid(teacher.gettId());
			request.setAttribute("list1", list);
			List<Map<String , Object>> list2 = DaoFactory.getInstance().getScDao().query_jglByTid(teacher.gettId());
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("page/sc/query_teacher.jsp").forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}catch(ServletException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void query_range(HttpServletRequest request , HttpServletResponse response) {
		try {
			
		List<Map<String, Object>> list = DaoFactory.getInstance().getScDao().query_range();
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/sc/query_range.jsp").forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}catch(ServletException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void query_jgl(HttpServletRequest request , HttpServletResponse response) {
		try {
			List<Map<String, Object>> list = DaoFactory.getInstance().getScDao().query_jgl();
			request.setAttribute("list", list);
			request.getRequestDispatcher("page/sc/query_jgl.jsp").forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}catch(ServletException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
