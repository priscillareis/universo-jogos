package com.projeto.universojogos.adapter.mapper.jogador;

import com.projeto.universojogos.adapter.dto.jogador.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Jogador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JogadorMapper extends GenericMapper<JogadorRequest, JogadorResponse, Jogador> {

    JogadorMapper INSTANCE = Mappers.getMapper(JogadorMapper.class);

    Jogador toDomain(JogadorRequest jogadorRequest);

    JogadorResponse toResponse(Jogador jogador);

    List<JogadorResponse> toResponse(List<Jogador> jogador);
}
