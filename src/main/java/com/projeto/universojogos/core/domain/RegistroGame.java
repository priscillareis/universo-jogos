package com.projeto.universojogos.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroGame {

    private int id;
    private Date dataInicio;
    private Date dataFim;
    private Game game;
    private Jogador jogador;
    private BigDecimal horasJogadas;
    private boolean todasConquistas;


}
