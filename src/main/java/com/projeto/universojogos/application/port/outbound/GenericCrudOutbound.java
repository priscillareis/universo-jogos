package com.projeto.universojogos.application.port.outbound;

import java.io.Serializable;

public interface GenericCrudOutbound<T, ID extends Serializable> {

    T cadastrar(T dominio) throws Exception;

    T consultar(ID id) throws Exception;

    T atualizar(ID id, T dominio) throws Exception;

    void deletar(ID id) throws Exception;
}
