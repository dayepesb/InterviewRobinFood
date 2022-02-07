package co.com.robinfood.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "OPEN_QUESTION")
public class OpenQuestionEntity extends BaseEntity {

    @ManyToOne(targetEntity = QuestionEntity.class, cascade = CascadeType.ALL, optional = false)
    private QuestionEntity question;

    @Column( name = "DESCRIPTION", nullable = false)
    private String description;

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
