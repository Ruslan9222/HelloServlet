package by.radevich.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is my here servlet");//сначала отрабатывает фильтр а потом сервлет
        PrintWriter writer = resp.getWriter();//запиши в ответ клиенту
        writer.println("this is my responce");
    }
}
