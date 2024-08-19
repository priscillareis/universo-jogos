package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.jogador.JogadorEntityMapper;
import com.projeto.universojogos.adapter.outbound.JogadorRepository;
import com.projeto.universojogos.adapter.persistence.entity.JogadorEntity;
import com.projeto.universojogos.application.port.outbound.JogadorOutbound;
import com.projeto.universojogos.core.domain.Jogador;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JogadorDatastore extends GenericCrudDatastore<Jogador, Long, JogadorEntity> implements JogadorOutbound {

    @Autowired
    private final JogadorRepository jogadorRepository;

    @Override
    protected JpaRepository<JogadorEntity, Long> getRepository() { return jogadorRepository; }

    @Override
    public GenericEntityMapper<Jogador, JogadorEntity> getMapper() { return JogadorEntityMapper.INSTANCE; }
}
