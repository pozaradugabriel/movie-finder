package rrt.mf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rrt.mf.model.Movie;
import rrt.mf.model.Question;
import rrt.mf.service.MovieService;
import rrt.mf.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping(path="/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.showAllQuestions();
    }
}
