package co.com.robinfood.domain.dto.response.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class DataPollDTO {

    @JsonProperty("data")
    @ApiModelProperty( notes = "Data Poll")
    private List<PollDTO> data;

    public DataPollDTO() {
    }

    public List<PollDTO> getData() {
        return data;
    }

    public void setData(List<PollDTO> data) {
        this.data = data;
    }
}
