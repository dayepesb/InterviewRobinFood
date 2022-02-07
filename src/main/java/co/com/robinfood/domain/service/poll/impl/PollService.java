package co.com.robinfood.domain.service.poll.impl;

import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.entity.QuestionEntity;
import co.com.robinfood.domain.entity.ResponseEntity;
import co.com.robinfood.domain.repository.IQuestionRepository;
import co.com.robinfood.domain.repository.IResponseRepository;
import co.com.robinfood.domain.service.logger.LogStrategy;
import co.com.robinfood.domain.service.poll.IPollService;
import co.com.robinfood.util.mappers.IDataPollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PollService implements IPollService {

    @Autowired
    private LogStrategy logStrategy;

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private IResponseRepository responseRepository;

    @Override
    public DataPollDTO getPoll() throws Exception {

        List<QuestionEntity> questions = questionRepository.findAll();

        logStrategy.logInfo("Query Questions are successfully");

        DataPollDTO dataPollDTO = IDataPollMapper.INSTANCE.questionEntityToDataPollDTO(questions);

        return dataPollDTO;
    }

    @Override
    @Transactional
    public void registerResponse(Long id, String response) throws Exception {
        QuestionEntity questionEntity;
        try {
            questionEntity = questionRepository.findById(id).get();
        } catch (Exception e) {
            logStrategy.logInfo(String.format("Question with ID %d is not a valid question", id));
            throw new Exception(String.format("Question with ID %d is not a valid question", id));
        }

        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setQuestion(questionEntity);
        responseEntity.setResponse(response);
        responseRepository.save(responseEntity);
        logStrategy.logInfo("Save data successfully");
    }
}
