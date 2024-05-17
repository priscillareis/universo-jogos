package com.projeto.universojogos.adapter.mapper.colecao;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.ColecaoEntity;
import com.projeto.universojogos.core.domain.Colecao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ColecaoEntityMapper extends GenericEntityMapper<Colecao, ColecaoEntity> {
    ColecaoEntityMapper INSTANCE = Mappers.getMapper(ColecaoEntityMapper.class);

    Colecao toDomain(ColecaoEntity colecaoEntity);

    ColecaoEntity toEntity(Colecao colecao);
}
