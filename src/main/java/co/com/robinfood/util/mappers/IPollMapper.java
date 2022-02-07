package co.com.robinfood.util.mappers;

import co.com.robinfood.domain.dto.response.poll.PollDTO;
import co.com.robinfood.domain.entity.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPollMapper {
    IPollMapper INSTANCE = Mappers.getMapper(IPollMapper.class);

    @Mapping(source = "question", target = "question")
    @Mapping(source = "isOpen", target = "isOpen")
    @Mapping(source = "questions", target = "questions")
    PollDTO QuestionEntityToPollDTO(QuestionEntity questionEntity);

}
