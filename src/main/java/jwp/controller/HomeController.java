package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class HomeController implements Controller{
    private final MemoryQuestionRepository memoryQuestionRepository= MemoryQuestionRepository.getInstance();
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Question> questions = memoryQuestionRepository.findAll();
        req.setAttribute("questions",questions);
        return new JspView("/home.jsp");
    }
}
