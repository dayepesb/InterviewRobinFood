package co.com.robinfood.adapter.router.facade.impl;

import co.com.robinfood.adapter.router.facade.PollFacade;
import co.com.robinfood.domain.dto.request.poll.DataPollRequestDTO;
import co.com.robinfood.domain.dto.request.poll.RequestQuestionDTO;
import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.dto.response.poll.PollDTO;
import co.com.robinfood.domain.service.logger.LogStrategy;
import co.com.robinfood.domain.service.poll.IPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PollRouterFacade extends PollFacade {

    @Autowired
    IPollService pollService;

    @Autowired
    private LogStrategy logStrategy;

    @Override
    public DataPollDTO getPoll() throws Exception {

        logStrategy.logInfo("Get Questions Router Facade");

        DataPollDTO poll = pollService.getPoll();

        if (poll == null) {
            throw new Exception("Null Entity");
        }

        return poll;
    }

    @Override
    public void registerPoll(DataPollRequestDTO dto) throws Exception {
        for ( RequestQuestionDTO requestQuestionDTO: dto.getResponseQuestionDTOS()) {
            registerResponse(requestQuestionDTO);
        }
    }

    private void registerResponse(RequestQuestionDTO dto) throws Exception {
        Long idQuestion = dto.getIdQuestion();
        pollService.registerResponse(idQuestion, dto.getResponse());
    }
}
