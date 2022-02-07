package co.com.robinfood.adapter.router.facade;

import co.com.robinfood.adapter.router.facade.impl.PollRouterFacade;
import co.com.robinfood.domain.dto.request.poll.DataPollRequestDTO;
import co.com.robinfood.domain.dto.request.poll.RequestQuestionDTO;
import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.dto.response.poll.OpenQuestionDTO;
import co.com.robinfood.domain.dto.response.poll.PollDTO;
import co.com.robinfood.domain.service.logger.LogStrategy;
import co.com.robinfood.domain.service.poll.IPollService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PollRouterFacadeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @InjectMocks
    @Spy
    private PollRouterFacade pollRouterFacade;

    @Mock
    private LogStrategy logStrategy;

    @Mock
    private IPollService pollService;

    private DataPollDTO dataPollDTO;

    private RequestQuestionDTO requestQuestionDTO;

    private DataPollRequestDTO dto;

    @Before
    public void setup () throws Exception {
        buildResponseService();
        Mockito.when(pollService.getPoll()).thenReturn(dataPollDTO);
    }

    @Test
    public void validateResponseServiceTest () throws Exception {
        DataPollDTO dataPollDTO = pollRouterFacade.getPoll();
        Assert.assertNotNull(dataPollDTO);
        Assert.assertNotNull(dataPollDTO.getData());
        Assert.assertNotNull(dataPollDTO.getData().get(0));
        Assert.assertNotNull(dataPollDTO.getData().get(1));
    }

    @Test
    public void validateIdsResponseTest () throws Exception {
        DataPollDTO dataPollDTO = pollRouterFacade.getPoll();
        Assert.assertEquals(java.util.Optional.of(dataPollDTO.getData().get(0).getId()), java.util.Optional.of(1L));
        Assert.assertEquals(java.util.Optional.of(dataPollDTO.getData().get(1).getId()), java.util.Optional.of(2L));
    }

    @Test
    public void validateExceptionNullDataTest () throws Exception {
        Mockito.when(pollService.getPoll()).thenReturn(null);
        thrown.expect(Exception.class);
        thrown.expectMessage("Null Entity");
        pollRouterFacade.getPoll();
    }

    @Test
    public void validateExceptionRegisterPollTest () throws Exception {
        Mockito.doThrow(new Exception("Question with ID 1 is not a valid question"))
                .when(pollService).registerResponse(1L, "This is a response");
        thrown.expect(Exception.class);
        thrown.expectMessage("Question with ID 1 is not a valid question");
        pollRouterFacade.registerPoll(dto);
    }

    private void buildResponseService () {

        OpenQuestionDTO openQuestionDTO = new OpenQuestionDTO();
        openQuestionDTO.setDescription("this is a question");
        openQuestionDTO.setId(0L);

        List<OpenQuestionDTO> openQuestionDTOList = new ArrayList<>();
        openQuestionDTOList.add(openQuestionDTO);

        PollDTO pollDTO = new PollDTO();
        pollDTO.setQuestions(openQuestionDTOList);
        pollDTO.setIsOpen(false);
        pollDTO.setId(1L);
        pollDTO.setQuestion("This is a question 1");

        PollDTO pollDTOOpen = new PollDTO();
        pollDTOOpen.setQuestions(null);
        pollDTOOpen.setIsOpen(true);
        pollDTOOpen.setId(2L);
        pollDTOOpen.setQuestion("This is a question 2");

        List<PollDTO> pollDTOList = new ArrayList<>();
        pollDTOList.add(pollDTO);
        pollDTOList.add(pollDTOOpen);

        dataPollDTO = new DataPollDTO();
        dataPollDTO.setData(pollDTOList);

        requestQuestionDTO = new RequestQuestionDTO();
        requestQuestionDTO.setIdQuestion(1L);
        requestQuestionDTO.setResponse("This is a response");

        List<RequestQuestionDTO> requestQuestionDTOS = new ArrayList<>();
        requestQuestionDTOS.add(requestQuestionDTO);
        dto = new DataPollRequestDTO();
        dto.setResponseQuestionDTOS(requestQuestionDTOS);
    }
}
