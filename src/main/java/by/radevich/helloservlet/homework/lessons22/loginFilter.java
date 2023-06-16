package by.radevich.helloservlet.homework.lessons22;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
@WebFilter
public class loginFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("log")==null){
            servletRequest.getRequestDispatcher("error.jsp")
                    .forward(servletRequest,servletResponse);
        }else {
            servletRequest.getRequestDispatcher("success.jsp");
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
