package co.com.robinfood.adapter.router.error.handler;

import co.com.robinfood.domain.dto.response.GenericResponseDTO;
import co.com.robinfood.domain.service.logger.LogStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static co.com.robinfood.util.Consts.INTERNAL_ERROR_CODE;
import static co.com.robinfood.util.Consts.INTERNAL_ERROR_MESSAGE;

@ControllerAdvice
public class HandlerException {

    @Autowired
    private LogStrategy logStrategy;

    public HandlerException() { }

    public HandlerException(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
    }

    @ExceptionHandler( value = Exception.class )
    public ResponseEntity<GenericResponseDTO> handleGlobalException(Exception e) {
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
        genericResponseDTO.setResponseCode(INTERNAL_ERROR_CODE);
        genericResponseDTO.setResponseMessage(INTERNAL_ERROR_MESSAGE);

        logStrategy.logError(String.format("%s: %s","Internal Error", e.toString()));

        return new ResponseEntity<>(genericResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
