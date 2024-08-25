package com.projeto.universojogos.adapter.mapper.plataforma;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import com.projeto.universojogos.core.domain.Plataforma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlataformaEntityMapper extends GenericEntityMapper<Plataforma, PlataformaEntity> {
    PlataformaEntityMapper INSTANCE = Mappers.getMapper(PlataformaEntityMapper.class);

    Plataforma toDomain(PlataformaEntity plataformaEntity);

    List<Plataforma> toDomain(List<PlataformaEntity> plataformaEntity);

    PlataformaEntity toEntity(Plataforma plataforma);
}
