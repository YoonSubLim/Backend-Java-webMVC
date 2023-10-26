package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import jwp.model.User;

@WebServlet("/user/list")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());

        HttpSession session = req.getSession();
        Object userSession = session.getAttribute("user");

        if (userSession == null) {
            resp.sendRedirect("/");
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
        rd.forward(req,resp);
    }
}
