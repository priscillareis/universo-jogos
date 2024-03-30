package com.projeto.universojogos.adapter.rest;

import com.projeto.universojogos.adapter.dto.desenvolvedora.*;
import com.projeto.universojogos.adapter.mapper.DesenvolvedoraMapper;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.inbound.DesenvolvedoraInbound;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/desenvolvedora")
public class DesenvolvedoraController extends GenericCrudController<Desenvolvedora, DesenvolvedoraRequest,
        DesenvolvedoraResponse> {

    @Autowired
    private DesenvolvedoraInbound desenvolvedoraInbound;

    private final LoggingBase LOGGER = new LoggingBase(DesenvolvedoraController.class);

    @Override
    public GenericCrudInbound<Desenvolvedora> getService() {
        return desenvolvedoraInbound;
    }

    @Override
    public GenericMapper<DesenvolvedoraRequest, DesenvolvedoraResponse, Desenvolvedora> getMapper() {
        return DesenvolvedoraMapper.INSTANCE;
    }
}
