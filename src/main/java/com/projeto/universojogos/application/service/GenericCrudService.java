package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.exception.ParametroInvalidoException;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public abstract class GenericCrudService<T, ID extends Serializable> implements GenericCrudInbound<T, ID> {

    protected abstract GenericCrudOutbound<T, ID> getOutbound();
    private final LoggingBase LOGGER = new LoggingBase("Service");

    @Override
    public T cadastrar(T dominio) throws Exception {
        if (dominio == null){
            LOGGER.createErroLog(null, dominio, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().cadastrar(dominio);
    }

    @Override
    public T consultar(ID id) throws Exception {
        if (id == null){
            LOGGER.createErroLog(null, id, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().consultar(id);
    }

    @Override
    public T atualizar(ID id, T dominio) throws Exception {
        if (id == null || dominio == null){
            LOGGER.createErroLog(null, id, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().atualizar(id, dominio);
    }

    @Override
    public void deletar(ID id) throws Exception {
        if (id == null){
            LOGGER.createErroLog(null, id, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }

        getOutbound().deletar(id);
    }
}
