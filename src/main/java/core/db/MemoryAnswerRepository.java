package core.db;

import jwp.model.Answer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class MemoryAnswerRepository {

    private Map<String, Answer> answers= new HashMap<>();
    private static int PK = 0;
    private static MemoryAnswerRepository memoryAnswerRepository;

    private MemoryAnswerRepository() {
        insert(new Answer(++PK,1,"함형주","7호선 타세요", Date.valueOf(LocalDate.now())));
    }

    public static MemoryAnswerRepository getInstance() {
        if (memoryAnswerRepository == null) {
            memoryAnswerRepository = new MemoryAnswerRepository();
            return memoryAnswerRepository;
        }
        return memoryAnswerRepository;
    }

    public static int getPK(){
        return ++PK;
    }

    public List<Answer> findAllByQuestionId(String id) {
        ArrayList<Answer> result = new ArrayList<>();

        Set<String> answerKeys = answers.keySet();
        for (String key : answerKeys) {
            Answer repoAnswer = answers.get(key);
            if(repoAnswer.getQuestionId() == Integer.parseInt(id)){
                result.add(repoAnswer);
            }
        }

        return result;
    }


    public Answer insert(Answer answer) {
        answers.put(Integer.toString(answer.getAnswerId()),answer);
        return answer;
    }
}
