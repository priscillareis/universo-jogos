package com.projeto.universojogos.adapter.mapper.jogador;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.JogadorEntity;
import com.projeto.universojogos.core.domain.Jogador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JogadorEntityMapper extends GenericEntityMapper<Jogador, JogadorEntity> {

    JogadorEntityMapper INSTANCE = Mappers.getMapper(JogadorEntityMapper.class);

    Jogador toDomain(JogadorEntity jogadorEntity);

    JogadorEntity toEntity(Jogador jogador);
}
