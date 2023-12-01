package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.ConsoleRequest;
import com.projeto.universojogos.adapter.dto.ConsoleResponse;
import com.projeto.universojogos.adapter.dto.PlataformaRequest;
import com.projeto.universojogos.adapter.dto.PlataformaResponse;
import com.projeto.universojogos.adapter.persistence.entity.ConsoleEntity;
import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import com.projeto.universojogos.core.domain.Console;
import com.projeto.universojogos.core.domain.Plataforma;
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
