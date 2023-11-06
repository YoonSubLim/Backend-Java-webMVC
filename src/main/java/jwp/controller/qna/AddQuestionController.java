package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

public class AddQuestionController implements Controller {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Question question = new Question(MemoryQuestionRepository.getPK(),request.getParameter("writer"), request.getParameter("title"), request.getParameter("contents"), Date.valueOf(LocalDate.now()), 0);
        questionRepository.insert(question);

        return new JspView("redirect:/");
    }
}
