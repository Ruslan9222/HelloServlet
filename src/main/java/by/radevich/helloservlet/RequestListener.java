package by.radevich.helloservlet;

import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {//пишет название всех сервлетов в котрые делаем запрос
        System.out.println("Request: "+((HttpServletRequest) sre.getServletRequest())
                .getRequestURI());
        //ServletRequestListener.super.requestInitialized(sre);
    }
}
