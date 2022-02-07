package co.com.robinfood.adapter.router.facade;

import co.com.robinfood.domain.dto.request.poll.DataPollRequestDTO;
import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.dto.response.poll.PollDTO;

public abstract class PollFacade {
    public abstract DataPollDTO getPoll() throws Exception;

    public abstract void registerPoll(DataPollRequestDTO dto) throws Exception;
}
