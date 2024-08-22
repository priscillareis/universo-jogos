package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.manutencao.ManutencaoEntityMapper;
import com.projeto.universojogos.adapter.outbound.ManutencaoRepository;
import com.projeto.universojogos.adapter.persistence.entity.ManutencaoEntity;
import com.projeto.universojogos.application.port.outbound.ManutencaoOutbound;
import com.projeto.universojogos.core.domain.Manutencao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManutencaoDatastore extends GenericCrudDatastore<Manutencao, Long, ManutencaoEntity> implements ManutencaoOutbound {

    @Autowired
    private final ManutencaoRepository manutencaoRepository;

    @Override
    protected JpaRepository<ManutencaoEntity, Long> getRepository() {
        return manutencaoRepository;
    }

    @Override
    public GenericEntityMapper<Manutencao, ManutencaoEntity> getMapper() {
        return ManutencaoEntityMapper.INSTANCE;
    }
}
