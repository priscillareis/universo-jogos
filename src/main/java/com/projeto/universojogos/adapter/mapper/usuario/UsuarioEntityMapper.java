package com.projeto.universojogos.adapter.mapper.usuario;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.UsuarioEntity;
import com.projeto.universojogos.core.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioEntityMapper extends GenericEntityMapper<Usuario, UsuarioEntity> {

    UsuarioEntityMapper INSTANCE = Mappers.getMapper(UsuarioEntityMapper.class);

    Usuario toDomain(UsuarioEntity usuarioEntity);

    UsuarioEntity toEntity(Usuario usuario);
}