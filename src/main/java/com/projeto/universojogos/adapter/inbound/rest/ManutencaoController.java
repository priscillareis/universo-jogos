package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.manutencao.ManutencaoRequest;
import com.projeto.universojogos.adapter.dto.manutencao.ManutencaoResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.manutencao.ManutencaoMapper;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.inbound.ManutencaoInbound;
import com.projeto.universojogos.core.domain.Manutencao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manutencao")
public class ManutencaoController extends GenericCrudController<Manutencao, Long, ManutencaoRequest,
        ManutencaoResponse> {

    @Autowired
    private ManutencaoInbound manutencaoInbound;

    @Override
    public GenericCrudInbound<Manutencao, Long> getService() {
        return manutencaoInbound;
    }

    @Override
    public GenericMapper<ManutencaoRequest, ManutencaoResponse, Manutencao> getMapper() {
        return ManutencaoMapper.INSTANCE;
    }

}
