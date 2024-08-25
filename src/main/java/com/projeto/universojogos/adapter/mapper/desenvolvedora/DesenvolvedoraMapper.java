package com.projeto.universojogos.adapter.mapper.desenvolvedora;

import com.projeto.universojogos.adapter.dto.desenvolvedora.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DesenvolvedoraMapper extends GenericMapper<DesenvolvedoraRequest, DesenvolvedoraResponse,
        Desenvolvedora> {

    DesenvolvedoraMapper INSTANCE = Mappers.getMapper(DesenvolvedoraMapper.class);

    Desenvolvedora toDomain(DesenvolvedoraRequest desenvolvedoraRequest);

    DesenvolvedoraResponse toResponse(Desenvolvedora desenvolvedora);

    List<DesenvolvedoraResponse> toResponse(List<Desenvolvedora> desenvolvedora);

}
