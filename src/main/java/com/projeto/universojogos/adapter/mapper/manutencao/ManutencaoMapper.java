package com.projeto.universojogos.adapter.mapper.manutencao;

import com.projeto.universojogos.adapter.dto.manutencao.ManutencaoRequest;
import com.projeto.universojogos.adapter.dto.manutencao.ManutencaoResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Manutencao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ManutencaoMapper extends GenericMapper<ManutencaoRequest, ManutencaoResponse, Manutencao> {

    ManutencaoMapper INSTANCE = Mappers.getMapper(ManutencaoMapper.class);

    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy")
    Manutencao toDomain(ManutencaoRequest manutencaoRequest);

    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy")
    ManutencaoResponse toResponse(Manutencao manutencao);

    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy")
    List<ManutencaoResponse> toResponse(List<Manutencao> manutencao);
}
