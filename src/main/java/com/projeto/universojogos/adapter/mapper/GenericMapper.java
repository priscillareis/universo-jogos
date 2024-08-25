package com.projeto.universojogos.adapter.mapper;

import java.util.List;

public interface GenericMapper<Request, Response, Domain> {

    Domain toDomain(Request request);

    Response toResponse(Domain domain);

    List<Response> toResponse(List<Domain> domain);
}
