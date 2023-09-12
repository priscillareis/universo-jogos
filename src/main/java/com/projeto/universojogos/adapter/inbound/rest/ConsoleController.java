package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.dto.ConsoleRequest;
import com.projeto.universojogos.adapter.dto.ConsoleResponse;
import com.projeto.universojogos.application.port.inbound.ConsoleInbound;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {

    private final Logger LOGGER = Logger.getLogger(PlataformaController.class.getSimpleName());

    protected ModelMapper modelMapper = new ModelMapper();

    private final ConsoleInbound consoleInbound;

    public ConsoleController(ConsoleInbound consoleInbound) {
        this.consoleInbound = consoleInbound;
    }

    @PostMapping(value = "/cadastrar")
    ConsoleResponse cadastrar(@RequestHeader HttpHeaders headers,
                              @Validated(ValidacaoCadastro.class)
                              @RequestBody ConsoleRequest consoleRequest){
        return new ConsoleResponse();

    }
}
