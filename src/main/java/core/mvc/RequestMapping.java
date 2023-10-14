package core.mvc;

import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private Map<String , Controller> controllers = new HashMap<>();

    public RequestMapping() {
        initControllers();
    }

    private void initControllers() {
        controllers.put("/", new HomeController());

        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));
        controllers.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controllers.put("/qna/show", new ForwardController("/qna/show.jsp"));


        controllers.put("/user/list", new ListUserController());

        controllers.put("/user/login", new LogInController());
        controllers.put("/user/logout", new LogOutController());

        controllers.put("/user/signup", new CreateUserController());

        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("/user/update", new UpdateUserController());
    }

    public Controller getController(HttpServletRequest request) {
        return controllers.get(request.getRequestURI());
    }


}
