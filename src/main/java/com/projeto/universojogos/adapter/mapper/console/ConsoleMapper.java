package com.projeto.universojogos.adapter.mapper.console;

import com.projeto.universojogos.adapter.dto.console.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Console;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConsoleMapper extends GenericMapper<ConsoleRequest, ConsoleResponse,
        Console> {

    ConsoleMapper INSTANCE = Mappers.getMapper(ConsoleMapper.class);

    Console toDomain(ConsoleRequest consoleRequest);

    ConsoleResponse toResponse(Console console);

    List<ConsoleResponse> toResponse(List<Console> console);
}
