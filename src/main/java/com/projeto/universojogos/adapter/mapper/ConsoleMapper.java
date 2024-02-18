package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.console.*;
import com.projeto.universojogos.adapter.persistence.entity.ConsoleEntity;
import com.projeto.universojogos.core.domain.Console;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsoleMapper {

    ConsoleMapper INSTANCE = Mappers.getMapper(ConsoleMapper.class);

    Console toDomain(ConsoleRequest consoleRequest);

    ConsoleResponse toResponse(Console console);

    ConsoleEntity toEntity(Console console);

    Console toDomain(ConsoleEntity consoleEntity);
}
