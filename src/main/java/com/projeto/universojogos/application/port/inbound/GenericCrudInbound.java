package com.projeto.universojogos.application.port.inbound;

import java.io.Serializable;
import java.util.List;

public interface GenericCrudInbound<Dominio, ID extends Serializable> {

    Dominio cadastrar(Dominio dominio) throws Exception;

    Dominio consultar(ID id) throws Exception;

    List<Dominio> consultarTodos() throws Exception;

    Dominio atualizar(ID id, Dominio dominio) throws Exception;

    void deletar(ID id) throws Exception;
}
