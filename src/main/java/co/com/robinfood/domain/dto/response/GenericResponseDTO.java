package co.com.robinfood.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericResponseDTO {

    @JsonProperty("code")
    private String responseCode;

    @JsonProperty("message")
    private String responseMessage;

    public GenericResponseDTO() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
