package jwp.controller;

import core.db.MemoryUserRepository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        // 요구사항 5 : 자신의 정보만 수정 가능하게 하기.
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value == null) {
            resp.sendRedirect("/");
            return;
        }

        if (!user.isSameUser((User) value)) {
            resp.sendRedirect("/");
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req,resp);
    }
}
