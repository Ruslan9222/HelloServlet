package by.radevich.helloservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class HelloFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String firstValue = request.getServletContext()
                .getInitParameter("first");//хотим достать параметр
        System.out.println("My first valur: " + firstValue);// достаем из хмл параметр first, пишется в логах!!
        System.out.println("This is my hello filter!!!");
        if (request.getParameter("name") == null) {
            request.getRequestDispatcher("error.jsp")//перенаправить если имени нету
                    .forward(request, response);
        } else {
            System.out.println("Hello, " + request.getParameter("name"));//если есть пускаем дальше
            chain.doFilter(request, response);
        }
    }
}
