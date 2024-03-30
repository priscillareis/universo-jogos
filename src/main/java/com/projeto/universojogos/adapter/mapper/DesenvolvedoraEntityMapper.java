package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.persistence.entity.DesenvolvedoraEntity;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DesenvolvedoraEntityMapper extends GenericEntityMapper<Desenvolvedora, DesenvolvedoraEntity> {

    DesenvolvedoraEntityMapper INSTANCE = Mappers.getMapper(DesenvolvedoraEntityMapper.class);

    Desenvolvedora toDomain(DesenvolvedoraEntity desenvolvedoraEntity);

    DesenvolvedoraEntity toEntity(Desenvolvedora desenvolvedora);

}
