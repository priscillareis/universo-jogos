package com.projeto.universojogos.application.port.outbound;

public interface GenericCrudOutbound<T> {

    T save(T dominio) throws Exception;
}
