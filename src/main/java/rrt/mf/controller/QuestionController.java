package rrt.mf.controller;

import org.springframework.web.bind.annotation.*;
import rrt.mf.model.Question;
import rrt.mf.service.QuestionService;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/add")
    public void addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
    }
    @GetMapping(path="/{id}")
    public Optional<Question> getQuestion(@PathVariable Integer id){
        return questionService.showQuestionByID(id);
    }
}
