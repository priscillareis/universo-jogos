package com.projeto.universojogos.adapter.mapper.registroGame;

import com.projeto.universojogos.adapter.dto.registroGame.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.RegistroGame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistroGameMapper extends GenericMapper<RegistroGameRequest, RegistroGameResponse, RegistroGame> {

    RegistroGameMapper INSTANCE = Mappers.getMapper(RegistroGameMapper.class);

    @Mapping(target = "dataInicio", source = "dataInicio", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataFim", source = "dataFim", dateFormat = "dd/MM/yyyy")
    RegistroGame toDomain(RegistroGameRequest registroGameRequest);

    @Mapping(target = "dataInicio", source = "dataInicio", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataFim", source = "dataFim", dateFormat = "dd/MM/yyyy")
    RegistroGameResponse toResponse(RegistroGame registroGame);
}
