package jwp.controller;

import core.db.MemoryUserRepository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jwp.model.User;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

        User user = memoryUserRepository.findUserById(req.getParameter("userId"));

        if (user == null) {
            resp.sendRedirect("/");
            return;
        }

        req.setAttribute("user", user);

        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req,resp);
    }
}
