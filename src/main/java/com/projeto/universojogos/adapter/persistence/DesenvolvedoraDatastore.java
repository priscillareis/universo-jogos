package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.DesenvolvedoraEntityMapper;
import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.outbound.DesenvolvedoraRepository;
import com.projeto.universojogos.adapter.persistence.entity.DesenvolvedoraEntity;
import com.projeto.universojogos.application.port.outbound.DesenvolvedoraOutbound;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DesenvolvedoraDatastore extends GenericCrudDatastore<Desenvolvedora, Long, DesenvolvedoraEntity>
        implements DesenvolvedoraOutbound {
    @Autowired
    private DesenvolvedoraRepository desenvolvedoraRepository;

    @Override
    protected JpaRepository<DesenvolvedoraEntity, Long> getRepository() {
        return desenvolvedoraRepository;
    }

    @Override
    public GenericEntityMapper<Desenvolvedora, DesenvolvedoraEntity> getMapper() {
        return DesenvolvedoraEntityMapper.INSTANCE;
    }
}
