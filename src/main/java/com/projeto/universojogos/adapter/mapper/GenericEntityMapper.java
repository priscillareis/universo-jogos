package com.projeto.universojogos.adapter.mapper;

public interface GenericEntityMapper<Domain, Entity>{

    Entity toEntity(Domain domain);

    Domain toDomain(Entity entity);
}
