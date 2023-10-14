package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        return "redirect:/user/loginForm";
    }
}
