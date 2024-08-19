package com.projeto.universojogos.adapter.dto.registroGame;

import com.projeto.universojogos.adapter.dto.game.GameResponse;
import com.projeto.universojogos.adapter.dto.jogador.JogadorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RegistroGameResponse {

    private int id;
    private Date dataInicio;
    private Date dataFim;
    private GameResponse game;
    private JogadorResponse jogador;
    private BigDecimal horasJogadas;
    private boolean todasConquistas;
}
