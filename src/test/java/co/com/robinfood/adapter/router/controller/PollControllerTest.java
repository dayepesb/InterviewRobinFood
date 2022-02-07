package co.com.robinfood.adapter.router.controller;

import co.com.robinfood.adapter.router.facade.PollFacade;
import co.com.robinfood.adapter.router.facade.impl.PollRouterFacade;
import co.com.robinfood.domain.dto.request.poll.DataPollRequestDTO;
import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.dto.response.poll.OpenQuestionDTO;
import co.com.robinfood.domain.dto.response.poll.PollDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class PollControllerTest {

    @InjectMocks
    private PollController pollController;

    @Mock
    private PollFacade pollFacade;

    private DataPollDTO dataPollDTO;

    private DataPollRequestDTO dto;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        setDataPollDTO();

        Mockito.when(pollFacade.getPoll()).thenReturn(dataPollDTO);
    }

    private void setDataPollDTO() {
        OpenQuestionDTO openQuestionDTO = new OpenQuestionDTO();
        openQuestionDTO.setId(1L);
        openQuestionDTO.setDescription("This is a description");

        ArrayList<OpenQuestionDTO> list = new ArrayList<>();
        list.add(openQuestionDTO);

        PollDTO pollDTO = new PollDTO();
        pollDTO.setId(0L);
        pollDTO.setIsOpen(false);
        pollDTO.setQuestion("is this a question ?");
        pollDTO.setQuestions(list);

        ArrayList<PollDTO> pollDTOS = new ArrayList<>();
        pollDTOS.add(pollDTO);

        dataPollDTO = new DataPollDTO();
        dataPollDTO.setData(pollDTOS);
    }

    @Test
    public void getPollTest() throws Exception {
        PollRouterFacade pollFacade = new PollRouterFacade();
        ResponseEntity<?> response = pollController.getPoll();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void registerResponseTest() throws Exception {
        PollRouterFacade pollFacade = new PollRouterFacade();
        ResponseEntity responseEntity = pollController.registerResponsePoll(dto);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}
