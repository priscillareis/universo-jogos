package com.projeto.universojogos.core.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Console {
    private int id;
    private String nome;
    private String anoLancamento;
    private Plataforma plataforma;
}
