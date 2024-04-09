package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.persistence.entity.ConsoleEntity;
import com.projeto.universojogos.core.domain.Console;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsoleEntityMapper extends GenericEntityMapper<Console, ConsoleEntity> {
    ConsoleEntityMapper INSTANCE = Mappers.getMapper(ConsoleEntityMapper.class);

    Console toDomain(ConsoleEntity consoleEntity);

    ConsoleEntity toEntity(Console console);
}
