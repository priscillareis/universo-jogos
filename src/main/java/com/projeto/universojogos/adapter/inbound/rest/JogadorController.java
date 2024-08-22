package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.jogador.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.jogador.JogadorMapper;
import com.projeto.universojogos.application.port.inbound.*;
import com.projeto.universojogos.core.domain.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorController extends GenericCrudController<Jogador, Long, JogadorRequest, JogadorResponse> {

    @Autowired
    private JogadorInbound jogadorInbound;

    @Override
    public GenericCrudInbound<Jogador, Long> getService() {
        return jogadorInbound;
    }

    @Override
    public GenericMapper<JogadorRequest, JogadorResponse, Jogador> getMapper() {
        return JogadorMapper.INSTANCE;
    }
}
