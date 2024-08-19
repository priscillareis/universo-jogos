package com.projeto.universojogos.adapter.dto.registroGame;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.config.validation.mensagens.MensagensValidacao;
import com.projeto.universojogos.adapter.dto.game.GameRequest;
import com.projeto.universojogos.adapter.dto.jogador.JogadorRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RegistroGameRequest {
    @Min(value = 1,groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.ID_OBRIGATORIO)
    private int id;

    private String dataInicio;

    private String dataFim;

    @NotBlank(groups = {ValidacaoCadastro.class}, message = MensagensValidacao.GAME_OBRIGATORIO)
    private GameRequest game;

    @NotBlank(groups = {ValidacaoCadastro.class}, message = MensagensValidacao.JOGADOR_OBRIGATORIO)
    private JogadorRequest jogador;

    private BigDecimal horasJogadas;

    private boolean todasConquistas;

}
