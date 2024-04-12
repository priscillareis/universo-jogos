package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.plataforma.*;
import com.projeto.universojogos.core.domain.Plataforma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlataformaMapper extends GenericMapper<PlataformaRequest, PlataformaResponse,
        Plataforma> {

    PlataformaMapper INSTANCE = Mappers.getMapper(PlataformaMapper.class);

    Plataforma toDomain(PlataformaRequest plataformaRequest);

    PlataformaResponse toResponse(Plataforma plataforma);
}
