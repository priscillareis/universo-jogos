package com.projeto.universojogos.adapter.dto.colecao;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.config.validation.mensagens.MensagensValidacao;
import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import jakarta.validation.constraints.Min;
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
public class ColecaoRequest {
    @Min(value = 1,groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.ID_OBRIGATORIO)
    private int id;

    private Date dataAquisicao;

    private BigDecimal valorAquisicao;

    private ConsoleRequest console;
}
