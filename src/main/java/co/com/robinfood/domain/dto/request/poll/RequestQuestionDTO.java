package co.com.robinfood.domain.dto.request.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class RequestQuestionDTO {

    @JsonProperty("id_question")
    @ApiModelProperty( notes = "Id question")
    private Long idQuestion;

    @JsonProperty("response")
    @ApiModelProperty( notes = "Response Question")
    private String response;

    public RequestQuestionDTO() {
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
