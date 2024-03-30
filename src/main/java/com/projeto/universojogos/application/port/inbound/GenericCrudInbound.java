package com.projeto.universojogos.application.port.inbound;

public interface GenericCrudInbound<T> {

    T save(T entity) throws Exception;
}
