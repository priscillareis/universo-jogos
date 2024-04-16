package com.projeto.universojogos.adapter.dto.game;

import com.projeto.universojogos.adapter.dto.console.ConsoleResponse;
import com.projeto.universojogos.adapter.dto.desenvolvedora.DesenvolvedoraResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private int id;
    private String nome;
    private String anoLancamento;
    private ConsoleResponse console;
    private DesenvolvedoraResponse desenvolvedora;
}
