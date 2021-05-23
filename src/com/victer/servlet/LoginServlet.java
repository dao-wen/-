package com.victer.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.victer.dao.DaoFactory;
import com.victer.entity.Admin;
import com.victer.entity.Student;
import com.victer.entity.Teacher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) || StringUtils.isBlank(type)) {
			request.setAttribute("error", "录入信息不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return ;
		}
		HttpSession session = request.getSession();
		if(StringUtils.isNotBlank(type)) {
			try {
				if("0".equals(type)) {
					Student student = DaoFactory.getInstance().getStudentDao().login(userName, password);
					if(student != null) {
						session.setAttribute("user", student);
						session.setAttribute("type", type);
						response.sendRedirect("index.jsp");
					}else {
						request.setAttribute("error", "用户名或密码错误!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}else if("1".equals(type)) {
					Teacher teacher = DaoFactory.getInstance().getTeacherDao().login(userName, password);
					if(teacher != null) {
						session.setAttribute("user", teacher);
						session.setAttribute("type", type);
						response.sendRedirect("index.jsp");
					}else {
						request.setAttribute("error", "用户名或密码错误!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					
				}else {
					Admin admin = new Admin();
					admin.setUserName(userName);
					admin.setPwd(password);
					Admin entity = DaoFactory.getInstance().getAdminDao().login(admin);
					if(entity != null) {
						session.setAttribute("user", entity);
						session.setAttribute("type", type);
						response.sendRedirect("index.jsp");
					}else {
						request.setAttribute("error", "用户名或密码错误!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		
	}

}
