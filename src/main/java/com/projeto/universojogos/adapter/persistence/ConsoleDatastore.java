package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.console.ConsoleEntityMapper;
import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.outbound.ConsoleRepository;
import com.projeto.universojogos.adapter.persistence.entity.ConsoleEntity;
import com.projeto.universojogos.application.port.outbound.ConsoleOutbound;
import com.projeto.universojogos.core.domain.Console;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleDatastore extends GenericCrudDatastore<Console, Long, ConsoleEntity> implements ConsoleOutbound {

    @Autowired
    private final ConsoleRepository consoleRepository;

    @Override
    protected JpaRepository<ConsoleEntity, Long> getRepository() {
        return consoleRepository;
    }

    @Override
    public GenericEntityMapper<Console, ConsoleEntity> getMapper() {
        return ConsoleEntityMapper.INSTANCE;
    }

}
