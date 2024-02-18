package com.projeto.universojogos.adapter.dto.console;

import com.projeto.universojogos.adapter.dto.plataforma.PlataformaResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleResponse {
    private int id;
    private String nome;
    private String anoLancamento;
    private PlataformaResponse plataforma;
}
