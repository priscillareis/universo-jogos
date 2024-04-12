package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import com.projeto.universojogos.core.domain.Plataforma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlataformaEntityMapper extends GenericEntityMapper<Plataforma, PlataformaEntity> {
    PlataformaEntityMapper INSTANCE = Mappers.getMapper(PlataformaEntityMapper.class);

    Plataforma toDomain(PlataformaEntity plataformaEntity);

    PlataformaEntity toEntity(Plataforma plataforma);
}
