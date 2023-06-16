package by.radevich.helloservlet.homework.lessons22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet()
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getInitParameter("log");
        getServletContext().getInitParameter("pass");
        System.out.println("login "+ getServletContext().getInitParameter("log"));
        System.out.println("password "+ getServletContext().getInitParameter("pass"));

    }
}
