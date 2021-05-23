package com.victer.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.victer.entity.Teacher;
import com.victer.utils.PageInfo;
import com.victer.utils.PathUtils;

@WebServlet("/sc")
public class SCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void score_submit(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		Integer cId = getIntParameter(request, "cId");
		String[] stuIdArr = request.getParameterValues("stuId");
		String[] scoreArr = request.getParameterValues("score");
		try {
			DaoFactory.getInstance().getScDao().update(stuIdArr, scoreArr, cId);
			response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=cs&cId="+cId+"&msg=1");
		}catch(SQLException e) {
			response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=cs&cId="+cId+"&msg=0");
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void course_student(HttpServletRequest request , HttpServletResponse response) {
		Integer cId = getIntParameter(request, "cId");
		try {
			List<Student> list = DaoFactory.getInstance().getScDao().listStudentByCId(cId);
			request.setAttribute("list", list);
			request.setAttribute("cId", cId);
			request.getRequestDispatcher("page/sc/course_student.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ServletException e) {
			e.printStackTrace();
		}
	}
	
	private void teacher_course(HttpServletRequest request , HttpServletResponse response) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		Integer pageNo = getIntParameter(request, "pageNo");
		Course course = new Course();
		course.setTeacher(teacher);
		PageInfo<Course> pageInfo = new PageInfo<>(pageNo);
		try {
			pageInfo = DaoFactory.getInstance().getCourseDao().list(course, pageInfo);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("page/sc/teacher_course.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		catch(ServletException e) {
			e.printStackTrace();
		}
	}
	
	private void submit(HttpServletRequest request , HttpServletResponse response) {
		String[] cIds = request.getParameterValues("cId");
		List<Integer> cIdArray = new ArrayList<Integer>();
		for(String string : cIds) {
			cIdArray.add(Integer.parseInt(string));
		}
		Student student = (Student) request.getSession().getAttribute("user");
		try {
			int [] arr = DaoFactory.getInstance().getScDao().add(cIdArray, student.getStuId());
			if(arr.length == 0) {
				response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=select&msg=0");
			}else {
				response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=select&msg=1");				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void select(HttpServletRequest request , HttpServletResponse response) {
		PageInfo<Course> info = new PageInfo<>(1);
		info.setPageSize(1000);
		try {
			info = DaoFactory.getInstance().getCourseDao().list(null, info);
			Student student = (Student) request.getSession().getAttribute("user");
			List<Sc> list = DaoFactory.getInstance().getScDao().listByStuId(student.getStuId());
			request.setAttribute("scs", list);
			request.setAttribute("course", info.getList());
			request.getRequestDispatcher("page/sc/select.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(ServletException e) {
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
