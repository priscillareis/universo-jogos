package com.projeto.universojogos.adapter.mapper.plataforma;

import com.projeto.universojogos.adapter.dto.plataforma.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Plataforma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlataformaMapper extends GenericMapper<PlataformaRequest, PlataformaResponse,
        Plataforma> {

    PlataformaMapper INSTANCE = Mappers.getMapper(PlataformaMapper.class);

    Plataforma toDomain(PlataformaRequest plataformaRequest);

    PlataformaResponse toResponse(Plataforma plataforma);

    List<PlataformaResponse> toResponse(List<Plataforma> plataforma);
}
