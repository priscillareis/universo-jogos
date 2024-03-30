package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public abstract class GenericCrudDatastore<T, ID extends Serializable, MT3> implements GenericCrudOutbound<T> {

    protected abstract JpaRepository<MT3, ID> getRepository();

    public abstract GenericEntityMapper<T, MT3> getMapper();

    @Override
    public T save(T dominio) throws Exception {

        var entidade = getMapper().toEntity(dominio);

        try {
            var resultado = getRepository().save(entidade);
            return getMapper().toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
