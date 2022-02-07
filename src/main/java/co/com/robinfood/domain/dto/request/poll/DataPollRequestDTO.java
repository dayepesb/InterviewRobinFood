package co.com.robinfood.domain.dto.request.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class DataPollRequestDTO {

    @JsonProperty("data")
    @ApiModelProperty( notes = "Data Request Poll")
    private List<RequestQuestionDTO> responseQuestionDTOS;

    public DataPollRequestDTO() {
    }

    public List<RequestQuestionDTO> getResponseQuestionDTOS() {
        return responseQuestionDTOS;
    }

    public void setResponseQuestionDTOS(List<RequestQuestionDTO> responseQuestionDTOS) {
        this.responseQuestionDTOS = responseQuestionDTOS;
    }
}
