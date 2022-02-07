package co.com.robinfood.util.mappers;

import co.com.robinfood.domain.dto.response.poll.DataPollDTO;
import co.com.robinfood.domain.entity.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { IPollMapper.class })
public interface IDataPollMapper {
    IDataPollMapper INSTANCE = Mappers.getMapper(IDataPollMapper.class);

    default DataPollDTO questionEntityToDataPollDTO(List<QuestionEntity> questionEntityList) {
        return questionEntityToDataPollDTO(new DataPollDTO(), questionEntityList);
    }

    @Mapping(source = "questionEntityList", target = "data")
    DataPollDTO questionEntityToDataPollDTO(DataPollDTO dataPollDTO, List<QuestionEntity> questionEntityList);
}
