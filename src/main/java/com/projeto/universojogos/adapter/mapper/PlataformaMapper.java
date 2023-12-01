package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.PlataformaRequest;
import com.projeto.universojogos.adapter.dto.PlataformaResponse;
import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import com.projeto.universojogos.core.domain.Plataforma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlataformaMapper {

    PlataformaMapper INSTANCE = Mappers.getMapper(PlataformaMapper.class);

    Plataforma toDomain(PlataformaRequest plataformaRequest);

    PlataformaResponse toResponse(Plataforma plataforma);

    PlataformaEntity toEntity(Plataforma plataforma);

    Plataforma toDomain(PlataformaEntity plataformaEntity);
}
