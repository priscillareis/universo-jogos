package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.PlataformaMapper;
import com.projeto.universojogos.adapter.outbound.PlataformaRepository;
import com.projeto.universojogos.application.port.outbound.PlataformaOutbound;
import com.projeto.universojogos.core.domain.Plataforma;
import com.projeto.universojogos.core.exception.NotFoundException;
import com.projeto.universojogos.core.util.LoggingBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlataformaDatastore implements PlataformaOutbound {

    private final LoggingBase LOGGER = new LoggingBase(PlataformaDatastore.class);

    private final PlataformaRepository plataformaRepository;

    @Override
    public Plataforma salvar(Plataforma plataforma) throws Exception {

        var entity = PlataformaMapper.INSTANCE.toEntity(plataforma);

        try {
            var result = plataformaRepository.save(entity);
            return PlataformaMapper.INSTANCE.toDomain(result);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Plataforma consultarPorId(Plataforma plataforma) throws Exception {

        var result = plataformaRepository.findById(plataforma.getId());

        if (result.isEmpty()) throw new NotFoundException("Plataforma não encontrada. Código solicitado: " +
                plataforma.getId());

        return PlataformaMapper.INSTANCE.toDomain(result.get());
    }

    @Override
    public Plataforma consultarPorNome(Plataforma plataforma) throws Exception {

        var result = plataformaRepository.findFirstByNomeContains(plataforma.getNome());

        if (result.isEmpty()) throw new NotFoundException("Plataforma não encontrada. Nome solicitado: " +
                plataforma.getNome());

        return PlataformaMapper.INSTANCE.toDomain(result.get());
    }

    @Override
    public Plataforma atualizar(Plataforma plataforma) throws Exception {
        var entity = PlataformaMapper.INSTANCE.toEntity(plataforma);
        var plataformaEncontrada = plataformaRepository.findById(entity.getId());

        if (plataformaEncontrada.isEmpty())
            throw new NotFoundException("Plataforma não encontrada. Código solicitado: " +
                    plataforma.getId());

        plataformaEncontrada.get().setNome(entity.getNome());

        try {
            var result = plataformaRepository.save(plataformaEncontrada.get());
            return PlataformaMapper.INSTANCE.toDomain(result);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void deletar(Plataforma plataforma) throws Exception {
        var entity = PlataformaMapper.INSTANCE.toEntity(plataforma);
        try {
            plataformaRepository.delete(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
