package com.esinav.filter;

/**
 * Created by myavuz on 26.04.2014.
 */
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginPageFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,   FilterChain filterChain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getUserPrincipal() != null){ //If user is already authenticated
            String navigateString = "";
            if(request.isUserInRole("admin")){
                navigateString = "/admin/adminHome.xhtml";
            }else if(request.isUserInRole("teacher")){
                navigateString = "/teacher/teacherHome.xhtml";
            }else if(request.isUserInRole("student")){
                navigateString = "/student/studentHome.xhtml";
            }
            response.sendRedirect(request.getContextPath()+navigateString);
        } else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy(){
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }
}