package jwp.controller.qna.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

public class AddAnswerController implements Controller {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Answer answer = new Answer(MemoryAnswerRepository.getPK(),Integer.parseInt(req.getParameter("questionId")), req.getParameter("writer"), req.getParameter("contents"), Date.valueOf(LocalDate.now()));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findByQuestionId(Integer.toString(answer.getQuestionId()));
        question.increaseCountOfAnswer();

        questionRepository.updateCountOfAnswer(question);

        //Jackson 패키지 사용
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(mapper.writeValueAsString(savedAnswer));

        //페이지가 아니므로 null 반환.
        return null;
    }
}
