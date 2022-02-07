package co.com.robinfood.domain.dto.response.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PollDTO {

    @JsonProperty("id")
    @ApiModelProperty( notes = "ID Question")
    private Long id;

    @JsonProperty("question")
    @ApiModelProperty( notes = "Description")
    private String question;

    @JsonProperty("is_open")
    @ApiModelProperty( notes = "Is question open")
    private Boolean isOpen;

    @JsonProperty("questions")
    @ApiModelProperty( notes = "If question is open")
    private List<OpenQuestionDTO> questions;

    public PollDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<OpenQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<OpenQuestionDTO> questions) {
        this.questions = questions;
    }
}
