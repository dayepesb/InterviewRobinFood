package co.com.robinfood.domain.service.poll;

import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.dto.response.poll.PollDTO;

public interface IPollService {
    DataPollDTO getPoll() throws Exception;
    void registerResponse(Long id, String Response) throws Exception;
}
