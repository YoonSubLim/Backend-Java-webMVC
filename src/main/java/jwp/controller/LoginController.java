package jwp.controller;


import core.db.MemoryUserRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jwp.model.User;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();
        User user = memoryUserRepository.findUserById(req.getParameter("userId"));

        if (user.matchPassword(req.getParameter("password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }

        resp.sendRedirect("/");
    }
}
