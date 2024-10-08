package com.projeto.universojogos.adapter.dto.colecao;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.config.validation.mensagens.MensagensValidacao;
import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class ColecaoRequest {
    @Min(value = 1,groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.ID_OBRIGATORIO)
    private int id;

    private String dataAquisicao;

    private BigDecimal valorAquisicao;

    @NotNull(groups = {ValidacaoCadastro.class}, message=MensagensValidacao.CONSOLE_OBRIGATORIO)
    private ConsoleRequest console;
}
