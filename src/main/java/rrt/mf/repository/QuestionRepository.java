package rrt.mf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rrt.mf.model.Movie;
import rrt.mf.model.Question;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Optional<Question> findById(Integer id);
}
