package com.example.currierbrother.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * 普通用户的登录过滤：如果访问users下的所有页面，都需要登录之后才能访问
 * 如果没有登录的用户访问，则跳转至登录界面
 * @author liujialiang
 *
 */
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class UserLoginFilter implements Filter{//导入servlet包

	
	public void destroy() {
		
	}
	//判断 用户是否登录
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//获取session 从httpServletRequest 中获取
		HttpSession session=req.getSession();
		// 获取session中 loginUser 对象是否存在
		Object user=(Object)(session.getAttribute("user"));
		//判断loginUser对象是否存在

		// 不过滤的uri
		String[] notFilter = new String[] {"user/index","user/login","solution/vrp","login.html",
				".webp",".jpeg",".jpg",".bmp",".gif",".css",".js","authImg",".png"};

		// 请求的uri
		String uri = req.getRequestURI();
		
		// 是否过滤
		boolean doFilter = true;
		if(uri.equals("/Currierbrother/") || uri.equals("/")){
			chain.doFilter(req, resp);  
			return;
		}
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			if (null == user) {  
                // 如果session中不存在登录者实体，则弹出框提示重新登录  
                // 设置request和response的字符集，防止乱码  
				response.setContentType("text/html; charset=UTF-8"); //转码
			    PrintWriter out = response.getWriter();
			    out.flush();
			    out.println("<script>");
			    out.println("alert('网页已过期，请先登录！');");
			    out.println("window.top.location.href='"+req.getContextPath()+"/user/index';");
			    out.println("</script>");
				out.close();
            } else {  
                // 如果session中存在登录者实体，则继续  
            	chain.doFilter(req, resp);  
            }  
        } else {  
            // 如果不执行过滤，则继续  
        	chain.doFilter(req, resp);  
        } 
	}

	

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
}
