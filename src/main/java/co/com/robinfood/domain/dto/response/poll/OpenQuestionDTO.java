package co.com.robinfood.domain.dto.response.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class OpenQuestionDTO {

    @JsonProperty("id")
    @ApiModelProperty( notes = "Id Question")
    private Long id;

    @JsonProperty("description")
    @ApiModelProperty( notes = "description")
    private String description;

    public OpenQuestionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
