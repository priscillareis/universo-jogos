package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.colecao.ColecaoEntityMapper;
import com.projeto.universojogos.adapter.outbound.ColecaoRepository;
import com.projeto.universojogos.adapter.persistence.entity.ColecaoEntity;
import com.projeto.universojogos.application.port.outbound.ColecaoOutbound;
import com.projeto.universojogos.core.domain.Colecao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ColecaoDatastore extends GenericCrudDatastore<Colecao, Long, ColecaoEntity> implements ColecaoOutbound {

    @Autowired
    private final ColecaoRepository colecaoRepository;

    @Override
    protected JpaRepository<ColecaoEntity, Long> getRepository() { return colecaoRepository; }

    @Override
    public GenericEntityMapper<Colecao, ColecaoEntity> getMapper() { return ColecaoEntityMapper.INSTANCE; }
}
