package com.victer.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.victer.dao.DaoFactory;

/**
 * Servlet implementation class PwdServlet
 */
@WebServlet("/pwd")
public class PwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd");
		String newPwd2 = request.getParameter("newPwd2");
		if(!newPwd.equals(newPwd2)) {
			request.setAttribute("msg", "两次密码不一致");
			request.getRequestDispatcher("pwd.jsp").forward(request, response);
		}else {
			try {
				if("0".equals(type)) {
					DaoFactory.getInstance().getStudentDao().update(newPwd, id);
				}
				if("1".equals(type)) {
					DaoFactory.getInstance().getTeacherDao().update(newPwd, id);;
				}
				if("2".equals(type)) {
					DaoFactory.getInstance().getAdminDao().update(newPwd, id);
				}
				request.setAttribute("msg", "修改成功");
				request.getRequestDispatcher("pwd.jsp").forward(request, response);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
