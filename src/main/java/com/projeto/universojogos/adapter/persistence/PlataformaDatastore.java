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
    public Plataforma salvar(Plataforma plataforma) throws Exception {
        var entity = modelMapper.map(plataforma, PlataformaEntity.class);
        try {
            var result = plataformaRepository.save(entity);
            return modelMapper.map(result, Plataforma.class);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Plataforma consultar(Plataforma plataforma) throws Exception {
        var result = plataformaRepository.findById(plataforma.getId());

        if (result.isEmpty()) throw new NotFoundException("Plataforma não encontrada. Código solicitado: " +
                plataforma.getId());

        return modelMapper.map(result, Plataforma.class);
    }

    @Override
    public Plataforma atualizar(Plataforma plataforma) throws Exception {
        var entity = modelMapper.map(plataforma, PlataformaEntity.class);
        var plataformaEncontrada = plataformaRepository.findById(entity.getId());

        if (plataformaEncontrada.isEmpty())
            throw new NotFoundException("Plataforma não encontrada. Código solicitado: " +
                    plataforma.getId());

        plataformaEncontrada.get().setNome(entity.getNome());

        try {
            var result = plataformaRepository.save(plataformaEncontrada.get());
            return modelMapper.map(result, Plataforma.class);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void deletar(Plataforma plataforma) throws Exception {
        var entity = modelMapper.map(plataforma, PlataformaEntity.class);
        try {
            plataformaRepository.delete(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
