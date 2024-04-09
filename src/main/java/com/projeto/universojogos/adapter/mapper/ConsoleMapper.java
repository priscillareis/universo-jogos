package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.console.*;
import com.projeto.universojogos.core.domain.Console;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsoleMapper extends GenericMapper<ConsoleRequest, ConsoleResponse,
        Console>{

    ConsoleMapper INSTANCE = Mappers.getMapper(ConsoleMapper.class);

    Console toDomain(ConsoleRequest consoleRequest);

    ConsoleResponse toResponse(Console console);
}
