package com.victer.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class PathFilter
 */
@WebFilter("/*")
public class PathFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletRequest.setAttribute("basePath", PathUtils.getBasePath(httpServletRequest));
		httpServletRequest.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		httpServletResponse.setContentType("text/html;charset=utf-8");
	}
}
