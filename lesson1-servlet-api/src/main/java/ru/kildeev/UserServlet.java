package ru.kildeev;

import ru.kildeev.persist.User;
import ru.kildeev.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet{

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepository();
        this.userRepository.insert(new User("Vladimir"));
        this.userRepository.insert(new User("Anastasia"));
        this.userRepository.insert(new User("Sergey"));


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>id</td>");
        writer.println("<td>name</td>");
        writer.println("</tr>");

        for (User user : userRepository.findAll()) {
            writer.println("<tr>");
            writer.println("<td>" + user.getId() + "</td>");
            writer.println("<td>"+ user.getName() +"</td>");
            writer.println("</tr>");

        }
    }
}
