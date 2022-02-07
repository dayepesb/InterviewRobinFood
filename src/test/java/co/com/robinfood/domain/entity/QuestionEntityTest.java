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
public class QuestionEntityTest {
    @Mock
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private QuestionEntity questionEntity;
    private OpenQuestionEntity openQuestionEntity;

    @Before
    public void setup() {
        initData();
    }

    private void initData() {
        questionEntity = new QuestionEntity();
        questionEntity.setId(1L);
        questionEntity.setIsOpen(false);
        questionEntity.setQuestion("this is a question");

        openQuestionEntity = new OpenQuestionEntity();
        openQuestionEntity.setId(2L);
        openQuestionEntity.setDescription("tHIS IS A TESTS");

        List<QuestionEntity> questionEntityList = new ArrayList<>();
        questionEntityList.add(questionEntity);

        List<OpenQuestionEntity> openQuestionEntities = new ArrayList<>();
        openQuestionEntities.add(openQuestionEntity);

        questionEntity.setQuestions(openQuestionEntities);
        openQuestionEntity.setQuestion(questionEntity);
    }

    @Test
    public void entityNotNullTest() {
        Assert.assertNotNull(questionEntity);
    }

    @Test
    public void validateDataTest() {
        Assert.assertEquals(Optional.of(questionEntity.getId()), Optional.of(1L));
        Assert.assertEquals(Optional.of(questionEntity.getQuestion()), Optional.of("this is a question"));
        Assert.assertEquals(Optional.of(questionEntity.getIsOpen()), Optional.of(false));
    }

    @Test
    public void validateQuestionTest() {
        Assert.assertNotNull(questionEntity.getQuestions());
    }
}
