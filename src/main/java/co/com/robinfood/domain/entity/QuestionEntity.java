package co.com.robinfood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "QUESTION" )
public class QuestionEntity extends BaseEntity {

    @Column( name = "QUESTION", nullable = false)
    private String question;

    @Column( name = "IS_OPEN", nullable = false)
    private Boolean isOpen;

    @OneToMany(mappedBy = "question")
    private List<OpenQuestionEntity> questions;

    public List<OpenQuestionEntity> getQuestions() {
        return questions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean open) {
        isOpen = open;
    }

    public void setQuestions(List<OpenQuestionEntity> questions) {
        this.questions = questions;
    }
}
