package com.QSJ.filter;

import com.QSJ.entity.Admin;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Package: com.QSJ.filter
 * @ClassName: AdminFilter
 * @Author: SamSung
 * @CreateTime: 2020-10-04 21:54
 * @Description:
 */
@Component
@WebFilter(urlPatterns = {"/main.html"} , filterName = "adminFilter")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null){
            response1.sendRedirect("login.html");
        }else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
