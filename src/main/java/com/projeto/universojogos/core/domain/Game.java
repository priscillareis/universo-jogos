package com.projeto.universojogos.core.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private String nome;
    private String anoLancamento;
    private Console console;
    private Desenvolvedora desenvolvedora;
}
