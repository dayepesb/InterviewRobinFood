package co.com.robinfood.adapter.router.controller;

import co.com.robinfood.adapter.router.facade.PollFacade;
import co.com.robinfood.domain.dto.request.poll.DataPollRequestDTO;
import co.com.robinfood.domain.dto.response.GenericResponseDTO;
import co.com.robinfood.domain.dto.response.poll.PollDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static co.com.robinfood.adapter.router.PollRouterConsts.*;

@RestController
@RequestMapping(REQUEST_POLL_MAPPING)
public class PollController {

    @Autowired
    private PollFacade pollFacade;

    @GetMapping( value = GET_POLL_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation( value = API_GET_OPERATION_POLL)
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = API_RESPONSE_SUCCESSFUL, response = PollDTO.class),
            @ApiResponse( code = 500, message = API_RESPONSE_INTERNAL_ERROR, response = GenericResponseDTO.class)
    })
    public ResponseEntity<?> getPoll() throws Exception {
        return new ResponseEntity<>(pollFacade.getPoll(), HttpStatus.OK);
    }

    @PostMapping( value = REGISTER_POLL_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation( value = API_RESGISTER_OPERATION_POLL)
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = API_RESPONSE_SUCCESSFUL),
            @ApiResponse( code = 500, message = API_RESPONSE_INTERNAL_ERROR, response = GenericResponseDTO.class)
    })
    public ResponseEntity<?> registerResponsePoll(@RequestBody DataPollRequestDTO body) throws Exception {
        pollFacade.registerPoll(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
