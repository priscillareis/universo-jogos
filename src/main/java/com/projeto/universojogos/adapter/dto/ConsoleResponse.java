package com.projeto.universojogos.adapter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleResponse {
    private Integer id;
    private String nome;
    private String anoLancamento;
    private PlataformaResponse plataforma;
}
