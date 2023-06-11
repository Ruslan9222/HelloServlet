package by.radevich.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

@WebServlet(value = "/hi/*")//анотация// после 2 слэш можно указать любои число или строку
public class MySecondServlet extends HttpServlet {
    private int counter;
    @Override
    public void init() throws ServletException {
        counter = 100;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet path: " + req.getServletPath());//путь
        System.out.println("servlet URL: " + req.getRequestURI());//путь полный
        System.out.println("Parametr: " + req.getParameter("my"));
        //ищем парпметр в ссылке пишем вопрос потом abc?my123&another=empty
        HttpSession session = req.getSession();//создаем сессию
        Integer currentParam = (Integer) session.getAttribute("count");
        System.out.println("Current param: " + currentParam);
        if (currentParam == null) {
            currentParam = counter;//аналог корзины сколко раз один члиент заходит на страницу
        }
        session.setAttribute("count", currentParam + 1);
        System.out.println("Haders; " + req.getHeaderNames());
        PrintWriter writer = resp.getWriter();//запиши в ответ клиенту
        writer.println("this is my second responce" + ".Current param " + currentParam);//на саите
        Iterator<String> headersIterator = req.getHeaderNames().asIterator();
        while (headersIterator.hasNext()) {
            writer.println("\nHeaders: " + req.getHeaderNames());
        }
        writer.println("\nHost: " + req.getHeader("host"));//посмотреть хедер хост
        resp.setHeader("myHeader", "abra cadabra");//хедер отправляется и возращается обратно
        writer.println("\nCookies " + Arrays.asList(req.getCookies())
                .stream()
                .map(cookie -> cookie.getName() + " " + cookie.getValue() + " " + cookie.getMaxAge())
                .collect(Collectors.toList()));//храниться в браузере например саит сохраняет корзину покупок
        resp.sendRedirect("/here");//перенаправляем
        if(currentParam>105){
            resp.sendRedirect("/here");//перенаправляем на другую страницу
            Person person = new Person();

            //resp.setStatus(500);
            //resp.sendError(500,"To much");//вывод ошибки
        }
    }
}
