package com.projeto.universojogos.core.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Console {
    private Integer id;
    private String nome;
    private String anoLancamento;
    private Plataforma plataforma;
}
