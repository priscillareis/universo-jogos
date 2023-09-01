package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.outbound.PlataformaRepository;
import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import com.projeto.universojogos.application.port.outbound.PlataformaOutbound;
import com.projeto.universojogos.core.domain.Plataforma;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.projeto.universojogos.core.exception.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlataformaDatastore implements PlataformaOutbound {

    private final PlataformaRepository plataformaRepository;

    protected ModelMapper modelMapper = new ModelMapper();

    @Override
    public Plataforma salvar(Plataforma plataforma) {
        var entity = modelMapper.map(plataforma, PlataformaEntity.class);
        var result = plataformaRepository.save(entity);
        return modelMapper.map(result, Plataforma.class);
    }

    @Override
    public Plataforma consultar(Plataforma plataforma) throws Exception {
        var result = plataformaRepository.findById(plataforma.getId());

        if (result.isEmpty()) throw new NotFoundException("Plataforma não encontrada. Código solicitado: "+
                plataforma.getId());

        return modelMapper.map(result, Plataforma.class);
    }
}
