package jwp.controller;

import core.db.MemoryUserRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jwp.model.User;

@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        User updateUser = new User(userId, password, name, email);
        User user = memoryUserRepository.findUserById(userId);

        user.update(updateUser);

        memoryUserRepository.changeUserInfo(user);

        resp.sendRedirect("/user/list");
    }
}
