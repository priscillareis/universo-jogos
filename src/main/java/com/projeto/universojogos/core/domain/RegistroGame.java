package com.projeto.universojogos.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Usuario usuario;
    private float horasJogadas;
    private boolean todasConquistas;


}
