package com.projeto.universojogos.adapter.mapper;

import java.util.List;

public interface GenericEntityMapper<Domain, Entity>{

    Entity toEntity(Domain domain);

    Domain toDomain(Entity entity);

    List<Domain> toDomain(List<Entity> entity);
}
