package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.console.*;
import com.projeto.universojogos.adapter.mapper.*;
import com.projeto.universojogos.adapter.mapper.console.ConsoleMapper;
import com.projeto.universojogos.application.port.inbound.*;
import com.projeto.universojogos.core.domain.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController extends GenericCrudController<Console, Long, ConsoleRequest,
        ConsoleResponse>{
    @Autowired
    private ConsoleInbound consoleInbound;

    @Override
    public GenericCrudInbound<Console, Long> getService() { return consoleInbound; }

    @Override
    public GenericMapper<ConsoleRequest, ConsoleResponse, Console> getMapper() {
        return ConsoleMapper.INSTANCE;
    }
}
