package core.db;

import jwp.model.Question;

import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryQuestionRepository {
    private Map<String, Question> questions= new HashMap<>();
    private static MemoryQuestionRepository memoryQuestionRepository;
    private static int PK = 0;

    private MemoryQuestionRepository() {
        insert(new Question(++PK,"이주언","건대 어떻게 가나요?","홍대에서 건대 어떻게 가나요?", Date.valueOf(LocalDate.now()),1));
        insert(new Question(++PK,"강연주","서버 개잘하는데 질문받음","질문 ㄱ", Date.valueOf(LocalDate.now()),0));

    }

    public static MemoryQuestionRepository getInstance() {
        if (memoryQuestionRepository == null) {
            memoryQuestionRepository = new MemoryQuestionRepository();
            return memoryQuestionRepository;
        }
        return memoryQuestionRepository;
    }

    public static int getPK(){
        return ++PK;
    }

    public Question findByQuestionId(String id) {
        return questions.get(id);
    }

    public void update(Question question) {
        Question repoQuestion = questions.get(Integer.toString(question.getQuestionId()));
        repoQuestion.update(question);
    }

    public void insert(Question question) {
        questions.put(Integer.toString(question.getQuestionId()), question);
    }

    public void updateCountOfAnswer(Question question) {
        Question repoQuestion = questions.get(Integer.toString(question.getQuestionId()));
        repoQuestion.updateCountofAnswer(question);
    }

    public List<Question> findAll() {
        return questions.values().stream().toList();
    }
}
