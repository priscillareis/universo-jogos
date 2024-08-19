package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.registroGame.RegistroGameEntityMapper;
import com.projeto.universojogos.adapter.outbound.RegistroGameRepository;
import com.projeto.universojogos.adapter.persistence.entity.RegistroGameEntity;
import com.projeto.universojogos.application.port.outbound.RegistroGameOutbound;
import com.projeto.universojogos.core.domain.RegistroGame;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistroGameDatastore extends GenericCrudDatastore<RegistroGame, Long, RegistroGameEntity>
        implements RegistroGameOutbound {

    @Autowired
    private final RegistroGameRepository registroGameRepository;

    @Override
    protected JpaRepository<RegistroGameEntity, Long> getRepository() {
        return registroGameRepository;
    }

    @Override
    public GenericEntityMapper<RegistroGame, RegistroGameEntity> getMapper() {
        return RegistroGameEntityMapper.INSTANCE;
    }
}
