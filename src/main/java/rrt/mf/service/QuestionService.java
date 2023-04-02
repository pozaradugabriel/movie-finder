package rrt.mf.service;

import org.springframework.stereotype.Service;
import rrt.mf.model.Movie;
import rrt.mf.model.Question;
import rrt.mf.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public Question addQuestion(Question question) {
        if (question.getQuestion() != null && question.getAnswer1() != null && question.getAnswer2() != null && question.getAnswer3() != null && question.getAnswer4() !=null) {
            return questionRepository.save(question);
        }
        else return null;
    }

    public List<Question> showAllQuestions(){
        return questionRepository.findAll();
    }
}
