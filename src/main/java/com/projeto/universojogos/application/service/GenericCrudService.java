package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.exception.ParametroInvalidoException;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class GenericCrudService<Dominio, ID extends Serializable> implements GenericCrudInbound<Dominio, ID> {

    protected abstract GenericCrudOutbound<Dominio, ID> getOutbound();
    private final LoggingBase LOGGER = new LoggingBase("Service");

    @Override
    public Dominio cadastrar(Dominio dominio) throws Exception {
        if (dominio == null){
            LOGGER.createErroLog(null, null, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().cadastrar(dominio);
    }

    @Override
    public List<Dominio> consultarTodos() throws Exception {
        return getOutbound().consultarTodos();
    }

    @Override
    public Dominio consultar(ID id) throws Exception {
        if (id == null){
            LOGGER.createErroLog(null, null, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().consultar(id);
    }

    @Override
    public Dominio atualizar(ID id, Dominio dominio) throws Exception {
        if (id == null || dominio == null){
            LOGGER.createErroLog(null, id+" - "+dominio, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }
        return getOutbound().atualizar(id, dominio);
    }

    @Override
    public void deletar(ID id) throws Exception {
        if (id == null){
            LOGGER.createErroLog(null, null, TipoLog.PROCESSO,"Recurso informado nulo.");

            throw new ParametroInvalidoException("Recurso informado é inválido.");
        }

        getOutbound().deletar(id);
    }
}
