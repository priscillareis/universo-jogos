package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public abstract class GenericCrudDatastore<T, ID extends Serializable, MT3> implements GenericCrudOutbound<T, ID> {

    protected abstract JpaRepository<MT3, ID> getRepository();

    public abstract GenericEntityMapper<T, MT3> getMapper();

    @Override
    public T cadastrar(T dominio) throws Exception {

        var entidade = getMapper().toEntity(dominio);

        try {
            var resultado = getRepository().save(entidade);
            return getMapper().toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public T consultar(ID id) throws Exception {
        try {
            var resultado = getRepository().findById(id);
            if(resultado.isEmpty()){
                throw new NotFoundException("Recurso não encontrado. Código solicitado: "+
                        id);
            }
            return getMapper().toDomain(resultado.get());
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public List<T> consultarTodos() throws Exception{
        try{
            var resultado = getRepository().findAll();
            if(resultado.isEmpty()){
                throw new NotFoundException("Nenhum recurso encontrado.");
            }
            return getMapper().toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public T atualizar(ID id, T dominio) throws Exception {
        if(!getRepository().existsById(id)){
            throw new NotFoundException("Recurso não encontrado. Código solicitado: "+ id);
        }
        var entidade = getMapper().toEntity(dominio);

        try {
            var resultado = getRepository().save(entidade);
            return getMapper().toDomain(resultado);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @Override
    public void deletar(ID id) throws Exception {
        if(!getRepository().existsById(id)){
            throw new NotFoundException("Recurso não encontrado. Código solicitado: "+ id);
        }
        try {
            getRepository().deleteById(id);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
