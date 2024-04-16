package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.plataforma.PlataformaEntityMapper;
import com.projeto.universojogos.adapter.outbound.PlataformaRepository;
import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import com.projeto.universojogos.application.port.outbound.PlataformaOutbound;
import com.projeto.universojogos.core.domain.Plataforma;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlataformaDatastore extends GenericCrudDatastore<Plataforma, Long, PlataformaEntity>
        implements PlataformaOutbound {

    @Autowired
    private final PlataformaRepository plataformaRepository;


    @Override
    protected JpaRepository<PlataformaEntity, Long> getRepository() {
        return plataformaRepository;
    }

    @Override
    public GenericEntityMapper<Plataforma, PlataformaEntity> getMapper() {
        return PlataformaEntityMapper.INSTANCE;
    }
}
