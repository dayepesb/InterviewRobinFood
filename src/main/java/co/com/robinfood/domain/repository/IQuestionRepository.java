package co.com.robinfood.domain.repository;

import co.com.robinfood.domain.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
