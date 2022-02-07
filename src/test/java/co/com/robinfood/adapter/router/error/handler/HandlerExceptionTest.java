package co.com.robinfood.adapter.router.error.handler;

import co.com.robinfood.domain.dto.response.GenericResponseDTO;
import co.com.robinfood.domain.service.logger.LogStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;


public class HandlerExceptionTest {

    @Mock
    private LogStrategy logStrategy;

    @Mock
    HttpServerErrorException httpServerErrorException;

    private HandlerException handlerException;

    private static final String RESPONSE_500 = "{\n" +
            "  \"code\": \"MS500\",\n" +
            "  \"message\": \"Internal Error\"\n" +
            "}";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        handlerException = new HandlerException(logStrategy);
    }

    @Test
    public void requestInternalErrorExceptionHandlerTest() {
        Mockito.when(httpServerErrorException.getResponseBodyAsString()).thenReturn(RESPONSE_500);
        ResponseEntity<GenericResponseDTO> response = handlerException.handleGlobalException(httpServerErrorException);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getBody().getResponseCode(), "MS500");
        Assert.assertEquals(response.getBody().getResponseMessage(), "Internal Error");
    }
}
