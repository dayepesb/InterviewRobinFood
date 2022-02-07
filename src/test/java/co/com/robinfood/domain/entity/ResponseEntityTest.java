package co.com.robinfood.domain.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ResponseEntityTest {
    @Mock
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ResponseEntity responseEntity;

    private QuestionEntity questionEntity;
    @Before
    public void setup() {
        initData();
    }

    private void initData() {
        questionEntity = new QuestionEntity();
        questionEntity.setId(1L);
        questionEntity.setIsOpen(false);
        questionEntity.setQuestion("this is a question");

        responseEntity = new ResponseEntity();
        responseEntity.setId(1L);
        responseEntity.setQuestion(questionEntity);
        responseEntity.setResponse("This is a response");
    }

    @Test
    public void entityNotNullTest() {
        Assert.assertNotNull(responseEntity);
    }

    @Test
    public void validateDataTest() {
        Assert.assertEquals(Optional.of(responseEntity.getId()), Optional.of(1L));
        Assert.assertEquals(Optional.ofNullable(Optional.of(responseEntity.getQuestion()).get().getId()), Optional.of(1L));
        Assert.assertEquals(Optional.of(responseEntity.getResponse()), Optional.of("This is a response"));
    }

    @Test
    public void validateQuestionTest() {
        Assert.assertNotNull(responseEntity.getQuestion());
    }
}
