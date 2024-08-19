package com.projeto.universojogos.adapter.mapper.usuario;

import com.projeto.universojogos.adapter.dto.usuario.UsuarioRequest;
import com.projeto.universojogos.adapter.dto.usuario.UsuarioResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper extends GenericMapper<UsuarioRequest, UsuarioResponse, Usuario> {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toDomain(UsuarioRequest usuarioRequest);

    UsuarioResponse toResponse(Usuario usuario);
}
