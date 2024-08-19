package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.UsuarioInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.application.port.outbound.UsuarioOutbound;
import com.projeto.universojogos.core.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService extends GenericCrudService<Usuario, Long> implements UsuarioInbound {

    @Autowired
    private final UsuarioOutbound usuarioOutbound;

    @Override
    protected GenericCrudOutbound<Usuario, Long> getOutbound() { return usuarioOutbound; }
}
