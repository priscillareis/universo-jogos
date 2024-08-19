package com.projeto.universojogos.adapter.mapper.colecao;

import com.projeto.universojogos.adapter.dto.colecao.ColecaoRequest;
import com.projeto.universojogos.adapter.dto.colecao.ColecaoResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Colecao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ColecaoMapper extends GenericMapper<ColecaoRequest, ColecaoResponse, Colecao> {
    ColecaoMapper INSTANCE = Mappers.getMapper(ColecaoMapper.class);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    Colecao toDomain(ColecaoRequest colecaoRequest);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    ColecaoResponse toResponse(Colecao colecao);
}
