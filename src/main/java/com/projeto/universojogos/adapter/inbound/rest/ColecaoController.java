package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.colecao.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.colecao.ColecaoMapper;
import com.projeto.universojogos.application.port.inbound.*;
import com.projeto.universojogos.core.domain.Colecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/colecao")
public class ColecaoController extends GenericCrudController<Colecao, Long, ColecaoRequest, ColecaoResponse> {

    @Autowired
    private ColecaoInbound colecaoInbound;
    @Override
    public GenericCrudInbound<Colecao, Long> getService() { return colecaoInbound; }

    @Override
    public GenericMapper<ColecaoRequest, ColecaoResponse, Colecao> getMapper() { return ColecaoMapper.INSTANCE; }
}
