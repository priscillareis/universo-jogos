package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.usuario.UsuarioEntityMapper;
import com.projeto.universojogos.adapter.outbound.UsuarioRepository;
import com.projeto.universojogos.adapter.persistence.entity.UsuarioEntity;
import com.projeto.universojogos.application.port.outbound.UsuarioOutbound;
import com.projeto.universojogos.core.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDatastore extends GenericCrudDatastore<Usuario, Long, UsuarioEntity> implements UsuarioOutbound {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Override
    protected JpaRepository<UsuarioEntity, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    public GenericEntityMapper<Usuario, UsuarioEntity> getMapper() {
        return UsuarioEntityMapper.INSTANCE;
    }
}
