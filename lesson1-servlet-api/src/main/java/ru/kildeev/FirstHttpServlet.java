package ru.kildeev;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/httpServlet")
public class FirstHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.setContentType("text/html");
//       resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<h1>Привет с первого HTTP Сервлета </h1>");
    }
}
