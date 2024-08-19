package com.projeto.universojogos.core.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private String nome;
    private String anoLancamento;
    private Date dataAquisicao;
    private BigDecimal valorAquisicao;
    private Console console;
    private Desenvolvedora desenvolvedora;
}
