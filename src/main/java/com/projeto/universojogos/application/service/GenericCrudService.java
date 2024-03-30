package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.exception.ParametroInvalidoException;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericCrudService<T> implements GenericCrudInbound<T> {

    protected abstract GenericCrudOutbound<T> getOutbound();
    private final LoggingBase LOGGER = new LoggingBase("Service");

    @Override
    public T save(T dominio) throws Exception {
        if (dominio == null){
            LOGGER.createErroLog(null, dominio, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().save(dominio);
    }
}
