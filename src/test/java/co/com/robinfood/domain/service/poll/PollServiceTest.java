package co.com.robinfood.domain.service.poll;

import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.entity.OpenQuestionEntity;
import co.com.robinfood.domain.entity.QuestionEntity;
import co.com.robinfood.domain.repository.IQuestionRepository;
import co.com.robinfood.domain.repository.IResponseRepository;
import co.com.robinfood.domain.service.logger.LogStrategy;
import co.com.robinfood.domain.service.poll.impl.PollService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class PollServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private LogStrategy logStrategy;

    @Mock
    IQuestionRepository questionRepository;

    @Mock
    IResponseRepository responseRepository;

    @InjectMocks
    private PollService pollService;

    private QuestionEntity questionEntity;

    private OpenQuestionEntity openQuestionEntity;

    private List<QuestionEntity> questionEntityList;

    @Before
    public void setup () {
        MockitoAnnotations.initMocks(this);

        initData();

        Mockito.when(questionRepository.findAll()).thenReturn(questionEntityList);
        Mockito.when(responseRepository.findById(ArgumentMatchers.any())).thenReturn(null);
    }

    @Test
    public void verifyReturnTest() throws Exception {
        DataPollDTO dataPollDTO = pollService.getPoll();
        Assert.assertNotNull(dataPollDTO);
    }

    @Test
    public void verifyStructTest() throws Exception {
        DataPollDTO dataPollDTO = pollService.getPoll();
        Assert.assertEquals(dataPollDTO.getData().size(), 2);
        Assert.assertEquals(dataPollDTO.getData().get(1).getQuestions().size(), 1);
    }

    @Test
    public void verifyDataTest() throws Exception {
        DataPollDTO dataPollDTO = pollService.getPoll();
        Assert.assertEquals(dataPollDTO.getData().get(0).getQuestion(), "This is a question");
        Assert.assertEquals(dataPollDTO.getData().get(1).getQuestion(), "this is a question 2");
        Assert.assertEquals(dataPollDTO.getData().get(1).getQuestions().get(0).getDescription(), "This is a description open question");
    }

    @Test
    public void verifyDataNullTest() throws Exception {
        Mockito.when(questionRepository.findAll()).thenReturn(null);
        DataPollDTO dataPollDTO = pollService.getPoll();
        Assert.assertNull(dataPollDTO.getData());
    }

    @Test
    public void verifyExceptionTest() throws Exception {
        Mockito.when(questionRepository.findAll()).thenReturn(null);
        DataPollDTO dataPollDTO = pollService.getPoll();
        Assert.assertNull(dataPollDTO.getData());
    }

    @Test
    public void verifyExceptionRegisterTest() throws Exception {
        Mockito.when(questionRepository.findById(1L)).thenReturn(null);
        thrown.expect(Exception.class);
        thrown.expectMessage("Question with ID 1 is not a valid question");
        pollService.registerResponse(1L, "This is a response");
    }

    @Test
    public void verifyRegisterTest() throws Exception {
        Mockito.when(questionRepository.findById(1L)).thenReturn(Optional.ofNullable(questionEntity));
        pollService.registerResponse(1L, "This is a response");
    }

    private void initData() {
        questionEntity = new QuestionEntity();
        questionEntity.setId(0L);
        questionEntity.setQuestion("This is a question");
        questionEntity.setQuestions(null);
        questionEntity.setIsOpen(true);

        openQuestionEntity = new OpenQuestionEntity();
        openQuestionEntity.setDescription("This is a description open question");
        openQuestionEntity.setId(3L);

        QuestionEntity questionEntity2 = new QuestionEntity();
        questionEntity2.setIsOpen(false);
        questionEntity2.setQuestion("this is a question 2");

        openQuestionEntity.setQuestion(questionEntity2);

        List<OpenQuestionEntity> openQuestionEntities = new ArrayList<>();
        openQuestionEntities.add(openQuestionEntity);

        questionEntity2.setQuestions(openQuestionEntities);

        questionEntityList = new ArrayList<>();
        questionEntityList.add(questionEntity);
        questionEntityList.add(questionEntity2);
    }
}
