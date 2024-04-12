package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.desenvolvedora.*;
import com.projeto.universojogos.adapter.mapper.*;
import com.projeto.universojogos.application.port.inbound.*;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/desenvolvedora")
public class DesenvolvedoraController extends GenericCrudController<Desenvolvedora, Long, DesenvolvedoraRequest,
        DesenvolvedoraResponse> {

    @Autowired
    private DesenvolvedoraInbound desenvolvedoraInbound;

    @Override
    public GenericCrudInbound<Desenvolvedora, Long> getService() {
        return desenvolvedoraInbound;
    }

    @Override
    public GenericMapper<DesenvolvedoraRequest, DesenvolvedoraResponse, Desenvolvedora> getMapper() {
        return DesenvolvedoraMapper.INSTANCE;
    }
}
