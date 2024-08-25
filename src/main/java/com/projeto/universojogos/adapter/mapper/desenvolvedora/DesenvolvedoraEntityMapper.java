package com.projeto.universojogos.adapter.mapper.desenvolvedora;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.DesenvolvedoraEntity;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DesenvolvedoraEntityMapper extends GenericEntityMapper<Desenvolvedora, DesenvolvedoraEntity> {

    DesenvolvedoraEntityMapper INSTANCE = Mappers.getMapper(DesenvolvedoraEntityMapper.class);

    Desenvolvedora toDomain(DesenvolvedoraEntity desenvolvedoraEntity);

    List<Desenvolvedora> toDomain(List<DesenvolvedoraEntity> desenvolvedoraEntity);

    DesenvolvedoraEntity toEntity(Desenvolvedora desenvolvedora);

}
