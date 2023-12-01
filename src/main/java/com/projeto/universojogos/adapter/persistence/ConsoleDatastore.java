package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.ConsoleMapper;
import com.projeto.universojogos.adapter.outbound.ConsoleRepository;
import com.projeto.universojogos.application.port.outbound.ConsoleOutbound;
import com.projeto.universojogos.core.domain.Console;
import com.projeto.universojogos.core.util.LoggingBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleDatastore implements ConsoleOutbound {
    private final LoggingBase LOGGER = new LoggingBase(ConsoleDatastore.class);

    private final ConsoleRepository consoleRepository;

    @Override
    public Console salvar(Console console) throws Exception {
        var entity = ConsoleMapper.INSTANCE.toEntity(console);
        try{
            var resultado = consoleRepository.save(entity);
            return ConsoleMapper.INSTANCE.toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
