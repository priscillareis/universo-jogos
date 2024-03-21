package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.desenvolvedora.*;
import com.projeto.universojogos.adapter.persistence.entity.DesenvolvedoraEntity;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DesenvolvedoraMapper {

    DesenvolvedoraMapper INSTANCE = Mappers.getMapper(DesenvolvedoraMapper.class);

    Desenvolvedora toDomain(DesenvolvedoraRequest desenvolvedoraRequest);

    DesenvolvedoraResponse toResponse(Desenvolvedora desenvolvedora);

    DesenvolvedoraEntity toEntity(Desenvolvedora desenvolvedora);

    Desenvolvedora toDomain(DesenvolvedoraEntity desenvolvedoraEntity);
}
