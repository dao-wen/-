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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Map<String , Object>> list = DaoFactory.getInstance().getScDao().query_jgl();
			request.setAttribute("list", list);
			List<Map<String , Object>> top5List = DaoFactory.getInstance().getScDao().top5();
			request.setAttribute("top5List", top5List);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
