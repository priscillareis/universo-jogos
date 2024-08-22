package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.usuario.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.usuario.UsuarioMapper;
import com.projeto.universojogos.application.port.inbound.*;
import com.projeto.universojogos.core.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController extends GenericCrudController<Usuario, Long, UsuarioRequest, UsuarioResponse> {

    @Autowired
    private UsuarioInbound usuarioInbound;

    @Override
    public GenericCrudInbound<Usuario, Long> getService() {
        return usuarioInbound;
    }

    @Override
    public GenericMapper<UsuarioRequest, UsuarioResponse, Usuario> getMapper() {
        return UsuarioMapper.INSTANCE;
    }
}
