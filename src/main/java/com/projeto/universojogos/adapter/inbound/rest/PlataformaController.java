package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.plataforma.PlataformaMapper;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.Plataforma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/plataforma")
public class PlataformaController extends GenericCrudController<Plataforma, Long, PlataformaRequest,
        PlataformaResponse> {
    @Autowired
    private PlataformaInbound plataformaInbound;


    @Override
    public GenericCrudInbound<Plataforma, Long> getService() {
        return plataformaInbound;
    }

    @Override
    public GenericMapper<PlataformaRequest, PlataformaResponse, Plataforma> getMapper() {
        return PlataformaMapper.INSTANCE;
    }
}
