package com.projeto.universojogos.adapter.mapper.manutencao;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.ManutencaoEntity;
import com.projeto.universojogos.core.domain.Manutencao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ManutencaoEntityMapper extends GenericEntityMapper<Manutencao, ManutencaoEntity> {

    ManutencaoEntityMapper INSTANCE = Mappers.getMapper(ManutencaoEntityMapper.class);

    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy")
    Manutencao toDomain(ManutencaoEntity manutencaoEntity);

    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy")
    List<Manutencao> toDomain(List<ManutencaoEntity> manutencaoEntity);

    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy")
    ManutencaoEntity toEntity(Manutencao manutencao);
}
