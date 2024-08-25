package com.projeto.universojogos.adapter.mapper.registroGame;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.RegistroGameEntity;
import com.projeto.universojogos.core.domain.RegistroGame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegistroGameEntityMapper extends GenericEntityMapper<RegistroGame, RegistroGameEntity> {

    RegistroGameEntityMapper INSTANCE = Mappers.getMapper(RegistroGameEntityMapper.class);

    @Mapping(target = "dataInicio", source = "dataInicio", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataFim", source = "dataFim", dateFormat = "dd/MM/yyyy")
    RegistroGame toDomain(RegistroGameEntity registroGameEntity);

    @Mapping(target = "dataInicio", source = "dataInicio", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataFim", source = "dataFim", dateFormat = "dd/MM/yyyy")
    List<RegistroGame> toDomain(List<RegistroGameEntity> registroGameEntity);

    @Mapping(target = "dataInicio", source = "dataInicio", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataFim", source = "dataFim", dateFormat = "dd/MM/yyyy")
    RegistroGameEntity toEntity(RegistroGame registroGame);
}
