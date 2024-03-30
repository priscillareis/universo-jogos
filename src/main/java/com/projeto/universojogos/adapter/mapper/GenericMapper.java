package com.projeto.universojogos.adapter.mapper;

public interface GenericMapper<Request, Response, Domain> {

    Domain toDomain(Request request);

    Response toResponse(Domain domain);
}
