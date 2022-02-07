package co.com.robinfood.domain.entity;

import javax.persistence.*;

@Entity
@Table( name = "RESPONSE" )
public class ResponseEntity extends BaseEntity {

    @ManyToOne(targetEntity = QuestionEntity.class, cascade = CascadeType.ALL, optional = false)
    private QuestionEntity question;

    @Column( name = "response", nullable = false)
    private String response;

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
