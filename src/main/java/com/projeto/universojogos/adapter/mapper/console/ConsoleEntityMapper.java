package com.projeto.universojogos.adapter.mapper.console;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.ConsoleEntity;
import com.projeto.universojogos.core.domain.Console;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConsoleEntityMapper extends GenericEntityMapper<Console, ConsoleEntity> {
    ConsoleEntityMapper INSTANCE = Mappers.getMapper(ConsoleEntityMapper.class);

    Console toDomain(ConsoleEntity consoleEntity);

    List<Console> toDomain(List<ConsoleEntity> consoleEntity);

    ConsoleEntity toEntity(Console console);
}
