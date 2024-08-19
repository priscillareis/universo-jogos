package com.projeto.universojogos.adapter.dto.game;

import com.projeto.universojogos.adapter.dto.console.ConsoleResponse;
import com.projeto.universojogos.adapter.dto.desenvolvedora.DesenvolvedoraResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private int id;
    private String nome;
    private String anoLancamento;
    private String dataAquisicao;
    private BigDecimal valorAquisicao;
    private ConsoleResponse console;
    private DesenvolvedoraResponse desenvolvedora;
}
